package supercoder79.updater.update;

import supercoder79.updater.code.ClassData;
import supercoder79.updater.match.Matcher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public final class ClassUpdater {
    public static void update(Update update, ClassData data, File file) {
        if (data == null) {
            return;
        }

        Matcher matcher = update.when();
        List<String> updatedLines = new ArrayList<>();

        boolean appliedUpdate = false;
        for (int i = data.startIdx(); i < data.lines().size(); i++) {
            String curr = data.lines().get(i);

            while (true) {
                List<Integer> points = matcher.match(curr);

                boolean updated = false;
                for (Integer point : points) {
                    UpdateResult res = update.update(curr, i, point, data.lines(), data);
                    if (res.updated()) {
                        curr = res.result();
                        updated = true;
                        appliedUpdate = true;
                        break;
                    }
                }

                if (!updated) {
                    break;
                }
            }

            updatedLines.add(curr);
        }

        // Finalize if we've updated this class at all
        if (appliedUpdate) {
            update.finalize(data);
        }

        List<String> newLines = new ArrayList<>();
        int importsStart = -1;
        int importCount = 0;
        // Add the lines above the class definition
        for (int i = 0; i < data.startIdx(); i++) {
            // Skip the imports, we add them later
            String line = data.lines().get(i);
            if (line.startsWith("import ")) {
                if (importsStart == -1) {
                    importsStart = i;
                }

                importCount++;

                newLines.add("");
                continue;
            }

            newLines.add(line);
        }

        // Process imports
        int emptyLines = 0;
        if (importsStart > -1) {
            // Should match import count of data.imports()
            for (int i = 0; i < data.imports().size(); i++) {
                String imp = "import " + data.imports().getQualified(i) + ";";

                if (data.lines().get(i + importsStart).equals("")) {
                    newLines.add(importsStart + i - 1, "");
                    emptyLines++;
                }

                // More than before- add
                if (i > importCount) {
                    newLines.add(importsStart + i, imp);
                } else {
                    // Within old lines, set
                    newLines.set(importsStart + i, imp);
                }
            }
        }

        // TODO: why is this needed???
        if (emptyLines > 0) {
            emptyLines++;
        }

        // Pop off empty lines we may have added
        for (int i = 0; i < emptyLines; i++) {
            newLines.remove(newLines.size() - 1);
        }

        newLines.addAll(updatedLines);

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(file));

            for (String line : newLines) {
                writer.println(line);
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error writing file " + file.getAbsolutePath());
        }
    }
}

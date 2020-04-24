package supercoder79.ecotones.api;

import net.minecraft.block.Blocks;

public enum TreeType {
    OAK(new TreeGenerationConfig(1, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState(), 4, 4, 6, 18, 0.75, 0.5)),
    DRY_OAK(new TreeGenerationConfig(0.2, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState(), 3, 6, 6, 12, 0.35, 0.25)),
    RARE_LARGE_OAK(new TreeGenerationConfig(0.06, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState(), 3, 5, 12, 6, 0.5, 0.35)),
    BIRCH(new TreeGenerationConfig(1, Blocks.BIRCH_LOG.getDefaultState(), Blocks.BIRCH_LEAVES.getDefaultState(), -1, -1, 8, 20, 0.25, 0.25)),
    DRY_BIRCH(new TreeGenerationConfig(0.7, Blocks.BIRCH_LOG.getDefaultState(), Blocks.BIRCH_LEAVES.getDefaultState(), -1, -1, 5, 12, 0.4, 0.4));

    public final TreeGenerationConfig config;

    TreeType(TreeGenerationConfig config) {
        this.config = config;
    }
}

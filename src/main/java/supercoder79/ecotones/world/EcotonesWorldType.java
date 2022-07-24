package supercoder79.ecotones.world;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import net.minecraft.world.biome.source.TheEndBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.WorldPreset;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import supercoder79.ecotones.Ecotones;
import supercoder79.ecotones.world.gen.EcotonesBiomeSource;
import supercoder79.ecotones.world.gen.EcotonesChunkGenerator;

import java.util.Map;

public final class EcotonesWorldType {
    public static final RegistryKey<WorldPreset> ECOTONES = of(Ecotones.id("ecotones"));

    private static RegistryKey<WorldPreset> of(Identifier id) {
        return RegistryKey.of(Registry.WORLD_PRESET_KEY, id);
    }

    private static final RegistryEntry<DimensionType> theNetherDimensionType = BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.THE_NETHER);
    private static final RegistryEntry<ChunkGeneratorSettings> netherChunkGeneratorSettings = BuiltinRegistries.CHUNK_GENERATOR_SETTINGS
            .getOrCreateEntry(ChunkGeneratorSettings.NETHER);
    private static final DimensionOptions netherDimensionOptions = new DimensionOptions(
            theNetherDimensionType,
            new NoiseChunkGenerator(
                    BuiltinRegistries.STRUCTURE_SET,
                    BuiltinRegistries.NOISE_PARAMETERS,
                    MultiNoiseBiomeSource.Preset.NETHER.getBiomeSource(BuiltinRegistries.BIOME),
                    netherChunkGeneratorSettings
            )
    );
    private static final RegistryEntry<DimensionType> theEndDimensionType = BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.THE_END);
    private static final RegistryEntry<ChunkGeneratorSettings> endChunkGeneratorSettings = BuiltinRegistries.CHUNK_GENERATOR_SETTINGS
            .getOrCreateEntry(ChunkGeneratorSettings.END);
    private static final DimensionOptions endDimensionOptions = new DimensionOptions(
            theEndDimensionType,
            new NoiseChunkGenerator(BuiltinRegistries.STRUCTURE_SET, BuiltinRegistries.NOISE_PARAMETERS, new TheEndBiomeSource(BuiltinRegistries.BIOME), endChunkGeneratorSettings)
    );


    public static void init() {
        Registry.register(BuiltinRegistries.WORLD_PRESET, Ecotones.id("ecotones"), createPreset(createEcotonesOptions(
                new EcotonesChunkGenerator(null, new EcotonesBiomeSource(BuiltinRegistries.BIOME, 0, false), 0))));
    }
    private static WorldPreset createPreset(DimensionOptions dimensionOptions) {
        return new WorldPreset(
                Map.of(DimensionOptions.OVERWORLD, dimensionOptions, DimensionOptions.NETHER, netherDimensionOptions, DimensionOptions.END, endDimensionOptions)
        );
    }

    private static DimensionOptions createEcotonesOptions(ChunkGenerator chunkGenerator) {
        return new DimensionOptions(BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.OVERWORLD), chunkGenerator);
    }

//    @Override
//    protected ChunkGenerator getChunkGenerator(DynamicRegistryManager registryManager, long seed) {
//        return new EcotonesChunkGenerator(registryManager.get(Registry.STRUCTURE_SET_KEY), new EcotonesBiomeSource(registryManager.get(Registry.BIOME_KEY), seed), seed);
//    }
}

package supercoder79.ecotones.world.biome.climatic;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.ecotones.api.Climate;
import supercoder79.ecotones.api.SimpleTreeDecorationData;
import supercoder79.ecotones.blocks.EcotonesBlocks;
import supercoder79.ecotones.world.biome.BiomeHelper;
import supercoder79.ecotones.world.biome.EcotonesBiomeBuilder;
import supercoder79.ecotones.world.decorator.EcotonesDecorators;
import supercoder79.ecotones.world.decorator.ShrubDecoratorConfig;
import supercoder79.ecotones.world.features.EcotonesFeatures;
import supercoder79.ecotones.world.features.config.FeatureConfigHolder;
import supercoder79.ecotones.world.features.config.SimpleTreeFeatureConfig;
import supercoder79.ecotones.world.structure.EcotonesConfiguredStructures;

public class HazelGroveBiome extends EcotonesBiomeBuilder {
    public static Biome INSTANCE;
    public static Biome CLEARING;
    public static Biome HILLY;
    public static Biome HILLY_CLEARING;

    public static TreeFeatureConfig HAZEL_CONFIG =
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                    new StraightTrunkPlacer(6, 2, 0),
                    new SimpleBlockStateProvider(EcotonesBlocks.HAZEL_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(EcotonesBlocks.HAZEL_SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(2, 0, 2))
        .ignoreVines().build();

    public static void init() {
        INSTANCE = Registry.register(BuiltinRegistries.BIOME, new Identifier("ecotones", "hazel_grove"), new HazelGroveBiome(false, false).build());
        CLEARING = Registry.register(BuiltinRegistries.BIOME, new Identifier("ecotones", "hazel_grove_clearing"), new HazelGroveBiome(true, false).build());
        HILLY = Registry.register(BuiltinRegistries.BIOME, new Identifier("ecotones", "hazel_grove_hilly"), new HazelGroveBiome(false, true).build());
        HILLY_CLEARING = Registry.register(BuiltinRegistries.BIOME, new Identifier("ecotones", "hazel_grove_hilly_clearing"), new HazelGroveBiome(true, true).build());
        Climate.HOT_VERY_HUMID.add(INSTANCE, 0.1);
        Climate.HOT_HUMID.add(INSTANCE, 0.1);
    }


    protected HazelGroveBiome(boolean clearing, boolean hilly) {
        this.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG);

        this.depth(hilly ? 0.9f : 0.25f);
        this.scale(hilly ? 0.6f : 0.05f);
        this.temperature(1F);
        this.downfall(1F);
        this.category(Biome.Category.FOREST);

        this.precipitation(Biome.Precipitation.RAIN);

        this.grassColor(0xaebd11);
        this.foliageColor(0xa67c12);
        this.skyColor(0xc6e4f5);

        this.hilliness(hilly ? 4.0 : 1.5);
        this.volatility(hilly ? 0.8 : 1.0);

        this.addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD);
        this.addStructureFeature(EcotonesConfiguredStructures.CAMPFIRE_OAK);

        if (clearing) {
            this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                    Feature.TREE.configure(HAZEL_CONFIG)
                            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.5f, 1)))
                            .spreadHorizontally()
                            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))));

            this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                    EcotonesFeatures.SHRUB.configure(new SimpleTreeFeatureConfig(Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState()))
                            .decorate(EcotonesDecorators.SHRUB_PLACEMENT_DECORATOR.configure(new ShrubDecoratorConfig(6))));
        } else {
            this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                    Feature.TREE.configure(HAZEL_CONFIG)
                            .decorate(EcotonesDecorators.SIMPLE_TREE_DECORATOR.configure(new SimpleTreeDecorationData(3.5))));

            this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                    EcotonesFeatures.SHRUB.configure(new SimpleTreeFeatureConfig(Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState()))
                            .decorate(EcotonesDecorators.SHRUB_PLACEMENT_DECORATOR.configure(new ShrubDecoratorConfig(3))));
        }

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                EcotonesFeatures.WIDE_SHRUB.configure(new SimpleTreeFeatureConfig(Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState()))
                        .decorate(EcotonesDecorators.SHRUB_PLACEMENT_DECORATOR.configure(new ShrubDecoratorConfig(clearing ? 1.4 : 0.95))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.configure(FeatureConfigHolder.RARELY_SHORT_GRASS_CONFIG)
                        .decorate(Decorator.SPREAD_32_ABOVE.configure(NopeDecoratorConfig.INSTANCE))
                        .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
                        .spreadHorizontally()
                        .decorate(Decorator.COUNT_NOISE.configure(new CountNoiseDecoratorConfig(-0.8D, 4, 8))));

        this.addFeature(GenerationStep.Feature.LAKES,
                EcotonesFeatures.SMALL_ROCK.configure(FeatureConfig.DEFAULT)
                        .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)))
                        .spreadHorizontally()
                        .applyChance(8));

        DefaultBiomeFeatures.addDefaultDisks(this.getGenerationSettings());
        DefaultBiomeFeatures.addLandCarvers(this.getGenerationSettings());
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this.getGenerationSettings());
        DefaultBiomeFeatures.addDungeons(this.getGenerationSettings());
        DefaultBiomeFeatures.addMineables(this.getGenerationSettings());
        DefaultBiomeFeatures.addDefaultOres(this.getGenerationSettings());
        DefaultBiomeFeatures.addAmethystGeodes(this.getGenerationSettings());
        DefaultBiomeFeatures.addDefaultMushrooms(this.getGenerationSettings());
        DefaultBiomeFeatures.addSprings(this.getGenerationSettings());
        DefaultBiomeFeatures.addFrozenTopLayer(this.getGenerationSettings());

        BiomeHelper.addDefaultSpawns(this.getSpawnSettings());
        BiomeHelper.addDefaultFeatures(this);
    }
}

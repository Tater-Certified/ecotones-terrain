package supercoder79.ecotones.world.features.config;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import supercoder79.ecotones.blocks.HeadBlocks;
import supercoder79.ecotones.world.features.foliage.PlusLeavesFoliagePlacer;
import supercoder79.ecotones.world.features.foliage.SmallPineFoliagePlacer;
import supercoder79.ecotones.world.features.mc.RandomPatchFeatureConfig;
import supercoder79.ecotones.world.treedecorator.LeafPileTreeDecorator;
import supercoder79.ecotones.world.treedecorator.LichenTreeDecorator;
import supercoder79.ecotones.world.treedecorator.PineconeTreeDecorator;

import java.util.Optional;
import java.util.OptionalInt;

public final class FeatureConfigHolder {
    public static DataPool.Builder<BlockState> pool() {
        return DataPool.builder();
    }
    
    // grass
    public static final RandomPatchFeatureConfig REEDS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.SUGAR_CANE.getDefaultState(), 1)
                    .add(Blocks.GRASS.getDefaultState(), 3))).tries(16).build();

    public static final RandomPatchFeatureConfig MOSTLY_SHORT_GRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.GRASS.getDefaultState(), 1)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 8))).tries(32).build();

    public static final RandomPatchFeatureConfig SCRUBLAND_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.GRASS.getDefaultState(), 6)
                    .add(Blocks.OAK_SAPLING.getDefaultState(), 2)
                    .add(Blocks.GRASS.getDefaultState(), 1))).tries(32).build();

    public static final RandomPatchFeatureConfig COOL_SCRUBLAND_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.GRASS.getDefaultState(), 4)
                    .add(Blocks.OAK_SAPLING.getDefaultState(), 5)
                    .add(Blocks.GRASS.getDefaultState(), 1))).tries(48).build();

    public static final RandomPatchFeatureConfig SHORT_GRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.TALL_GRASS.getDefaultState(), 1)
                    .add(Blocks.GRASS.getDefaultState(), 2))).tries(32).build();

    public static final RandomPatchFeatureConfig RARELY_SHORT_GRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.GRASS.getDefaultState(), 4))).tries(32).build();

    public static final RandomPatchFeatureConfig PRAIRIE_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.TALL_GRASS.getDefaultState(), 3)
                    .add(Blocks.CORNFLOWER.getDefaultState(), 1)
                    .add(Blocks.GRASS.getDefaultState(), 6))).tries(32).build();

    public static final RandomPatchFeatureConfig GRASSLAND_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.CORNFLOWER.getDefaultState(), 1)
                    .add(Blocks.GRASS.getDefaultState(), 4)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 1))).tries(32).build();

    public static final RandomPatchFeatureConfig BIRCH_GROVE_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.POPPY.getDefaultState(), 1)
                    .add(Blocks.GRASS.getDefaultState(), 8)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 2))).tries(32).build();
    
    public static final RandomPatchFeatureConfig SWITCHGRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.TALL_GRASS.getDefaultState(), 1)))
                    .tries(72).build();

    public static final RandomPatchFeatureConfig LUSH_SHRUBLAND_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.DANDELION.getDefaultState(), 2)
                    .add(Blocks.ALLIUM.getDefaultState(), 2)
                    .add(Blocks.ROSE_BUSH.getDefaultState(), 1)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 4)
                    .add(Blocks.GRASS.getDefaultState(), 8))).tries(32).build();

    public static final RandomPatchFeatureConfig DRY_STEPPE_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.DEAD_BUSH.getDefaultState(), 1)
                    .add(Blocks.SAND.getDefaultState(), 4)
                    .add(Blocks.GRASS.getDefaultState(), 2))).tries(32).build();
    

    public static final RandomPatchFeatureConfig TAIGA_GRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.CORNFLOWER.getDefaultState(), 1)
                    .add(Blocks.GRASS.getDefaultState(), 4)
                    .add(Blocks.FERN.getDefaultState(), 4)
                    .add(Blocks.LARGE_FERN.getDefaultState(), 1)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 1))).tries(32).build();

    public static final RandomPatchFeatureConfig TALL_GRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.GRASS.getDefaultState(), 6)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 3))).tries(32).build();

    public static final RandomPatchFeatureConfig ONLY_TALL_GRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.TALL_GRASS.getDefaultState(), 1)))
                    .tries(96).build();

    public static final RandomPatchFeatureConfig BLUEBELL_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.CORNFLOWER.getDefaultState(), 32)
                    .add(Blocks.GRASS.getDefaultState(), 4)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 2))).tries(32).build();

    public static final RandomPatchFeatureConfig LILY_OF_THE_VALLEY_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.LILY_OF_THE_VALLEY.getDefaultState(), 32)
                    .add(Blocks.GRASS.getDefaultState(), 4)
                    .add(Blocks.TALL_GRASS.getDefaultState(), 2))).tries(48).build();

    public static final RandomPatchFeatureConfig DESERT_GRASS_CONFIG =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.GRASS.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(24).build();

    public static final RandomPatchFeatureConfig SUGAR_CANE_CONFIG =
            new RandomPatchFeatureConfig.Builder(SimpleBlockStateProvider.of(Blocks.SUGAR_CANE.getDefaultState()))
            .tries(20)
            .spreadX(4)
            .spreadY(0)
            .spreadZ(4)
            .cannotProject()
            .needsWater()
            .build();

    public static final RandomPatchFeatureConfig SMALL_CACTUS =
            //TODO Make tiny cactus a head (done?)
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(HeadBlocks.SMALL_CACTUS.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(12).build();

    public static final RandomPatchFeatureConfig THORN_BUSH =
            new RandomPatchFeatureConfig.Builder(BlockStateProvider.of(Blocks.SWEET_BERRY_BUSH.getDefaultState()))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(16).build();

    // flowers
    public static final RandomPatchFeatureConfig TAIGA_FLOWERS =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.POPPY.getDefaultState(), 1)
                    .add(Blocks.ALLIUM.getDefaultState(),1)
                    .add(Blocks.ROSE_BUSH.getDefaultState(), 1)
                    .add(Blocks.ORANGE_TULIP.getDefaultState(), 1)
                    .add(Blocks.PINK_TULIP.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(64).cannotProject().build();

    public static final RandomPatchFeatureConfig WIDE_FERNS =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.LARGE_FERN.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(48).build();

    public static final RandomPatchFeatureConfig SMALL_LILAC =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.LILAC.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(12).build();

    public static final RandomPatchFeatureConfig LAVENDER =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.ALLIUM.getDefaultState(), 1)))
                    .spreadX(5)
                    .spreadZ(5)
                    .tries(12).build();

    public static final RandomPatchFeatureConfig DENSE_LAVENDER =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.ALLIUM.getDefaultState(), 1)))
                    .spreadX(5)
                    .spreadZ(5)
                    .tries(32).build();

    public static final RandomPatchFeatureConfig DENSE_LAVENDER_LILAC =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.ALLIUM.getDefaultState(), 1)
                    .add(Blocks.LILAC.getDefaultState(), 1)))
                    .spreadX(5)
                    .spreadZ(5)
                    .tries(32).build();

    public static final RandomPatchFeatureConfig WILDFLOWERS =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.POPPY.getDefaultState(), 1)
                    .add(Blocks.ALLIUM.getDefaultState(),1)
                    .add(Blocks.ROSE_BUSH.getDefaultState(), 1)
                    .add(Blocks.ORANGE_TULIP.getDefaultState(), 1)
                    .add(Blocks.WHITE_TULIP.getDefaultState(), 1)
                    .add(Blocks.RED_TULIP.getDefaultState(), 1)
                    .add(Blocks.PINK_TULIP.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(32).build();

    public static final RandomPatchFeatureConfig FLAME_LILY =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.RED_TULIP.getDefaultState(), 1)
                    .add(Blocks.ORANGE_TULIP.getDefaultState(), 1)))
                    .spreadX(5)
                    .spreadZ(5)
                    .tries(12).build();

    public static final RandomPatchFeatureConfig DANDELION_FIELD_FLOWERS =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.DANDELION.getDefaultState(), 5)
                    .add(Blocks.POPPY.getDefaultState(), 1)
                    .add(Blocks.ORANGE_TULIP.getDefaultState(), 1)
                    .add(Blocks.RED_TULIP.getDefaultState(), 1)
                    .add(Blocks.PINK_TULIP.getDefaultState(), 1)))
                    .spreadX(4)
                    .spreadZ(4)
                    .tries(16).build();

    public static final RandomPatchFeatureConfig CYAN_ROSE =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.CORNFLOWER.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(32).build();

    // misc
    public static final RandomPatchFeatureConfig SURFACE_ROCKS =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.STONE_BUTTON.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(4).build();

    public static final RandomPatchFeatureConfig CLOVER =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.LILY_OF_THE_VALLEY.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK))
                    .tries(12).build();

    public static final RandomPatchFeatureConfig MOSS =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.MOSS_CARPET.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK))
                    .tries(16).build();

    public static final RandomPatchFeatureConfig PUMPKIN =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.PUMPKIN.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK))
                    .tries(64).build();

    public static final RandomPatchFeatureConfig COBWEB =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.COBWEB.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK))
                    .tries(12).build();

    public static final RandomPatchFeatureConfig LARGE_CACTUS_PATCH =
            new RandomPatchFeatureConfig.Builder(
                    BlockStateProvider.of(Blocks.CACTUS.getDefaultState()))
                    .tries(32).cannotProject().build();

    public static final RandomPatchFeatureConfig MUSHROOMS =
            new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(pool()
                    .add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)
                    .add(Blocks.RED_MUSHROOM.getDefaultState(), 1)))
                    .spreadX(7)
                    .spreadZ(7)
                    .tries(64).build();

    public static final WaterFeatureConfig GRASS_WATER_PATCH =
            new WaterFeatureConfig(ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState()), Optional.empty(), 6);

    public static final WaterFeatureConfig PEAT_PATCH =
            //TODO Replace with mud
            new WaterFeatureConfig(ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.CLAY.getDefaultState()), Optional.of(BlockStateProvider.of(Blocks.CLAY.getDefaultState())), 2);

    public static final WaterFeatureConfig GRANITE_WATER_POOL_PATCH =
            new WaterFeatureConfig(ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.GRANITE.getDefaultState()), Optional.of(BlockStateProvider.of(Blocks.GRANITE.getDefaultState())), 3);

    public static final WaterFeatureConfig GRANITE_WATER_PATCH =
            new WaterFeatureConfig(ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.GRANITE.getDefaultState()), Optional.empty(), 12);

    public static final WaterFeatureConfig DIORITE_WATER_POOL_PATCH =
            new WaterFeatureConfig(ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIORITE.getDefaultState()), Optional.of(BlockStateProvider.of(Blocks.DIORITE.getDefaultState())), 4);

    public static final WaterFeatureConfig DIORITE_WATER_PATCH =
            new WaterFeatureConfig(ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIORITE.getDefaultState()), Optional.empty(), 12);

    public static final RockSpireFeatureConfig STONE_SPIRE =
            new RockSpireFeatureConfig(BlockStateProvider.of(Blocks.STONE.getDefaultState()));

    public static final RockSpireFeatureConfig GRANITE_SPIRE =
            new RockSpireFeatureConfig(BlockStateProvider.of(Blocks.GRANITE.getDefaultState()));

    public static final RockSpireFeatureConfig DIORITE_SPIRE =
            new RockSpireFeatureConfig(BlockStateProvider.of(Blocks.DIORITE.getDefaultState()));

    public static final RockSpireFeatureConfig RED_ROCK_SPIRE =
            new RockSpireFeatureConfig(BlockStateProvider.of(Blocks.SMOOTH_RED_SANDSTONE.getDefaultState()));

    // trees
    public static final TreeFeatureConfig SPRUCE_TREE_CONFIG =
            new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(Blocks.SPRUCE_LOG.getDefaultState()),
                    new StraightTrunkPlacer(6, 4, 3),
                    BlockStateProvider.of(Blocks.SPRUCE_LEAVES.getDefaultState()),
//                    BlockStateProvider.of(Blocks.SPRUCE_SAPLING.getDefaultState()),
                    new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                    new TwoLayersFeatureSize(2, 0, 2))
                    .ignoreVines()
                    .decorators(ImmutableList.of(new PineconeTreeDecorator(6), new LichenTreeDecorator(12), new LeafPileTreeDecorator(Blocks.SPRUCE_LEAVES.getDefaultState(), 12, 4))).build();

    public static final TreeFeatureConfig SMALL_PINE_CONFIG = new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.SPRUCE_LOG.getDefaultState()),
            new StraightTrunkPlacer(9, 6, 0),
            BlockStateProvider.of(Blocks.SPRUCE_LEAVES.getDefaultState()),
//            BlockStateProvider.of(Blocks.SPRUCE_SAPLING.getDefaultState()),
            new SmallPineFoliagePlacer(UniformIntProvider.create(1, 1), UniformIntProvider.create(0, 1), UniformIntProvider.create(4, 6)),
            new TwoLayersFeatureSize(2, 0, 2))
            .ignoreVines()
            .decorators(ImmutableList.of(new PineconeTreeDecorator(2), new LeafPileTreeDecorator(Blocks.SPRUCE_LEAVES.getDefaultState(), 6, 4))).build();

    public static final TreeFeatureConfig JUNGLE = new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.JUNGLE_LOG.getDefaultState()),
            new StraightTrunkPlacer(4, 8, 0),
            BlockStateProvider.of(Blocks.JUNGLE_LEAVES.getDefaultState()),
//            BlockStateProvider.of(Blocks.JUNGLE_SAPLING.getDefaultState()),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
            new TwoLayersFeatureSize(1, 0, 1))
            .decorators(ImmutableList.of(new CocoaBeansTreeDecorator(0.2F), TrunkVineTreeDecorator.INSTANCE, LeavesVineTreeDecorator.INSTANCE)).ignoreVines().build();

    public static final TreeFeatureConfig MEGA_JUNGLE = new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.JUNGLE_LOG.getDefaultState()),
            new MegaJungleTrunkPlacer(10, 2, 19),
            BlockStateProvider.of(Blocks.JUNGLE_LEAVES.getDefaultState()),
//            BlockStateProvider.of(Blocks.JUNGLE_SAPLING.getDefaultState()),
            new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
            new TwoLayersFeatureSize(1, 1, 2))
            .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeavesVineTreeDecorator.INSTANCE)).build();

    public static final TreeFeatureConfig DRY_STEPPE_TREE = new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
            new LargeOakTrunkPlacer(8, 6, 0),
            BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
//            BlockStateProvider.of(Blocks.OAK_SAPLING.getDefaultState()),
            new PlusLeavesFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
            new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
            .ignoreVines().build();
}

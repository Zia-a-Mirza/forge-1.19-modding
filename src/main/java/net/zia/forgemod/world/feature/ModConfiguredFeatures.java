package net.zia.forgemod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zia.forgemod.ForgeMod;
import net.zia.forgemod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
           DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ForgeMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CHLOROPHYTE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CHLOROPHYTE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.CLAY), ModBlocks.CHLOROPHYTE_BLOCK.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?,?>> CHLOROPHYTE_ORE = CONFIGURED_FEATURES.register("chlorophyte_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_CHLOROPHYTE_ORES.get(), 20)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}

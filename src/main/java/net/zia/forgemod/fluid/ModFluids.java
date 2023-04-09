package net.zia.forgemod.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zia.forgemod.ForgeMod;
import net.zia.forgemod.block.ModBlocks;
import net.zia.forgemod.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, ForgeMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_HONEY_WATER = FLUIDS.register("honey_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HONEY_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HONEY_WATER = FLUIDS.register("flowing_honey_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HONEY_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties HONEY_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.HONEY_WATER_FLUID_TYPE, SOURCE_HONEY_WATER, FLOWING_HONEY_WATER)
            .slopeFindDistance(1).levelDecreasePerBlock(3).block(ModBlocks.HONEY_WATER_BLOCK)
            .bucket(ModItems.Honey_Bucket);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}

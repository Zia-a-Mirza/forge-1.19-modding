package net.zia.forgemod.fluid;

import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zia.forgemod.ForgeMod;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation(ForgeMod.MOD_ID,"misc/honey_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation(ForgeMod.MOD_ID,"misc/honey_flow");
    public static final ResourceLocation HONEY_OVERLAY_RL = new ResourceLocation(ForgeMod.MOD_ID, "misc/in_honey");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ForgeMod.MOD_ID);

    public static final RegistryObject<FluidType> HONEY_WATER_FLUID_TYPE = register("honey_water_fluid",
            FluidType.Properties.create().density(2000).viscosity(7000).canExtinguish(true).canDrown(true).lightLevel(1));



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, HONEY_OVERLAY_RL,
                0xA1ED860A, new Vector3f(237f / 255f, 134f / 255f, 10f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}

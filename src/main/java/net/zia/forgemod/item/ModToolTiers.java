package net.zia.forgemod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.zia.forgemod.ForgeMod;
import net.zia.forgemod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static Tier chlorophyte;

    static {
        chlorophyte = TierSortingRegistry.registerTier(
                new ForgeTier(5, 2500, 9.0f,5.0f, 10,
                        ModTags.Blocks.NEEDS_CHLOROPHYTE_TOOL, () -> Ingredient.of(ModItems.Chlorophyte_Ingot.get())),
                new ResourceLocation(ForgeMod.MOD_ID, "chlorophyte"), List.of(Tiers.NETHERITE), List.of());
    }

}

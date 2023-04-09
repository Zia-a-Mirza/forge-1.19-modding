package net.zia.forgemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab Forge_Tab = new CreativeModeTab("forgetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.Raw_Chlorophyte.get());
        }
    };
}

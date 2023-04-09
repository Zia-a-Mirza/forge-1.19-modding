package net.zia.forgemod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.zia.forgemod.ForgeMod;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CHLOROPHYTE_TOOL
                = tag("needs_chlorophyte_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ForgeMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}

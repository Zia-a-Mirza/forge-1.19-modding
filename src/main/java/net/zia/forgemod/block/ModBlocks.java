package net.zia.forgemod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zia.forgemod.ForgeMod;
import net.zia.forgemod.block.custom.JungleSporeBlock;
import net.zia.forgemod.fluid.ModFluids;
import net.zia.forgemod.item.ModCreativeModTab;
import net.zia.forgemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ForgeMod.MOD_ID);

    public static final RegistryObject<Block> CHLOROPHYTE_BLOCK = registerBlock("chlorophyte_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), ModCreativeModTab.Forge_Tab);

    public static final RegistryObject<Block> CHLOROPHYTE_ORE = registerBlock("chlorophyte_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.MUD), UniformInt.of(3,7)),
            ModCreativeModTab.Forge_Tab);

    public static final RegistryObject<Block> DEEPSLATE_CHLOROPHYTE_ORE = registerBlock("deepslate_chlorophyte_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3,7)),
            ModCreativeModTab.Forge_Tab);

    //CROPS
    public static final RegistryObject<Block> JUNGLE_SPORE_CROP = BLOCKS.register("jungle_spore_crop",
            () -> new JungleSporeBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).noOcclusion()
                    .lightLevel((p_50872_) -> {return 8;
            })));

    //FLUIDS
    public static final RegistryObject<LiquidBlock> HONEY_WATER_BLOCK = BLOCKS.register("honey_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HONEY_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)
                    .jumpFactor(0.5f).speedFactor(0.4f).noOcclusion().sound(SoundType.ANVIL)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

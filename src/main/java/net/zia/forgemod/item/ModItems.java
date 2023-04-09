package net.zia.forgemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zia.forgemod.ForgeMod;
import net.zia.forgemod.block.ModBlocks;
import net.zia.forgemod.fluid.ModFluids;

public class ModItems {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, ForgeMod.MOD_ID);

    public static final RegistryObject<Item> Chlorophyte_Ingot = Items.register("chlorophyte_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.Forge_Tab).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> Raw_Chlorophyte = Items.register("raw_chlorophyte",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.Forge_Tab).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> Chlorophyte_Pickaxe = Items.register("chlorophyte_pickaxe",
            () -> new PickaxeItem(ModToolTiers.chlorophyte, 1, -2.8f,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.Forge_Tab).rarity(Rarity.RARE)));

    public static final RegistryObject<SwordItem> Chlorophyte_Sword = Items.register("chlorophyte_sword",
            () -> new SwordItem(ModToolTiers.chlorophyte, 3, -2.4f,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.Forge_Tab).rarity(Rarity.RARE)));

    public static final RegistryObject<AxeItem> Chlorophyte_Axe = Items.register("chlorophyte_axe",
            () -> new AxeItem(ModToolTiers.chlorophyte, 5, -3f,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.Forge_Tab).rarity(Rarity.RARE)));

    public static final RegistryObject<ShovelItem> Chlorophyte_Shovel = Items.register("chlorophyte_shovel",
            () -> new ShovelItem(ModToolTiers.chlorophyte, 1.5f, -3f,
                    new Item.Properties().fireResistant().tab(ModCreativeModTab.Forge_Tab).rarity(Rarity.RARE)));

    //Crops
    public static final RegistryObject<Item> Jungle_Spore_Seeds = Items.register("jungle_spore_seeds",
            () -> new ItemNameBlockItem(ModBlocks.JUNGLE_SPORE_CROP.get(),
                    new Item.Properties().tab(ModCreativeModTab.Forge_Tab)));

    public static final RegistryObject<Item> Jungle_Spores = Items.register("jungle_spores",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.Forge_Tab)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(1f)
                            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 3), 0.6f)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1), 0.6f)
                            .effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 0.6f).build())));

    //Buckets
    public static final RegistryObject<Item> Honey_Bucket = Items.register("honey_bucket",
            () -> new BucketItem(ModFluids.SOURCE_HONEY_WATER,
                    new Item.Properties().tab(ModCreativeModTab.Forge_Tab).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}

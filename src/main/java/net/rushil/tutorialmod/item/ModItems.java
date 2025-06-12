package net.rushil.tutorialmod.item;

import net.minecraft.client.model.ColorableHierarchicalModel;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rushil.tutorialmod.TutorialMod;
import net.rushil.tutorialmod.item.custom.ChiselItem;
import net.rushil.tutorialmod.item.custom.IceWandItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> GEMSTONE = ITEMS.register("gemstone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_GEMSTONE = ITEMS.register("raw_gemstone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

public static final RegistryObject<Item> ICE_WAND = ITEMS.register("ice_wand",
            () -> new IceWandItem(new Item.Properties().durability(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

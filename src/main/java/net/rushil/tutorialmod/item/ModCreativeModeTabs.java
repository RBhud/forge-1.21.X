package net.rushil.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rushil.tutorialmod.TutorialMod;
import net.rushil.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GEMSTONE_ITEMS_TAB = CREATIVE_MODE_TABS.register("gemstone_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GEMSTONE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.gemstone_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GEMSTONE.get());
                        output.accept(ModItems.RAW_GEMSTONE.get());

                        output.accept(ModItems.CHISEL.get());
                        output.accept(ModItems.ICE_WAND.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> GEMSTONE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("gemstone_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GEMSTONE_BLOCK.get()))
                    .withTabsBefore(GEMSTONE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.gemstone_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.GEMSTONE_BLOCK.get());
                        output.accept(ModBlocks.RAW_GEMSTONE_BLOCK.get());
                        output.accept(ModBlocks.GEMSTONE_ORE.get());
                        output.accept(ModBlocks.GEMSTONE_DEEPSLATE_ORE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> PEARL_ITEMS_TAB = CREATIVE_MODE_TABS.register("pearl_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PEARL.get()))
                    .withTabsBefore(GEMSTONE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.pearl_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PEARL.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> PEARL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("pearl_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PEARL_BLOCK.get()))
                    .withTabsBefore(PEARL_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.pearl_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PEARL_BLOCK.get());
                        output.accept(ModBlocks.SAND_COVERED_PEARL.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

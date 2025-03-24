package net.narutoxboruto.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.narutoxboruto.Main;

public class ModTab
{
    // Create a DeferredRegister for CreativeModeTabs.
    // Ensures the tab is registered at the correct time in the mod loading process.
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Main.MOD_ID, Registries.CREATIVE_MODE_TAB);

    // Define the items that will appear in the custom CreativeModeTab.
    private static final CreativeModeTab.DisplayItemsGenerator MAIN_TAB_ITEMS = (params, output) -> {
        output.accept(ModItems.KUNAI.get());
    };

    // Register a new CreativeModeTab with the unique name "main_tab".
    public static final RegistrySupplier<CreativeModeTab> NARUTO_TAB = TABS.register("main_tab",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)  // Tab placement: top row, first position.
                    .title(Component.translatable("itemGroup.narutoxboruto.main_tab"))  // Tab name.
                    .icon(() -> new ItemStack(ModItems.KUNAI.get()))  // Tab icon - Kunai
                    .displayItems(MAIN_TAB_ITEMS)  // Tab items.
                    .build()
    );

    // Register method to be called from the Main class.
    // This ensures that the tab is properly registered when the mod initializes.
    public static void register()
    {
        TABS.register();
    }
}

package net.narutoxboruto.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.narutoxboruto.Main;

public class ModTab {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Main.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> NARUTO_TAB = TABS.register("naruto_tab",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemGroup.narutoxboruto.main")) // Tab title
                    .icon(() -> new ItemStack(ModItems.KUNAI.get())) // Tab icon
                    .displayItems((params, output) -> {
                        output.accept(ModItems.KUNAI.get());
                    })
                    .build()
    );




    // Method to register the creative tab
    public static void register() {
        TABS.register();
    }
}

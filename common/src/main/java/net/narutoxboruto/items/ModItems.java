package net.narutoxboruto.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.narutoxboruto.Main;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(Main.MOD_ID, Registries.ITEM);

    private static Item.Properties properties() {
        return new Item.Properties();
    }

    // Register all items
    public static void register() {
        MOD_ITEMS.register();
    }

    // Item declarations
    public static final RegistrySupplier<Item> KUNAI;

    static {
        //Throwables
        KUNAI = registerGenericItem("kunai", () -> new Item(properties()));
    }

    // Helper method to register items easily
    private static RegistrySupplier<Item> registerGenericItem(String name, Supplier<Item> itemSupplier) {
        return MOD_ITEMS.register(name, itemSupplier);
    }
}

package net.narutoxboruto.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.narutoxboruto.Main;
import net.narutoxboruto.items.throwables.ThrowableWeaponItem;

import java.util.function.Supplier;

public class ModItems
{
    // Register all items using DeferredRegister
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(Main.MOD_ID, Registries.ITEM);

    // Supplier for generic items
    private static final Supplier<Item> GENERIC_ITEMS_SUPPLIER =
            () -> new Item(new Item.Properties()
                    .stacksTo(64)   // Stack size to 64
                    .rarity(Rarity.COMMON));    // Item rarity

    // Item Projectiles
    public static final RegistrySupplier<Item> KUNAI = MOD_ITEMS.register("kunai", () ->
            new ThrowableWeaponItem(new Item.Properties().stacksTo(64), "kunai")
    );

    public static final RegistrySupplier<Item> EXPLOSIVE_KUNAI = MOD_ITEMS.register("explosive_kunai", () ->
            new ThrowableWeaponItem(new Item.Properties().stacksTo(64), "explosive_kunai")
    );

    // Register method to initialize items
    public static void register() { MOD_ITEMS.register(); }

    // Helper method to register items easily
    private static RegistrySupplier<Item> registerGenericItem(String name, Supplier<? extends Item> supplier)
    {
        return MOD_ITEMS.register(name, supplier);
    }
}

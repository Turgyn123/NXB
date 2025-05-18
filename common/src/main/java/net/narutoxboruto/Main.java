package net.narutoxboruto;

import net.narutoxboruto.entities.ModEntities;
import net.narutoxboruto.items.ModItems;
import net.narutoxboruto.items.ModTab;

public final class Main
{
    // The unique Mod ID, used for resource locations and registry keys.
    public static final String MOD_ID = "narutoxboruto";

    /**
     * Initializes the mod. This method is called during mod loading and is responsible for registering items,
     * creative tabs, and other common components.
     */
    public static void init()
    {
        // Register all mod items.
        ModItems.register();

        // Register the custom creative tab.
        ModTab.register();

        // Register the Entities
        ModEntities.register();
    }
}

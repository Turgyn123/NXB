package net.narutoxboruto;

import net.narutoxboruto.items.ModItems;
import net.narutoxboruto.items.ModTab;

public final class Main {
    public static final String MOD_ID = "narutoxboruto";

    public static void init() {
        // Write common init code here.
        ModItems.register();
        ModTab.register();
    }
}

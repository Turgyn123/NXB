package net.narutoxboruto.neoforge;

import net.neoforged.fml.common.Mod;

import net.narutoxboruto.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}

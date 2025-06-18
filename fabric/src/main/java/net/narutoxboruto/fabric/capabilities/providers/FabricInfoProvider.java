package net.narutoxboruto.fabric.capabilities.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.narutoxboruto.capabilities.info.Chakra;
import net.narutoxboruto.capabilities.info.MaxChakra;


public class FabricInfoProvider {

    private final Chakra CHAKRA = new Chakra();
    private final MaxChakra MAX_CHAKRA = new MaxChakra();


    public Chakra getChakra() {
        return CHAKRA;
    }

    public MaxChakra getMaxChakra() {
        return MAX_CHAKRA;
    }

    public CompoundTag serializeNBT(HolderLookup.Provider arg) {
        CompoundTag nbt = new CompoundTag();
        CHAKRA.saveNBTData(nbt);
        MAX_CHAKRA.saveNBTData(nbt);
        return nbt;
    }

    public void deserializeNBT(HolderLookup.Provider arg, CompoundTag nbt) {
        CHAKRA.loadNBTData(nbt);
        MAX_CHAKRA.loadNBTData(nbt);
    }

}
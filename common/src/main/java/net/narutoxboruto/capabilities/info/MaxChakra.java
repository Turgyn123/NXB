package net.narutoxboruto.capabilities.info;

import net.minecraft.nbt.CompoundTag;

public class MaxChakra {
    private int value = 10;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addValue(int add) {
        this.value += add;
    }

    public void subValue(int sub) {
        this.value = Math.max(value - sub, 0);
    }

    public void copyFrom(MaxChakra source) {
        this.value = source.getValue();
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("maxChakra", value);
    }

    public void loadNBTData(CompoundTag nbt) {
        value = nbt.getInt("maxChakra");
    }
}
package net.narutoxboruto.capabilities.info;

import net.minecraft.nbt.CompoundTag;

public class Chakra {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addValue(int add, int maxChakra) {
        this.value = Math.min(this.value + add, maxChakra);
    }

    public void subValue(int sub, boolean isCreative) {
        if (!isCreative) {
            this.value = Math.max(value - sub, 0);
        }
    }

    public void reset(int maxChakra) {
        this.value = maxChakra / 2;
    }

    public void replenish(int maxChakra) {
        this.value = maxChakra;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("chakra", value);
    }

    public void loadNBTData(CompoundTag nbt) {
        value = nbt.getInt("chakra");
    }
}

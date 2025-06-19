package net.narutoxboruto.capabilities.info;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.narutoxboruto.networking.ModPacketHandler;
import net.narutoxboruto.networking.info.SyncChakra;

public class Chakra {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addValue(int add, int maxChakra, ServerPlayer serverPlayer) {
        this.value = Math.min(this.value + add, maxChakra);
        this.SyncValue(serverPlayer);
    }

    public void subValue(int sub, ServerPlayer serverPlayer) {
        if (!serverPlayer.getAbilities().instabuild) {
            this.value = Math.max(value - sub, 0);
            this.SyncValue(serverPlayer);
        }
    }

    public void SyncValue(ServerPlayer serverPlayer) {
        ModPacketHandler.sendToPlayer(new SyncChakra(getValue()), serverPlayer);
    }

    public void reset(int maxChakra, ServerPlayer serverPlayer) {
        this.value = maxChakra / 2;
        this.SyncValue(serverPlayer);
    }

    public void replenish(int maxChakra, ServerPlayer serverPlayer) {
        this.value = maxChakra;
        this.SyncValue(serverPlayer);
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("chakra", value);
    }

    public void loadNBTData(CompoundTag nbt) {
        value = nbt.getInt("chakra");
    }
}

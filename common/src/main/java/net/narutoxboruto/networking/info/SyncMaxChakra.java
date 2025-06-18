package net.narutoxboruto.networking.info;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;
import net.narutoxboruto.client.PlayerData;

import java.util.function.Supplier;

public class SyncMaxChakra {
    private final int maxChakra;

    public SyncMaxChakra(int maxChakra) {
        this.maxChakra = maxChakra;
    }

    public SyncMaxChakra(FriendlyByteBuf buf) {
        this.maxChakra = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(maxChakra);
    }

    public void handle(Supplier<NetworkManager.PacketContext> supplier) {
        NetworkManager.PacketContext context = supplier.get();
        context.queue(() -> {
            PlayerData.setMaxChakra(maxChakra);
        });
    }
}

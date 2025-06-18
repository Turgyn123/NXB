package net.narutoxboruto.networking.info;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;
import net.narutoxboruto.client.PlayerData;

import java.util.function.Supplier;

public class SyncChakra {
    private final int chakra;

    public SyncChakra(int chakra) {
        this.chakra = chakra;
    }

    public SyncChakra(FriendlyByteBuf buf) {
        this.chakra = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(chakra);
    }

    public void handle(Supplier<NetworkManager.PacketContext> supplier) {
       NetworkManager.PacketContext context = supplier.get();
       context.queue(() -> {
           PlayerData.setChakra(chakra);
       });
    }
}

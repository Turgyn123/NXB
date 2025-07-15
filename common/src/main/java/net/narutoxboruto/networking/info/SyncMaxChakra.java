package net.narutoxboruto.networking.info;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.narutoxboruto.client.PlayerData;

import java.util.function.Supplier;

public class SyncMaxChakra implements CustomPacketPayload {
    private final int maxChakra;

    public SyncMaxChakra(int maxChakra) {
        this.maxChakra = maxChakra;
    }

    public int getMaxChakra() {
        return maxChakra;
    }

    public static final Type<SyncMaxChakra> TYPE = new Type<>( ResourceLocation.fromNamespaceAndPath("mymod", "sync_max_chakra"));

    public static final StreamCodec<FriendlyByteBuf, SyncMaxChakra> CODEC = new StreamCodec<>() {
        @Override
        public void encode(FriendlyByteBuf buf, SyncMaxChakra payload) {
            buf.writeInt(payload.maxChakra);
        }

        @Override
        public SyncMaxChakra decode(FriendlyByteBuf buf) {
            return new SyncMaxChakra(buf.readInt());
        }
    };

    public static void handle(SyncMaxChakra packet, Supplier<NetworkManager.PacketContext> supplier) {
        NetworkManager.PacketContext context = supplier.get();
        context.queue(() -> {
            PlayerData.setMaxChakra(packet.getMaxChakra());
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}

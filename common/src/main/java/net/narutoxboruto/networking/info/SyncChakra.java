package net.narutoxboruto.networking.info;


import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;


public class SyncChakra implements CustomPacketPayload {
    private final int chakra;

    public SyncChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getChakra() {
        return chakra;
    }

    public static final CustomPacketPayload.Type<SyncChakra> TYPE = new CustomPacketPayload.Type<>( ResourceLocation.fromNamespaceAndPath("mymod", "sync_chakra"));

    // StreamCodec for encoding and decoding
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncChakra> CODEC = new StreamCodec<>() {
        @Override
        public void encode(RegistryFriendlyByteBuf buf, SyncChakra payload) {
            buf.writeInt(payload.chakra);
        }

        @Override
        public SyncChakra decode(RegistryFriendlyByteBuf buf) {
            return new SyncChakra(buf.readInt());
        }
    };

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}


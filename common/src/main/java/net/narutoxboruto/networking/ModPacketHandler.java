package net.narutoxboruto.networking;

import dev.architectury.networking.NetworkChannel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.narutoxboruto.Main;
import net.narutoxboruto.networking.info.SyncChakra;
import net.narutoxboruto.networking.info.SyncMaxChakra;

public class ModPacketHandler {

    @SuppressWarnings("removal")
    public static final NetworkChannel INSTANCE = NetworkChannel.create(ResourceLocation.fromNamespaceAndPath(Main.MOD_ID, "message"));


    private static int packetId = 0;

    private static int id() {
        return packetId++;
    }
    @SuppressWarnings("removal")
    public static void register() {

        INSTANCE.register(SyncChakra.class, SyncChakra::toBytes, SyncChakra::new, SyncChakra::handle);
        INSTANCE.register(SyncMaxChakra.class, SyncMaxChakra::toBytes, SyncMaxChakra::new, SyncMaxChakra::handle);

    }
    @SuppressWarnings("removal")
    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    @SuppressWarnings("removal")
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.sendToPlayer(player, message);
    }
}
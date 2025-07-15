package net.narutoxboruto.networking;


import dev.architectury.networking.NetworkManager;
import net.minecraft.server.level.ServerPlayer;
import net.narutoxboruto.client.PlayerData;
import net.narutoxboruto.networking.info.SyncChakra;
import net.narutoxboruto.networking.info.SyncMaxChakra;

public class ModPacketHandler {


    public static void registerPayloadTypes() {
        // This should be called only once, early — only on NeoForge (during payload registration event)
        NetworkManager.registerS2CPayloadType(SyncChakra.TYPE, SyncChakra.CODEC);
        NetworkManager.registerS2CPayloadType(SyncMaxChakra.TYPE, SyncMaxChakra.CODEC);
    }

    private static boolean clientReceiversRegistered = false;

    public static void registerClientReceivers() {
        if (clientReceiversRegistered) {
            System.out.println("[ModPacketHandler] Client receivers already registered, skipping.");
            Thread.dumpStack();
            return;
        }
        clientReceiversRegistered = true;
        System.out.println("[ModPacketHandler] Registering client receivers.. Called from thread: " + Thread.currentThread().getName());
        Thread.dumpStack();

        NetworkManager.registerReceiver(NetworkManager.Side.S2C, SyncChakra.TYPE, SyncChakra.CODEC,
                (payload, context) -> context.queue(() -> PlayerData.setChakra(payload.getChakra())));

        NetworkManager.registerReceiver(NetworkManager.Side.S2C, SyncMaxChakra.TYPE, SyncMaxChakra.CODEC,
                (payload, context) -> context.queue(() -> PlayerData.setMaxChakra(payload.getMaxChakra())));
    }

    public static void sendToPlayer(SyncChakra packet, ServerPlayer player) {
        NetworkManager.sendToPlayer(player, packet);
    }

    public static void sendToPlayer(SyncMaxChakra packet, ServerPlayer player) {
        NetworkManager.sendToPlayer(player, packet);
    }

    public static void sendToServer(SyncChakra packet) {
        NetworkManager.sendToServer(packet);
    }

    public static void sendToServer(SyncMaxChakra packet) {
        NetworkManager.sendToServer(packet);
    }
}
package net.narutoxboruto.client;

public class PlayerData {

    private static int chakra, maxChakra;

    public static int getChakra() {
        return chakra;
    }

    public static void setChakra(int chakra) {
        PlayerData.chakra = chakra;
    }

    public static int getMaxChakra() {
        return maxChakra;
    }

    public static int setMaxChakra(int maxChakra) {
        PlayerData.maxChakra = maxChakra;
        return maxChakra;
    }
}

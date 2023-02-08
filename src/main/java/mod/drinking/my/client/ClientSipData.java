package mod.drinking.my.client;

import ca.weblite.objc.Client;
import mod.drinking.my.sipcount.PlayerSips;
import mod.drinking.my.sipcount.PlayerSipsProvider;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientSipData {
    private static int playerSips;
    private static int totalSips;

    public static void set(int sips, int totalSips) {
        ClientSipData.playerSips = sips;
        ClientSipData.totalSips = totalSips;
    }

    public static void add(int add){
        playerSips += add;
        totalSips += add;
    }

    public static int getPlayerSips() {
        return playerSips;
    }

    public static int getTotalSips() {
        return totalSips;
    }
}
package me.darkcray_.commandbot.bot.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public class ChatMassage {
    public static void sendChatMessage(String msg) {

        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayNetworkHandler handler = client.getNetworkHandler();

        if (handler == null) {
            return;
        }
        handler.sendChatMessage(msg);
    }
}

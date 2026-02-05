package me.darkcray_.commandbot.bot;

import me.darkcray_.commandbot.bot.actions.BotAction;
import me.darkcray_.commandbot.bot.actions.KeyAction;
import me.darkcray_.commandbot.bot.utils.ChatMassage;
import me.darkcray_.commandbot.protection.GriefProtection;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.ArrayDeque;
import java.util.Queue;

public class BotController {
    private static final Queue<BotAction> QUEUE = new ArrayDeque<>();
    private static BotAction current;

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> tick());
    }

    public static void enqueue(BotAction action, CommandType type) {
        if (type == CommandType.CLICK) {
            if (GriefProtection.isForbiddenAction()) {
                ChatMassage.sendChatMessage("Данное действие запрещено программой!");
                return;
            }
        }
        QUEUE.add(action);
    }

    private static void tick() {
        if (current == null && !QUEUE.isEmpty()) {
            current = QUEUE.poll();
            current.start();
        }

        if (current != null) {
            if (current.isRepeated()) current.start();
            current.tick();
            if (current.finished()) {
                current.stop();
                current = null;
            };
        }
    }
}

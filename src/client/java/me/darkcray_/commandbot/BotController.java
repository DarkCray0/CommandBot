package me.darkcray_.commandbot;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

import java.util.ArrayDeque;
import java.util.Queue;

public class BotController {
    private static final Queue<Action> QUEUE = new ArrayDeque<>();
    private static Action currentAction = null;

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(BotController::tick);
    }

    public static void handleMessage(String message) {
        message = message.toLowerCase().trim();

        for (BotCommands.BotCommand cmd : BotCommands.COMMANDS) {
            if (message.contains(cmd.keyword())) {

                int durationTicks = cmd.durationTicks();

                try {
                    String[] parts = message.split("\\s+");
                    for (int i = 0; i < parts.length; i++) {
                        if (parts[i].equals(cmd.keyword()) && i + 1 < parts.length) {
                            String next = parts[i + 1];
                            int blocks = Integer.parseInt(next);

                            if (blocks > 10) blocks = 10;

                            durationTicks = (int) Math.round((0.27 * blocks) * 20);
                        }
                    }
                } catch (NumberFormatException ignored) {}

                QUEUE.add(new Action(cmd.key(), durationTicks));
                break;
            }
        }
    }

    private static void tick(MinecraftClient client) {
        if (currentAction == null && !QUEUE.isEmpty()) {
            currentAction = QUEUE.poll();
            currentAction.start();
        }

        if (currentAction != null) {
            currentAction.tick();
            if (currentAction.finished()) {
                currentAction.stop();
                currentAction = null;
            }
        }
    }

    private record Action(KeyBinding key, int ticksLeft) {
        private static double ticks;

        public void start() {
            ticks = ticksLeft;
            key.setPressed(true);
        }

        public void tick() {
            ticks--;
        }

        public boolean finished() {
            return ticks <= 0;
        }

        public void stop() {
            key.setPressed(false);
        }
    }
}

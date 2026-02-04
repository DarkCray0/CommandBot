package me.darkcray_.commandbot.bot.actions;

import me.darkcray_.commandbot.bot.utils.ChatMassage;
import me.darkcray_.commandbot.protection.GriefProtection;
import net.minecraft.client.MinecraftClient;

public class BotAction {
    private int ticksLeft;
    private boolean isRepeated;
    private Runnable start, stop;

    public BotAction withRepeats(int repeats) {
        this.ticksLeft *= repeats;
        return this;
    }

    public static BotAction move(KeyAction key) {
        return new BotAction(5, key::press, key::release, false);
    }

    public static BotAction hotbar(KeyAction key) {
        return new BotAction(1, key::click, key::release, false);
    }

    public static BotAction camera(CameraAction cam) {
        return new BotAction(2, cam::apply, () -> {}, true);
    }

    public static BotAction leftClick() {
        return new BotAction(4,
                () -> MinecraftClient.getInstance().options.attackKey.setPressed(true),
                () -> MinecraftClient.getInstance().options.attackKey.setPressed(false), false
        );
    }

    public static BotAction rightClick() {
        return new BotAction(2,
                () -> MinecraftClient.getInstance().options.useKey.setPressed(true),
                () -> MinecraftClient.getInstance().options.useKey.setPressed(false), false
        );
    }

    public static BotAction chat(String cmd) {
        return new BotAction(1,
                () -> {
                    assert MinecraftClient.getInstance().player != null;
                    MinecraftClient.getInstance().player.networkHandler.sendChatCommand(cmd);
                },
                () -> {}, false
        );
    }

    private BotAction(int ticks, Runnable start, Runnable stop, boolean isRepeated) {
        this.ticksLeft = ticks;
        this.start = start;
        this.stop = stop;
        this.isRepeated = isRepeated;
    }

    public void tick() {
        if (ticksLeft == 0) return;
        ticksLeft--;
    }

    public void start() { start.run(); }
    public void stop() { stop.run(); }
    public boolean isRepeated() { return isRepeated; }
    public boolean finished() { return ticksLeft <= 0; }
}

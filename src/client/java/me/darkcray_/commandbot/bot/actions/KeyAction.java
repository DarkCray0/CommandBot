package me.darkcray_.commandbot.bot.actions;

import me.darkcray_.commandbot.bot.utils.ChatMassage;
import me.darkcray_.commandbot.protection.GriefProtection;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public enum KeyAction {

    FORWARD(() -> MinecraftClient.getInstance().options.forwardKey),
    BACK(() -> MinecraftClient.getInstance().options.backKey),
    LEFT(() -> MinecraftClient.getInstance().options.leftKey),
    RIGHT(() -> MinecraftClient.getInstance().options.rightKey),
    SHIFT(() -> MinecraftClient.getInstance().options.sneakKey),
    HOTBAR_1(() -> MinecraftClient.getInstance().options.hotbarKeys[1]),
    HOTBAR_2(() -> MinecraftClient.getInstance().options.hotbarKeys[2]),
    HOTBAR_3(() -> MinecraftClient.getInstance().options.hotbarKeys[3]),
    HOTBAR_4(() -> MinecraftClient.getInstance().options.hotbarKeys[4]),
    HOTBAR_5(() -> MinecraftClient.getInstance().options.hotbarKeys[5]),
    HOTBAR_6(() -> MinecraftClient.getInstance().options.hotbarKeys[6]),
    HOTBAR_7(() -> MinecraftClient.getInstance().options.hotbarKeys[7]),
    HOTBAR_8(() -> MinecraftClient.getInstance().options.hotbarKeys[8]),
    HOTBAR_9(() -> MinecraftClient.getInstance().options.hotbarKeys[9]);

    private final KeySupplier keySupplier;

    KeyAction(KeySupplier supplier) {
        this.keySupplier = supplier;
    }

    public void press() {
        KeyBinding key = keySupplier.get();
        if (key != null) {
            key.setPressed(true);
        }
    }

    public void release() {
        KeyBinding key = keySupplier.get();
        if (key != null) {
            key.setPressed(false);
        }
    }

    public void click() {
        KeyBinding key = keySupplier.get();
        if (key != null) {
            key.setPressed(true);
        }
    }

    @FunctionalInterface
    private interface KeySupplier {
        KeyBinding get();
    }
}

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
    SHIFT(() -> MinecraftClient.getInstance().options.sneakKey);

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

    @FunctionalInterface
    private interface KeySupplier {
        KeyBinding get();
    }
}

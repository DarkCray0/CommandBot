package me.darkcray_.commandbot.bot.actions;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public enum CameraAction {

    LEFT(-5f, 0f),
    RIGHT(5f, 0f),
    UP(0f, -5f),
    DOWN(0f, 5f);

    private final float yawDelta;
    private final float pitchDelta;

    CameraAction(float yawDelta, float pitchDelta) {
        this.yawDelta = yawDelta;
        this.pitchDelta = pitchDelta;
    }

    public void apply() {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player == null) return;

        float yaw = player.getYaw() + yawDelta;
        float pitch = player.getPitch() + pitchDelta;

        pitch = Math.max(-90f, Math.min(90f, pitch));

        player.setYaw(yaw);
        player.setPitch(pitch);
    }
}

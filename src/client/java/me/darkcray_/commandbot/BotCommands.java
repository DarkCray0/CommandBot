package me.darkcray_.commandbot;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

import java.util.List;

public class BotCommands {
    public record BotCommand(
            String keyword,
            KeyBinding key,
            int durationTicks
    ) {}

    public static final List<BotCommand> COMMANDS = List.of(
            new BotCommand("вперед", getOptions().forwardKey, 5),
            new BotCommand("назад", getOptions().backKey, 5),
            new BotCommand("влево", getOptions().leftKey, 5),
            new BotCommand("вправо", getOptions().rightKey, 5),
            new BotCommand("прыжок", getOptions().jumpKey, 5)
    );

    public static GameOptions getOptions() {
        return MinecraftClient.getInstance().options;
    }
}

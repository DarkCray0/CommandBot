package me.darkcray_.commandbot.bot;

import me.darkcray_.commandbot.bot.actions.BotAction;
import me.darkcray_.commandbot.bot.actions.CameraAction;
import me.darkcray_.commandbot.bot.actions.KeyAction;

import java.util.List;
import java.util.function.Supplier;

public record BotCommand(
        String keyword,
        CommandType type,
        Supplier<BotAction> actions
) {
    public BotAction createAction(int repeats) {
        return actions.get().withRepeats(repeats);
    }

    public static final List<BotCommand> COMMANDS = List.of(
            new BotCommand("task-1", CommandType.MOVE, () -> BotAction.move(KeyAction.FORWARD)),
            new BotCommand("task-2", CommandType.MOVE, () -> BotAction.move(KeyAction.BACK)),
            new BotCommand("task-3", CommandType.MOVE, () -> BotAction.move(KeyAction.LEFT)),
            new BotCommand("task-4", CommandType.MOVE, () -> BotAction.move(KeyAction.RIGHT)),

            new BotCommand("task-5", CommandType.HOTBAR, () -> BotAction.hotbar(0)),
            new BotCommand("task-6", CommandType.HOTBAR, () -> BotAction.hotbar(1)),
            new BotCommand("task-7", CommandType.HOTBAR, () -> BotAction.hotbar(2)),
            new BotCommand("task-8", CommandType.HOTBAR, () -> BotAction.hotbar(3)),
            new BotCommand("task-9", CommandType.HOTBAR, () -> BotAction.hotbar(4)),
            new BotCommand("task-10", CommandType.HOTBAR, () -> BotAction.hotbar(5)),
            new BotCommand("task-11", CommandType.HOTBAR, () -> BotAction.hotbar(6)),
            new BotCommand("task-12", CommandType.HOTBAR, () -> BotAction.hotbar(7)),
            new BotCommand("task-13", CommandType.HOTBAR, () -> BotAction.hotbar(8)),

            new BotCommand("task-14", CommandType.CAMERA, () -> BotAction.camera(CameraAction.LEFT)),
            new BotCommand("task-15", CommandType.CAMERA, () -> BotAction.camera(CameraAction.RIGHT)),
            new BotCommand("task-16", CommandType.CAMERA, () -> BotAction.camera(CameraAction.UP)),
            new BotCommand("task-17", CommandType.CAMERA, () -> BotAction.camera(CameraAction.DOWN)),

            new BotCommand("task-18", CommandType.CLICK, BotAction::leftClick),
            new BotCommand("task-19", CommandType.CLICK, BotAction::rightClick),
            new BotCommand("task-20", CommandType.CLICK, BotAction::attack),
            new BotCommand("task-21", CommandType.MOVE, () -> BotAction.move(KeyAction.SHIFT)),
            new BotCommand("task-22", CommandType.MOVE, () -> BotAction.move(KeyAction.JUMP)),
            new BotCommand("task-23", CommandType.OTHER, BotAction::drop),

            new BotCommand("task-24", CommandType.CHAT, () -> BotAction.chat("gsit")),
            new BotCommand("task-25", CommandType.CHAT, () -> BotAction.chat("glay")),
            new BotCommand("task-26", CommandType.CHAT, () -> BotAction.chat("gcrawl")),
            new BotCommand("task-27", CommandType.CHAT, () -> BotAction.chat("suicide"))
    );
}

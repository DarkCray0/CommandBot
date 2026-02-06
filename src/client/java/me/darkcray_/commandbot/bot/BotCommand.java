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
            new BotCommand("вперед", CommandType.MOVE, () -> BotAction.move(KeyAction.FORWARD)),
            new BotCommand("назад", CommandType.MOVE, () -> BotAction.move(KeyAction.BACK)),
            new BotCommand("влево", CommandType.MOVE, () -> BotAction.move(KeyAction.LEFT)),
            new BotCommand("вправо", CommandType.MOVE, () -> BotAction.move(KeyAction.RIGHT)),

            new BotCommand("слот-1", CommandType.HOTBAR, () -> BotAction.hotbar(0)),
            new BotCommand("слот-2", CommandType.HOTBAR, () -> BotAction.hotbar(1)),
            new BotCommand("слот-3", CommandType.HOTBAR, () -> BotAction.hotbar(2)),
            new BotCommand("слот-4", CommandType.HOTBAR, () -> BotAction.hotbar(3)),
            new BotCommand("слот-5", CommandType.HOTBAR, () -> BotAction.hotbar(4)),
            new BotCommand("слот-6", CommandType.HOTBAR, () -> BotAction.hotbar(5)),
            new BotCommand("слот-7", CommandType.HOTBAR, () -> BotAction.hotbar(6)),
            new BotCommand("слот-8", CommandType.HOTBAR, () -> BotAction.hotbar(7)),
            new BotCommand("слот-9", CommandType.HOTBAR, () -> BotAction.hotbar(8)),

            new BotCommand("налево", CommandType.CAMERA, () -> BotAction.camera(CameraAction.LEFT)),
            new BotCommand("направо", CommandType.CAMERA, () -> BotAction.camera(CameraAction.RIGHT)),
            new BotCommand("вверх", CommandType.CAMERA, () -> BotAction.camera(CameraAction.UP)),
            new BotCommand("вниз", CommandType.CAMERA, () -> BotAction.camera(CameraAction.DOWN)),

            new BotCommand("лкм", CommandType.CLICK, BotAction::leftClick),
            new BotCommand("пкм", CommandType.CLICK, BotAction::rightClick),
            new BotCommand("удар", CommandType.CLICK, () -> BotAction.move(KeyAction.ATTACK)),
            new BotCommand("присесть", CommandType.MOVE, () -> BotAction.move(KeyAction.SHIFT)),
            new BotCommand("прыгнуть", CommandType.MOVE, () -> BotAction.move(KeyAction.JUMP)),
            new BotCommand("выбросить", CommandType.OTHER, BotAction::drop),

            new BotCommand("сесть", CommandType.CHAT, () -> BotAction.chat("gsit")),
            new BotCommand("лечь", CommandType.CHAT, () -> BotAction.chat("glay")),
            new BotCommand("ползти", CommandType.CHAT, () -> BotAction.chat("gcrawl"))
    );
}

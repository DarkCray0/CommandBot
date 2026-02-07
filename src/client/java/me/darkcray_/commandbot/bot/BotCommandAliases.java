package me.darkcray_.commandbot.bot;

import java.util.List;
import java.util.Map;

public class BotCommandAliases {
    public static final Map<String, List<String>> ALIASES = Map.ofEntries(
            Map.entry("task-1", List.of("вперед", "вперёд", "вп", "forward", "fwd")),
            Map.entry("task-2", List.of("назад", "нз", "back", "bk")),
            Map.entry("task-3", List.of("влево", "вл", "left", "lt")),
            Map.entry("task-4", List.of("вправо", "вп", "right", "rt")),

            Map.entry("task-5", List.of("слот-1", "1", "slot-1")),
            Map.entry("task-6", List.of("слот-2", "2", "slot-2")),
            Map.entry("task-7", List.of("слот-3", "3", "slot-3")),
            Map.entry("task-8", List.of("слот-4", "4", "slot-4")),
            Map.entry("task-9", List.of("слот-5", "5", "slot-5")),
            Map.entry("task-10", List.of("слот-6", "6", "slot-6")),
            Map.entry("task-11", List.of("слот-7", "7", "slot-7")),
            Map.entry("task-12", List.of("слот-8", "8", "slot-8")),
            Map.entry("task-13", List.of("слот-9", "9", "slot-9")),

            Map.entry("task-14", List.of("налево", "нл", "turn-left", "cam-left")),
            Map.entry("task-15", List.of("направо", "нп", "turn-right", "cam-right")),
            Map.entry("task-16", List.of("вверх", "вв", "up", "cam-up")),
            Map.entry("task-17", List.of("вниз", "вн", "down", "cam-down")),

            Map.entry("task-18", List.of("лкм", "lc", "left-click")),
            Map.entry("task-19", List.of("пкм", "rc", "right-click")),
            Map.entry("task-20", List.of("удар", "ударить", "atk", "attack")),

            Map.entry("task-21", List.of("присесть", "шифт", "shift", "sneak")),
            Map.entry("task-22", List.of("прыгнуть", "прыжок", "jmp", "jump")),

            Map.entry("task-23", List.of("выбросить", "выкинуть", "drop")),

            Map.entry("task-24", List.of("сесть", "sit")),
            Map.entry("task-25", List.of("лечь", "lay")),
            Map.entry("task-26", List.of("ползти", "crawl")),
            Map.entry("task-27", List.of("умереть", "kill"))
    );

    public static List<String> getAliases(String keyword) {
        return ALIASES.getOrDefault(keyword, List.of());
    }
}

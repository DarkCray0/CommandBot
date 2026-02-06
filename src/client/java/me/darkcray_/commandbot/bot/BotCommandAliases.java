package me.darkcray_.commandbot.bot;

import java.util.List;
import java.util.Map;

public class BotCommandAliases {
    public static final Map<String, List<String>> ALIASES = Map.ofEntries(
            Map.entry("вперед", List.of("вперед", "вп", "forward", "fwd")),
            Map.entry("назад", List.of("назад", "нз", "back", "bk")),
            Map.entry("влево", List.of("влево", "вл", "left", "lt")),
            Map.entry("вправо", List.of("вправо", "вп", "right", "rt")),

            Map.entry("слот-1", List.of("слот-1", "1", "slot-1")),
            Map.entry("слот-2", List.of("слот-2", "2", "slot-2")),
            Map.entry("слот-3", List.of("слот-3", "3", "slot-3")),
            Map.entry("слот-4", List.of("слот-4", "4", "slot-4")),
            Map.entry("слот-5", List.of("слот-5", "5", "slot-5")),
            Map.entry("слот-6", List.of("слот-6", "6", "slot-6")),
            Map.entry("слот-7", List.of("слот-7", "7", "slot-7")),
            Map.entry("слот-8", List.of("слот-8", "8", "slot-8")),
            Map.entry("слот-9", List.of("слот-9", "9", "slot-9")),

            Map.entry("налево", List.of("налево", "нл", "turn-left", "cam-left")),
            Map.entry("направо", List.of("направо", "нп", "turn-right", "cam-right")),
            Map.entry("вверх", List.of("вверх", "вв", "up", "cam-up")),
            Map.entry("вниз", List.of("вниз", "вн", "down", "cam-down")),

            Map.entry("лкм", List.of("лкм", "lc", "left-click")),
            Map.entry("пкм", List.of("пкм", "rc", "right-click")),
            Map.entry("удар", List.of("удар", "atk", "attack")),

            Map.entry("присесть", List.of("присесть", "shift", "sneak")),
            Map.entry("прыгнуть", List.of("прыгнуть", "jmp", "jump")),

            Map.entry("выбросить", List.of("выбросить", "drop")),

            Map.entry("сесть", List.of("сесть", "sit")),
            Map.entry("лечь", List.of("лечь", "lay")),
            Map.entry("ползти", List.of("ползти", "crawl"))
    );

    public static List<String> getAliases(String keyword) {
        return ALIASES.getOrDefault(keyword, List.of());
    }
}

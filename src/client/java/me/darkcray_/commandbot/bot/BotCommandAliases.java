package me.darkcray_.commandbot.bot;

import java.util.List;
import java.util.Map;

public class BotCommandAliases {
    public static final Map<String, List<String>> ALIASES = Map.ofEntries(
            Map.entry("вперед", List.of("вперед", "fwd")),
            Map.entry("назад", List.of("назад", "bk")),
            Map.entry("влево", List.of("влево", "lt")),
            Map.entry("вправо", List.of("вправо", "rt")),
            Map.entry("слот-1", List.of("слот-1")),
            Map.entry("слот-2", List.of("слот-2")),
            Map.entry("слот-3", List.of("слот-3")),
            Map.entry("налево", List.of("turn-left", "cam-left")),
            Map.entry("направо", List.of("turn-right", "cam-right")),
            Map.entry("лкм", List.of("left-click")),
            Map.entry("пкм", List.of("right-click"))
    );

    public static List<String> getAliases(String keyword) {
        return ALIASES.getOrDefault(keyword, List.of());
    }
}

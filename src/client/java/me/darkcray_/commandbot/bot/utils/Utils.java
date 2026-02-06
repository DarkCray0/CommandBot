package me.darkcray_.commandbot.bot.utils;

import me.darkcray_.commandbot.bot.BotCommand;

import java.util.stream.Collectors;

public class Utils {
    public static String listAllCommands() {
        return BotCommand.COMMANDS.stream()
                .map(cmd -> {
                    String kw = cmd.keyword();
                    if (kw.startsWith("слот-")) return "слот-(1-9)";
                    return kw;
                })
                .distinct()
                .collect(Collectors.joining(", "));
    }
}

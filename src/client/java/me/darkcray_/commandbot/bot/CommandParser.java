package me.darkcray_.commandbot.bot;

import me.darkcray_.commandbot.bot.utils.ChatMassage;
import net.minecraft.client.resource.language.I18n;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    private static final Pattern COMMAND_PATTERN =
            Pattern.compile("([а-яa-z0-9\\-]+)(?:\\((\\d+)\\))?");

    public static void parse(String message) {
        if (message == null) return;

        message = message.toLowerCase().trim();

        int botIndex = message.indexOf(I18n.translate("commandbot.text.command_prefix"));
        if (botIndex == -1) return;

        String afterBot = message.substring(botIndex + 3).trim();
        if (afterBot.isEmpty()) {
            ChatMassage.sendChatMessage(I18n.translate("commandbot.text.unknown_command"));
            return;
        }

        String[] parts = afterBot.split(",");

        boolean foundAny = false;

        for (String part : parts) {
            part = part.trim();
            if (part.isEmpty()) continue;

            Matcher matcher = COMMAND_PATTERN.matcher(part);
            if (!matcher.matches()) continue;

            String keywordOrAlias = matcher.group(1);
            int repeats = 1;

            if (matcher.group(2) != null) {
                try {
                    repeats = Integer.parseInt(matcher.group(2));
                } catch (NumberFormatException ignored) {}
            }

            repeats = Math.min(repeats, 20);

            for (BotCommand cmd : BotCommand.COMMANDS) {
                List<String> allAliases = BotCommandAliases.getAliases(cmd.keyword());
                allAliases = new java.util.ArrayList<>(allAliases);
                allAliases.add(cmd.keyword());

                if (allAliases.contains(keywordOrAlias)) {
                    BotController.enqueue(cmd.createAction(repeats), cmd.type());
                    foundAny = true;
                    break;
                }
            }
        }

        if (!foundAny) {
            ChatMassage.sendChatMessage(I18n.translate("commandbot.text.unknown_command"));
        }
    }
}
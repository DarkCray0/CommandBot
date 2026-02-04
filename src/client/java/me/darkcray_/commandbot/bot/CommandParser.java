package me.darkcray_.commandbot.bot;

public class CommandParser {
    public static void parse(String message) {
        message = message.toLowerCase();

        for (BotCommand cmd : BotCommand.COMMANDS) {
            if (message.contains(cmd.keyword())) {

                int repeats = extractRepeats(message, cmd.keyword());
                repeats = Math.min(repeats, 20);

                BotController.enqueue(cmd.createAction(repeats), cmd.type());
                break;
            }
        }
    }

    private static int extractRepeats(String msg, String keyword) {
        String[] parts = msg.split("\\s+");

        for (int i = 0; i < parts.length - 1; i++) {
            if (parts[i].equals(keyword)) {
                try {
                    return Integer.parseInt(parts[i + 1]);
                } catch (NumberFormatException ignored) {}
            }
        }

        return 1;
    }
}

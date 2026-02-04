package me.darkcray_.commandbot;

import me.darkcray_.commandbot.bot.BotController;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandBotClient implements ClientModInitializer {

    public static final String MOD_ID = "command-bot";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("CommandBot запушен!");
        BotController.init();
    }
}

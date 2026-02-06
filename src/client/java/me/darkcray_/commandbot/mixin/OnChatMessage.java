package me.darkcray_.commandbot.mixin;

import me.darkcray_.commandbot.CommandBotClient;
import me.darkcray_.commandbot.bot.BotController;
import me.darkcray_.commandbot.bot.CommandParser;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MessageHandler.class)
public class OnChatMessage {
    @Inject(method = "onGameMessage(Lnet/minecraft/text/Text;Z)V", at = @At("HEAD"))
    public void onGameMessage(Text message, boolean overlay, CallbackInfo info) {
        if (CommandBotClient.isEnable) CommandParser.parse(message.getString().toLowerCase());
    }
}

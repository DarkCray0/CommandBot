package me.darkcray_.commandbot;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {
    public static KeyBinding ENABLE_KEY;

    public static void register() {
        ENABLE_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "commandbot.settings.enable_key",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_O,
                        KeyBinding.Category.MISC
                )
        );
    }
}

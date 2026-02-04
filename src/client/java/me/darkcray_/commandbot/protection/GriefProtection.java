package me.darkcray_.commandbot.protection;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

import java.util.Set;

public class GriefProtection {

    private static final Set<Item> FORBIDDEN_ITEMS = Set.of(
            Items.END_CRYSTAL,
            Items.TNT,
            Items.FLINT_AND_STEEL,
            Items.RESPAWN_ANCHOR,
            Items.LAVA_BUCKET,
            Items.WRITABLE_BOOK,
            Items.WRITTEN_BOOK
    );

    private static final Set<Block> FORBIDDEN_BLOCKS = Set.of(
            Blocks.RESPAWN_ANCHOR,
            Blocks.TNT,
            // Хранилища
            Blocks.CHEST,
            Blocks.TRAPPED_CHEST,
            Blocks.BARREL,
            Blocks.ENDER_CHEST,
            Blocks.SHULKER_BOX,
            Blocks.WHITE_SHULKER_BOX,
            Blocks.ORANGE_SHULKER_BOX,
            Blocks.MAGENTA_SHULKER_BOX,
            Blocks.LIGHT_BLUE_SHULKER_BOX,
            Blocks.YELLOW_SHULKER_BOX,
            Blocks.LIME_SHULKER_BOX,
            Blocks.PINK_SHULKER_BOX,
            Blocks.GRAY_SHULKER_BOX,
            Blocks.LIGHT_GRAY_SHULKER_BOX,
            Blocks.CYAN_SHULKER_BOX,
            Blocks.PURPLE_SHULKER_BOX,
            Blocks.BLUE_SHULKER_BOX,
            Blocks.BROWN_SHULKER_BOX,
            Blocks.GREEN_SHULKER_BOX,
            Blocks.RED_SHULKER_BOX,
            Blocks.BLACK_SHULKER_BOX,
            // Механизмы и производство
            Blocks.FURNACE,
            Blocks.BLAST_FURNACE,
            Blocks.SMOKER,
            Blocks.BREWING_STAND,
            Blocks.HOPPER,
            Blocks.DISPENSER,
            Blocks.DROPPER,
            Blocks.CRAFTER,
            // Рабочие столы
            Blocks.CRAFTING_TABLE,
            Blocks.ANVIL,
            Blocks.CHIPPED_ANVIL,
            Blocks.DAMAGED_ANVIL,
            Blocks.LOOM,
            Blocks.CARTOGRAPHY_TABLE,
            Blocks.GRINDSTONE,
            Blocks.SMITHING_TABLE,
            Blocks.STONECUTTER,
            Blocks.ENCHANTING_TABLE,
            // Прочее с GUI
            Blocks.BEACON,
            Blocks.LECTERN,
            // Технические блоки
            Blocks.COMMAND_BLOCK,
            Blocks.CHAIN_COMMAND_BLOCK,
            Blocks.REPEATING_COMMAND_BLOCK,
            Blocks.STRUCTURE_BLOCK,
            Blocks.JIGSAW,
            // Кровати
            Blocks.WHITE_BED,
            Blocks.ORANGE_BED,
            Blocks.MAGENTA_BED,
            Blocks.LIGHT_BLUE_BED,
            Blocks.YELLOW_BED,
            Blocks.LIME_BED,
            Blocks.PINK_BED,
            Blocks.GRAY_BED,
            Blocks.LIGHT_GRAY_BED,
            Blocks.CYAN_BED,
            Blocks.PURPLE_BED,
            Blocks.BLUE_BED,
            Blocks.BROWN_BED,
            Blocks.GREEN_BED,
            Blocks.RED_BED,
            Blocks.BLACK_BED
    );

    private static final Set<EntityType<?>> FORBIDDEN_ENTITIES = Set.of(
            EntityType.END_CRYSTAL,
            EntityType.TNT_MINECART,
            EntityType.ARMOR_STAND,
            // Мобы на которых можно экипировать сундук
            EntityType.MULE,
            EntityType.LLAMA,
            EntityType.TRADER_LLAMA,
            // Транспортные средства с инвентарем
            EntityType.CHEST_MINECART,
            EntityType.HOPPER_MINECART,
            EntityType.OAK_CHEST_BOAT,
            EntityType.SPRUCE_CHEST_BOAT,
            EntityType.BIRCH_CHEST_BOAT,
            EntityType.JUNGLE_CHEST_BOAT,
            EntityType.ACACIA_CHEST_BOAT,
            EntityType.DARK_OAK_CHEST_BOAT,
            EntityType.MANGROVE_CHEST_BOAT,
            EntityType.CHERRY_CHEST_BOAT,
            EntityType.BAMBOO_CHEST_RAFT,
            EntityType.PALE_OAK_CHEST_BOAT
    );

    public static boolean isForbiddenAction() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.world == null) return true;

        Item heldItem = client.player.getMainHandStack().getItem();
        if (FORBIDDEN_ITEMS.contains(heldItem)) {
            return true;
        }

        HitResult hit = client.crosshairTarget;
        if (hit == null) return false;
        
        if (hit instanceof BlockHitResult blockHit) {
            Block block = client.world
                    .getBlockState(blockHit.getBlockPos())
                    .getBlock();
            return FORBIDDEN_BLOCKS.contains(block);
        }
        
        if (hit instanceof EntityHitResult entityHit) {
            Entity entity = entityHit.getEntity();
            return FORBIDDEN_ENTITIES.contains(entity.getType());
        }

        return false;
    }
}

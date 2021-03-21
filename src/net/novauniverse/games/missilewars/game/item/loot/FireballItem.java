package net.novauniverse.games.missilewars.game.item.loot;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.novauniverse.games.missilewars.game.world.SpawnItems;
import net.zeeraa.novacore.spigot.module.modules.customitems.CustomItem;
import net.zeeraa.novacore.spigot.utils.ItemBuilder;
import net.zeeraa.novacore.spigot.utils.ItemUtils;

public class FireballItem extends CustomItem {
	@Override
	protected ItemStack createItemStack(Player player) {
		return new ItemBuilder(Material.FIREBALL).setName(ChatColor.GOLD + "Fireball").build();
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getGameMode() == GameMode.SPECTATOR) {
				return;
			}

			ItemUtils.removeOneFromHand(e.getPlayer());
			SpawnItems.spawnFireball(e.getPlayer());
			e.setCancelled(true);
		}
	}
}
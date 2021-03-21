package net.novauniverse.games.missilewars.game.item;


import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.novauniverse.games.missilewars.game.team.MissileWarsTeam;
import net.zeeraa.novacore.spigot.module.modules.customitems.CustomItem;
import net.zeeraa.novacore.spigot.teams.TeamManager;

public abstract class PlayerArmorItem extends CustomItem {
	private Material material;
	
	public PlayerArmorItem(Material material) {
		this.material = material;
	}
	
	@Override
	protected ItemStack createItemStack(Player player) {
		ItemStack stack = new ItemStack(material);
		
		LeatherArmorMeta meta = (LeatherArmorMeta)stack.getItemMeta();
		
		Color color = Color.WHITE;
		
		if(player != null) {
		MissileWarsTeam team = (MissileWarsTeam) TeamManager.getTeamManager().getPlayerTeam(player);
			if(team != null) {
				switch (team.getColor()) {
				case GREEN:
					color = Color.LIME;
					break;

				case RED:
					color = Color.RED;
					break;
					
				default:
					break;
				}
			}
		}
		
		meta.setColor(color);
		
		meta.spigot().setUnbreakable(true);
		
		stack.setItemMeta(meta);
		
		return stack;
	}
	
	@Override
	public void onInventoryClick(InventoryClickEvent event) {
		event.setCancelled(true);
	}
	
	@Override
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
}
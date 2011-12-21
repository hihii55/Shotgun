package com.thebkkingdom.Shotgun.Listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

public class playerListener extends PlayerListener {

	public void onPlayerInteract(PlayerInteractEvent ev) {

		Player player = ev.getPlayer();
		World world = player.getWorld();
		Location playerLoc = player.getLocation();
		ItemStack arrow = new ItemStack(Material.ARROW, 5);

		if (ev.getAction() == Action.LEFT_CLICK_AIR) {
			if (player.getItemInHand().getType() == Material.BOOK) {
				if (player.hasPermission("s.shotgun") || player.isOp()) {
					player.shootArrow();
					player.shootArrow();
					player.shootArrow();
					player.shootArrow();
					player.shootArrow();
					world.playEffect(playerLoc, Effect.BOW_FIRE, 50);
					world.createExplosion(playerLoc, -1);
					world.createExplosion(playerLoc, -1);
					world.playEffect(playerLoc, Effect.SMOKE, 105);

					player.getInventory().removeItem(arrow);
				}
			}
		}
	}

}

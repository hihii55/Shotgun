package me.butkicker12.Shotgun;

import net.minecraft.server.EntityFireball;
import net.minecraft.server.EntityLiving;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PL extends PlayerListener {

	Shotgun plugin;

	public PL(Shotgun instance) {
		plugin = instance;
	}

	public void onPlayerInteract(PlayerInteractEvent event) {

		// ----Variables----
		Player p = event.getPlayer();
		World w = p.getWorld();
		Location loc = p.getLocation();
		ItemStack arrow = new ItemStack(Material.ARROW, 5);
		// ItemStack egg = new ItemStack(Material.EGG,1);

		if (event.getAction() == Action.LEFT_CLICK_AIR) {
			// ----Shotgun----
			if (p.getItemInHand().getType() == Material.BOOK) {
				if (p.hasPermission("s.shotgun")) {
					if (plugin.Shotgun) {
						p.shootArrow();
						p.shootArrow();
						p.shootArrow();
						p.shootArrow();
						p.shootArrow();
						w.playEffect(loc, Effect.BOW_FIRE, 50);
						w.playEffect(loc, Effect.SMOKE, 5);
						w.createExplosion(loc, -1);
						w.createExplosion(loc, -1);
						w.playEffect(loc, Effect.SMOKE, 100);

						p.getInventory().removeItem(arrow);

						p.sendMessage("You do not have enough arrows");

					}
				}
			}
			// ----Smoke Grenade----
			if (p.getItemInHand().getType() == Material.SNOW_BALL) {
				p.throwSnowball();
				w.playEffect(loc, Effect.EXTINGUISH, 100);
				// if(p.throwSnowball()!= null){

			}
			// ----Grenade----
			if (p.getItemInHand().getType() == Material.EGG) {
				p.throwEgg();
			}
		}
		// ----Rocket Launcher----
		if (event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (p.getItemInHand().getType() == Material.BOOK) {
				if (plugin.RocketLauncher == true) {
					Player player = event.getPlayer();
					net.minecraft.server.World notchWorld = null;
					EntityFireball notchEntity = null;
					Vector velocity = null;
					CraftPlayer playerE = (CraftPlayer) player;
					Location location = player.getEyeLocation();
					notchWorld = ((CraftWorld) player.getWorld()).getHandle();
					EntityLiving playerEntity = playerE.getHandle();
					notchEntity = new EntityFireball(notchWorld, playerEntity,
							location.getX(), location.getY(), location.getZ());
					velocity = player.getEyeLocation().getDirection()
							.multiply(10);
					notchWorld.addEntity(notchEntity);
					Entity Bukkitentity = notchEntity.getBukkitEntity();
					Bukkitentity.teleport(player.getEyeLocation());
					Bukkitentity.setVelocity(velocity);
				}
			}
		}
	}
}

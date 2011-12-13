package me.butkicker12.Shotgun;

import java.util.logging.Logger;

import net.minecraft.server.EntityFireball;
import net.minecraft.server.EntityLiving;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Shotgun extends JavaPlugin {

	/**
	 * @author butkicker12
	 */

	// ----Variables----
	private final PL playerListener = new PL(this);
	private final EL entityListener = new EL(this);
	Logger log = Logger.getLogger("Minecraft");
	FileConfiguration config;
	public boolean Shotgun;
	public boolean SmokeBomb;
	public boolean RocketLauncher;
	public boolean RocketLauncherExplosion;
	public boolean Grenade;
	public boolean Nuke;
	public boolean Airstrike;
	public boolean Debug;

	@Override
	public void onDisable() {
		log.info("[Shotgun] disabled");
	}

	@Override
	public void onEnable() {
		setupConfig();
		loadConfig();

		registerEvents();

		log.info("[Shotgun] Enabled version " + getDescription().getVersion());
	}

	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel,
			String[] args) {
		Player p = (Player) cs;
		World w = p.getWorld();
		Block target = p.getTargetBlock(null, 200);
		Location targetloc = target.getLocation();
		if (cmd.getName().equalsIgnoreCase("s") && args.length == 1) {
			if (args.length != 1) {
				helpMessage(cs);
			}
			if (args[0].equalsIgnoreCase("help")) {
				helpMessage(cs);
				return true;
			} else if (args[0].equalsIgnoreCase("nuke")) {
				if (Nuke == true) {
					w.createExplosion(targetloc, 50);
					cs.sendMessage(ChatColor.BLUE
							+ "[Shotgun] Nuclear attack called on your crosshairs");
				}
				return true;
			} else if (args[0].equalsIgnoreCase("airstrike")) {
				if (p.isOp() || p.hasPermission("s.airstrike")) {
					if (Airstrike == true) {
						target.getWorld().strikeLightning(targetloc);
						target.getWorld().createExplosion(targetloc, 5);
						cs.sendMessage(ChatColor.BLUE
								+ "[Shotgun] Airstrike called at your crosshairs");
					}
				}
				return true;
			}
		}
		return false;
	}

	/*
	 * Not used
	 */
	
	public void fireballLaunch(Player player) {
		CraftPlayer craftPlayer = (CraftPlayer) player;
		EntityLiving playerEntity = craftPlayer.getHandle();
		Vector lookat = player.getLocation().getDirection().multiply(10);

		Location loc = player.getLocation();

		EntityFireball fball = new EntityFireball(
				((CraftWorld) player.getWorld()).getHandle(), playerEntity,
				lookat.getX(), lookat.getY(), lookat.getZ());

		fball.locX = loc.getX() + (lookat.getX() / 5.0) + 0.25;
		fball.locY = loc.getY() + (player.getEyeHeight() / 2.0) + 0.5;
		fball.locZ = loc.getZ() + (lookat.getZ() / 5.0);

		((CraftWorld) player.getWorld()).getHandle().addEntity(fball);
	}

	public void setupConfig() {
		this.config = getConfig();
		config.options().header("Shotgun Configuration");
		config.addDefault("weapons.shotgun.use", true);
		config.addDefault("weapons.smokebomb.use", true);
		config.addDefault("weapons.rocketlauncher.use", true);
		config.addDefault("weapons.rocketlauncher.explosion", false);
		config.addDefault("weapons.grenade.use", true);
		config.addDefault("weapons.nuke.use", true);
		config.addDefault("weapons.airstrike.use", true);
		config.addDefault("debug.version", getDescription().getVersion());
		config.addDefault("debug.config", false);
		config.options().copyDefaults(true);
		saveConfig();
	}

	public void loadConfig() {
		Shotgun = config.getBoolean("weapons.shotgun.use", true);
		SmokeBomb = config.getBoolean("weapons.smokebomb.use", true);
		RocketLauncher = config.getBoolean("weapons.rocketlauncher.use", true);
		RocketLauncherExplosion = config
				.getBoolean("weapons.grenade.use", true);
		Grenade = config.getBoolean("weapons.grenade.use", true);
		Nuke = config.getBoolean("weapons.nuke.use", true);
		Airstrike = config.getBoolean("weapons.airstrike.use", true);
		Debug = config.getBoolean("debug.config", false);
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener,
				Priority.Normal, this);
		pm.registerEvent(Event.Type.PROJECTILE_HIT, entityListener,
				Priority.Normal, this);
	}

	public void helpMessage(CommandSender cs) {
		cs.sendMessage(ChatColor.GREEN + "----[Shotgun]----");
		cs.sendMessage(ChatColor.BLUE + "/s help - Shows this menu");
		cs.sendMessage(ChatColor.BLUE
				+ "/s airstrike - Send a airstrike of lighting to your crosshairs.");
		cs.sendMessage(ChatColor.BLUE
				+ "/s nuke - Calls a nuclear strike at your crosshairs!");
	}
}

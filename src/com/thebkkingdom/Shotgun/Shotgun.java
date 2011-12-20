package com.thebkkingdom.Shotgun;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.thebkkingdom.Shotgun.Listeners.entityListener;
import com.thebkkingdom.Shotgun.Listeners.playerListener;

public class Shotgun extends JavaPlugin {

	private static Shotgun instance;
	private static String prefix = "[Shotgun]";

	public void onDisable() {
		ShotgunLogger.log(Level.INFO, " Disabled version: "
				+ getDescription().getVersion());
	}

	public void onEnable() {
		instance = this;
		ShotgunCommands.registerCommands();
		registerEvents();
		ShotgunConfiguration.setup();

		ShotgunLogger.log(Level.INFO, " Enabled version: "
				+ getDescription().getVersion());
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvent(Type.PLAYER_INTERACT, new playerListener(),
				Priority.Normal, this);
		pm.registerEvent(Type.PROJECTILE_HIT, new entityListener(),
				Priority.Normal, this);
	}

	public static Shotgun getInstance() {
		return instance;
	}

	public static String getPrefix() {
		return prefix;
	}
}

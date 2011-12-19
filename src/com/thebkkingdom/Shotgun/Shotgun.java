package com.thebkkingdom.Shotgun;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.thebkkingdom.Shotgun.Listeners.EventsHandler;

public class Shotgun extends JavaPlugin {

	private static Shotgun instance;
	private static String prefix = "[Shotgun]";

	public void onDisable() {
		ShotgunLogger.log(Level.INFO, " Disabled version: "
				+ getDescription().getVersion());
	}

	public void onEnable() {
		ShotgunCommands.registerCommands();
		EventsHandler.registerEvents();
		ShotgunConfiguration.setup();

		ShotgunLogger.log(Level.INFO, " Enabled version: "
				+ getDescription().getVersion());
	}

	public static Shotgun getInstance() {
		return instance;
	}

	public static String getPrefix() {
		return prefix;
	}
}

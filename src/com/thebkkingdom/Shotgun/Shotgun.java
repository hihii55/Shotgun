package com.thebkkingdom.Shotgun;

import org.bukkit.plugin.java.JavaPlugin;

import com.thebkkingdom.Shotgun.Listeners.EventsHandler;

public class Shotgun extends JavaPlugin {

	private static Shotgun instance;
	private static String prefix = "[Shotgun]";

	public void onDisable() {

	}

	public void onEnable() {
		ShotgunCommands.registerCommands();
		EventsHandler.registerEvents();
		ShotgunConfiguration.setup();
	}

	public static Shotgun getInstance() {
		return instance;
	}

	public static String getPrefix() {
		return prefix;
	}
}

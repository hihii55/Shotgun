package com.thebkkingdom.Shotgun.Listeners;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;

import com.thebkkingdom.Shotgun.Shotgun;

public class EventsHandler {

	public static void registerEvents() {
		Shotgun.getInstance()
				.getServer()
				.getPluginManager()
				.registerEvent(Type.PLAYER_INTERACT, new playerListener(),
						Priority.Normal, Shotgun.getInstance());
		Shotgun.getInstance()
				.getServer()
				.getPluginManager()
				.registerEvent(Type.PROJECTILE_HIT, new entityListener(),
						Priority.Normal, Shotgun.getInstance());
	}

}

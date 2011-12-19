package com.thebkkingdom.Shotgun;

public class ShotgunConfiguration {

	public static void setup() {
		Shotgun.getInstance()
				.getConfig()
				.options()
				.header("# Shotgun Configuration/n"
						+ "# Version: "
						+ Shotgun.getInstance().getDescription().getVersion()
						+ "/n"
						+ "# If you need help please make a ticket http://dev.bukkit.org/server-mods/shotgun/tickets/ /n"
						+ "# Or post in the forum: http://dev.bukkit.org/server-mods/shotgun/forum/ /n");

		if (Shotgun.getInstance().getConfig().get("weapons.shotgun.use") == null) {
			Shotgun.getInstance().getConfig().set("weapons.shotgun.use", true);
			Shotgun.getInstance().saveConfig();
		}

		if (Shotgun.getInstance().getConfig().get("weapons.rocketlauncher.use") == null) {
			Shotgun.getInstance().getConfig()
					.set("weapons.rocketlauncher.use", true);
			Shotgun.getInstance().saveConfig();
		}

		if (Shotgun.getInstance().getConfig()
				.get("weapons.rocketlauncher.explosion") == null) {
			Shotgun.getInstance().getConfig()
					.set("weapons.rocketlauncher.explosion", false);
			Shotgun.getInstance().saveConfig();
		}

		if (Shotgun.getInstance().getConfig().get("weapons.grenade.use") == null) {
			Shotgun.getInstance().getConfig().set("weapons.grenade.use", true);
			Shotgun.getInstance().saveConfig();
		}
		
		if(Shotgun.getInstance().getConfig().get("") == null){
			
		}
	}
}

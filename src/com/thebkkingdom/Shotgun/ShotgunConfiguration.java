package com.thebkkingdom.Shotgun;

public class ShotgunConfiguration {

	private static ShotgunConfiguration config;
	public boolean shotgunWeapon = Shotgun.getInstance().getConfig().getBoolean("weapons.shotgun.use");
	public boolean rocketLauncher = Shotgun.getInstance().getConfig().getBoolean("weapons.rocketlauncher.use");
	public boolean rocketLauncherExplosion = Shotgun.getInstance().getConfig().getBoolean("weapons.rocketlauncher.explosion");
	public boolean grenade = Shotgun.getInstance().getConfig().getBoolean("weapons.grenade.use");
	public boolean nuke = Shotgun.getInstance().getConfig().getBoolean("weapons.nuke.use");
	public boolean airstrike = Shotgun.getInstance().getConfig().getBoolean("weapons.airstrike.use");
			
	public static void setup() {
		Shotgun.getInstance()
				.getConfig()
				.options()
				.header(" Shotgun Configuration /n"
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

		if (Shotgun.getInstance().getConfig().get("weapons.nuke.use") == null) {
			Shotgun.getInstance().getConfig().set("weapons.nuke.use", true);
			Shotgun.getInstance().saveConfig();
		}

		if (Shotgun.getInstance().getConfig().get("weapons.airstrike.use") == null) {
			Shotgun.getInstance().getConfig()
					.set("weapons.airstrike.use", true);
			Shotgun.getInstance().saveConfig();
		}

		if (Shotgun.getInstance().getConfig().get("log") == null) {
			Shotgun.getInstance().getConfig().set("log", false);
			Shotgun.getInstance().saveConfig();
		}
	}

	public static ShotgunConfiguration getInstance() {
		return config;
	}
}

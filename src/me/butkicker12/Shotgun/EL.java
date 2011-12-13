package me.butkicker12.Shotgun;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class EL extends EntityListener {

	Shotgun plugin;

	public EL(Shotgun instance) {
		plugin = instance;
	}

	public void onProjectileHit(ProjectileHitEvent event) {

		// ----Variables----
		Entity e = event.getEntity();
		World w = e.getWorld();
		Location loc = e.getLocation();

		// ----Shotgun----
		if (e instanceof org.bukkit.entity.Arrow) {
			w.playEffect(loc, Effect.SMOKE, 50);
		}

		// ----Smoke Grenade----
		if (e instanceof org.bukkit.entity.Snowball) {
			if (plugin.SmokeBomb) {
				w.playEffect(loc, Effect.SMOKE, 10000);
				w.playEffect(loc, Effect.SMOKE, 10000);
				w.playEffect(loc, Effect.SMOKE, 10000);
				w.createExplosion(loc, -50);
			}
		}
		// ----Grenade----
		if (e instanceof org.bukkit.entity.Egg) {
			if (plugin.Grenade) {
				w.createExplosion(loc, 6);
			}
		}
		// ----Fireball----
		if (e instanceof org.bukkit.entity.Fireball) {
			if (plugin.RocketLauncherExplosion) {
				w.createExplosion(loc, 7);
			}
		}
	}
}

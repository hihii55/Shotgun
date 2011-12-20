package com.thebkkingdom.Shotgun;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShotgunCommands implements CommandExecutor {

	private static ShotgunCommands s;

	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdLabel, String[] args) {

		Player player = (Player) sender;
		Block target = player.getTargetBlock(null, 200);
		Location targetloc = target.getLocation();

		if (cmd.getName().equalsIgnoreCase("s") && args.length == 1) {

			if (args[0].equalsIgnoreCase("help")
					&& player.hasPermission("shotgun.help")) {
				helpMessage(sender);
			} else if (args[0].equalsIgnoreCase("nuke")
					&& player.hasPermission("shotgun.nuke")) {
				if (ShotgunConfiguration.getInstance().nuke == true) {
					player.getWorld().createExplosion(targetloc, 50);
					sender.sendMessage(ChatColor.BLUE + Shotgun.getPrefix()
							+ " Nuclear attack called at your crosshairs");
				}
			} else if (args[0].equalsIgnoreCase("airstrike")
					&& player.hasPermission("shotgun.airstrike")) {
				if (ShotgunConfiguration.getInstance().airstrike == true) {
					target.getWorld().strikeLightning(targetloc);
					target.getWorld().createExplosion(targetloc, 5);
					sender.sendMessage(ChatColor.BLUE + Shotgun.getPrefix()
							+ " Airstrike called at your crosshairs");
				}
			}
		}
		return false;
	}

	public static void registerCommands() {
		Shotgun.getInstance().getCommand("Shotgun").setExecutor(s);
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

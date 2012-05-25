package se.myller.GuestUnlock.Commands;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import se.myller.GuestUnlock.Main;

public class GuTest {

	private Main plugin;

	public GuTest(Main instance) {
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender) {
		plugin.log("DEBUG: " + sender.getName() + " used command: /gutest", true, Level.INFO);
		if (sender.hasPermission("GuestUnlock.admin")) {
			sender.sendMessage(ChatColor.RED
					+ "===============================");
			sender.sendMessage("Test!");
			sender.sendMessage("Password=");
			sender.sendMessage(plugin.config.getString("Admin.Password"));
			sender.sendMessage("The test was completed sucessfully!");
			sender.sendMessage("Good luck, /Myller!");
			sender.sendMessage(ChatColor.RED
					+ "===============================");
			return true;
		}
		return true;
	}
}

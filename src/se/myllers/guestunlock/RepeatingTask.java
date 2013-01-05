package se.myllers.guestunlock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RepeatingTask {

	public static int	threadId;
	private final Main	plugin;

	public RepeatingTask(final Main instance) {
		plugin = instance;
		startTask();
	}

	/**
	 * Start a SyncRepeatingTask that sends the repeating message to guests
	 */
	public void startTask() {
		threadId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				next();
			}
		}, 0, Main.config.getInt("Guest.MessageInterval") * 20);
	}

	/**
	 * Sends the message to guests
	 */
	public void next() {
		for (final Player x : Bukkit.getOnlinePlayers()) {
			if (Permission.isGuest(x) && !Permission.isModerator(x)) {
				x.sendMessage(ChatColor.GREEN + Main.config.getString("Guest.Message"));
			}
		}
	}
}

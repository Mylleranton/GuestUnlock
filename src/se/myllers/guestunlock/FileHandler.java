package se.myllers.guestunlock;

import java.io.File;

public class FileHandler {

	private final Main	plugin;

	public FileHandler(final Main main) {
		plugin = main;
		directory();
		config();
	}

	/**
	 * Called on plugin enable to check if the config.yml exists or need to be
	 * created.
	 * <p />
	 * Handles the creation if nessecary
	 */
	private final void config() {
		final File configFile = new File("plugins" + File.separator + "GuestUnlock" + File.separator + "config.yml");
		if (!configFile.exists()) {
			plugin.saveDefaultConfig();
			Main.INFO("Created default configuration-file");
		}
	}

	/**
	 * Called on plugin enable to check if the data directory exists or need to
	 * be created.
	 * <p />
	 * Handles the creation if nessecary
	 */
	private final void directory() {
		if (!plugin.getDataFolder().isDirectory()) {
			if (!plugin.getDataFolder().mkdirs()) {
				Main.SEVERE("Failed to create directory");
			}
			else {
				Main.INFO("Created directory sucessfully!");
			}
		}
	}

}

package se.myllers.guestunlock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UpdateCheck {
	
	public static String newestVersion;
	public static String version;
	public UpdateCheck(String version){
		UpdateCheck.version = version;
		check();
	}
	
	/**
	 * Checks if there is a new version available
	 */
	private static final void check() {
		try { 
			final String address = "https://raw.github.com/Mylleranton/GuestUnlock/master/src/version.txt";
			final URL url = new URL(address.replace(" ", "%20"));
			final URLConnection conn = url.openConnection();
			conn.setConnectTimeout(8000);
			conn.setReadTimeout(15000);

			final BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			newestVersion = bufferedReader.readLine();
			if (newestVersion != null) {
				Listener.newestVersion = newestVersion;
				if (!version.equals(newestVersion)) {
					Main.INFO("Found a different version available: "
							+ newestVersion);
					Main.INFO(
							"Check http://dev.bukkit.org/server-mods/GuestUnlock/");
				} else {
					Main.DEBUG("Did not found a new version");
				}
				bufferedReader.close();
				conn.getInputStream().close();
				return;
			} else {
				bufferedReader.close();
				conn.getInputStream().close();
				Main.DEBUG("'newestVersion == null'");
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}

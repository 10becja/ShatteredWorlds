package me.becja10.ShatteredWorlds.Utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerManager {

	private static Logger logger;
	private static FileConfiguration config = null;
	private static File Players = null;
	private static String path;
	
	public static FileConfiguration getPlayers() {
		/*
		 * radius:
		 * mana:
		 * homes:
		 *   name:
		 *     world: 
		 *     x:
		 *     y:
		 *     z:
		 *     yaw:
		 *     pitch:
		 *     
		 */
		if (config == null)
			reloadPlayers();
		return config;
	}

	public static void reloadPlayers() {
		if (Players == null)
			Players = new File(path);
		config = YamlConfiguration.loadConfiguration(Players);
	}
	
	public static void savePlayers() {
		if ((config == null) || (Players == null))
			return;
		try {
			getPlayers().save(Players);
		} catch (IOException ex) {
			logger.warning("Unable to write to the file \"" + path + "\"");
		}
	}
	
	public static void setUpManager(JavaPlugin plugin, Logger log){
		logger = log;
		path = plugin.getDataFolder().getAbsolutePath()	+ File.separator + "Players.yml".toLowerCase();
		reloadPlayers();
		
	}
}


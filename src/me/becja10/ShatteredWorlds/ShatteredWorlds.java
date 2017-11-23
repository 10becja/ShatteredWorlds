package me.becja10.ShatteredWorlds;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import me.becja10.ShatteredWorlds.Utils.PlayerManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ShatteredWorlds extends JavaPlugin implements Listener{

	public static ShatteredWorlds instance;
	public final static Logger logger = Logger.getLogger("Minecraft");
	
	private String configPath;
	private FileConfiguration config;
	private FileConfiguration outConfig;
	
	//Config Settings

	
		
	private void loadConfig(){
		configPath = this.getDataFolder().getAbsolutePath() + File.separator + "config.yml";
		config = YamlConfiguration.loadConfiguration(new File(configPath));
		outConfig = new YamlConfiguration();
		
		saveConfig(outConfig, configPath);		
	}
	
	private void saveConfig(FileConfiguration config, String path)
	{
        try{config.save(path);}
        catch(IOException exception){logger.info("Unable to write to the configuration file at \"" + path + "\"");}
	}
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		PluginManager manager = getServer().getPluginManager();
		
		PlayerManager.setUpManager(this, logger);

		logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled!");
		instance = this;		
		
		//manager.registerEvents(new SignEventHandler(), this);
		
		loadConfig();		
	}
		
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info(pdfFile.getName() + " Has Been Disabled!");
		saveConfig(outConfig, configPath);

	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		switch(cmd.getName().toLowerCase()){
		case "swreload":
			
		}
		return true;
	}
}

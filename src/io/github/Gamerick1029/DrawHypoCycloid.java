package io.github.Gamerick1029;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DrawHypoCycloid extends JavaPlugin {

	public static HashMap<String, HashMap<String, HypoCycloid>> cycloids;
	public static HashMap<String, Location> playerLocations;
	public static Plugin plugin;
		
	@Override
	public void onEnable() {
		plugin = this;
		this.getCommand("drawhc").setExecutor(new CommandDrawHC());
		this.getCommand("makehc").setExecutor(new CommandMakeHC());
		
		
	}
	
	@Override
	public void onDisable(){
		
	}
	
}

package io.github.Gamerick1029;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DrawHypoCycloid extends JavaPlugin {

	public static HashMap<String, ArrayList<HypoCycloid[]>> cycloids = new HashMap<String, ArrayList<HypoCycloid[]>>();
	public static HashMap<String, Location> playerLocations = new HashMap<String, Location>();
	public static Plugin plugin;
		
	@Override
	public void onEnable() {
		plugin = this;
		this.getCommand("drawhc").setExecutor(new CommandHC());
		
		
	}
	
	@Override
	public void onDisable(){
		
	}
	
}

package io.github.Gamerick1029;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class CommandMakeHC implements CommandExecutor {

	HashMap<String, HashMap<String, HypoCycloid>> plCycloids = DrawHypoCycloid.cycloids;
	HashMap<String, Location> plLocations = DrawHypoCycloid.playerLocations;
	Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		player = (Player) sender;
		HashMap<String, HypoCycloid> cycloids = new HashMap<String, HypoCycloid>();
		String currentName = player.getName();
		
		if (!plCycloids.containsKey(currentName)){
			Location location = new Location(player.getWorld(), (plCycloids.size()*200) + 50, 56, -200);
			plCycloids.put(currentName, cycloids);
			plLocations.put(currentName, location);
		}
		
		parseInput(args);
		return false;
	}
	
	public void parseInput(String[] args){
		HypoCycloid hc = new HypoCycloid(0,0,0,0);
		
		hc.setRatioOfCircles(Double.parseDouble(args[1]));
		hc.setStartCycle(Integer.parseInt(args[2]));
		hc.setEndCycle(Integer.parseInt(args[3]));
		hc.setScreenSize(Integer.parseInt(args[4]));
		
		plCycloids.get(player.getName()).put(args[0], hc);
	}

}

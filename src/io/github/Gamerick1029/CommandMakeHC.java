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
			Location location = new Location(player.getWorld(), (plCycloids.size()*200) + 100, 56, -100, 180, 0);
			plCycloids.put(currentName, cycloids);
			plLocations.put(currentName, location);
		}
		return parseInput(args);
		
	}
	
	public boolean parseInput(String[] args){
		HypoCycloid hc = new HypoCycloid(0,0,0, false);
		
		if (plCycloids.get(player.getName()).containsKey(args[0])) {
			hc = plCycloids.get(player.getName()).get(args[0]);
		}
		
		try {
			hc.setRatioOfCircles(Double.parseDouble(args[1]));
			hc.setOffset(Integer.parseInt(args[2]));
			hc.setScreenSize(Integer.parseInt(args[3]));
			hc.setAnimate(Boolean.getBoolean(args[4]));
			plCycloids.get(player.getName()).put(args[0], hc);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}

}

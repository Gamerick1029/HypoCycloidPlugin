package io.github.Gamerick1029;

import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.*;

public class CommandDrawHC implements CommandExecutor {
	
	HashMap<String, HashMap<String, HypoCycloid>> plCycloids = DrawHypoCycloid.cycloids;
	HashMap<String, Location> plLocations = DrawHypoCycloid.playerLocations;
	Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		player = (Player)sender;
		
		player.teleport(plLocations.get(player.getName()));
		parseInput(args);
		
		return true;
	}
	
	public void parseInput(String[] args){
		if (plCycloids.get(player.getName()).get(args[0]) != null){
			drawCycloid(plCycloids.get(player.getName()).get(args[0]));
		} else {
			player.sendMessage("No such HypoCycloid found! Check spelling perhaps?");
		}
			

		
	}
	
	public void drawCycloid(HypoCycloid cycloid){
		int[][] currentData = cycloid.dataPoints;
		int xBase;
		int yBase = 56;
		
		xBase = (int)(plLocations.get(player.getName()).getX() - cycloid.getScreenSize()/2);
		
		for (int x = xBase; x < xBase + currentData.length; x++){
			for (int y = yBase; y < yBase + currentData.length; y++){
				
			}
		}
	}
	

}

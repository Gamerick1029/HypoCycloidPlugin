package io.github.Gamerick1029;

import org.bukkit.Location;
import org.bukkit.Material;
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
		
		parseInput(args);
		
		return true;
	}
	
	public void parseInput(String[] args){
		if (plCycloids.get(player.getName()).containsKey(args[0])){
			plLocations.get(player.getName()).setZ(plCycloids.get(player.getName()).get(args[0]).getScreenSize() / 2);
			player.teleport(plLocations.get(player.getName()));
			drawCycloid(plCycloids.get(player.getName()).get(args[0]));
		} else {
			player.sendMessage("No such HypoCycloid found! Check spelling perhaps?");
		}
			

		
	}
	
	public void drawCycloid(HypoCycloid cycloid){
		ArrayList<Integer[]> data = cycloid.dataPoints;
		int xBase;
		int yBase = 56;
		
		xBase = (int)(plLocations.get(player.getName()).getX() - cycloid.getScreenSize()/2);
		
		for(Integer[] i: data){
			Drawing.drawBlock(player.getWorld(), i[0]+xBase, i[1]+yBase, 0, Material.LAPIS_BLOCK);
		}
		
	}
	


}

package io.github.Gamerick1029;

import org.bukkit.command.*;
import java.util.*;

public class CommandHC implements CommandExecutor {

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String currentName = sender.getName();
		ArrayList<HypoCycloid[]> cycloidList = new ArrayList<HypoCycloid[]>();
		HashMap<String, ArrayList<HypoCycloid[]>> cycloids = DrawHypoCycloid.cycloids;
		
		if (!cycloids.containsKey(currentName)){
			cycloids.put(currentName, cycloidList);
		}
		
		return true;
	}
	
	public boolean parseInput(String[] args, CommandSender sender){
		boolean validUse = true;
		List<String> errors = new ArrayList<String>();
		
		if (args.length == 2 || args.length == 4){
			sender.sendMessage("Incorrect number of arguments");
			return false;
		} else if (args.length == 2) {

		}
				
		return validUse;
	}
	
	public void drawCycloid(HypoCycloid cycloid, CommandSender sender){
		int[][] currentData = cycloid.dataPoints;
		
	}
	

}

package io.github.Gamerick1029;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearHC implements CommandExecutor {

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player)sender;
		
		int xBase;
		int yBase = 56;
		
		xBase = (int)(DrawHypoCycloid.playerLocations.get(player.getName()).getX() - 100);
		
		for (int x = 0; x < 200; x++){
			for (int y = 0; y < 200; y++){
				Drawing.drawBlock(player.getWorld(), x + xBase, y + yBase, 0, Material.AIR);	
			}				
		}
				
		
		return true;
	}

}

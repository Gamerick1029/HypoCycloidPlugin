package io.github.Gamerick1029;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class Testing {
	
	public static void main(String[] args){
		HypoCycloid hc = new HypoCycloid(2.5, 0, 0, 50);
		
	}
	
	public static void print(String text){
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	    console.sendMessage(ChatColor.AQUA+text);
	}
	

}

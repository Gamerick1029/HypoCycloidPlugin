package io.github.Gamerick1029;

import org.bukkit.Material;
import org.bukkit.World;

public class Drawing {

	public static void drawBlock(World world, int x, int y, int z, Material material){
		world.getBlockAt(x, y, z).setType(material);
	}
	
}

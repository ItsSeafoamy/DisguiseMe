package me.laxynd.disguiseme;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Developers should use the {@link DisguiseAPI} class
 * @author Laxynd
 *
 */
public class DisguiseMe extends JavaPlugin {
	
	public static JavaPlugin plugin;
	public static String nms;
	
	@Override
	public void onEnable(){
		plugin = this;
				
		nms = "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + ".";
		
		DisguiseAPI.init();
	}
}
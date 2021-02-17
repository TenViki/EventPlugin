package dev.tenviki.eventplugin.utils;

import dev.tenviki.eventplugin.Main;

public class Config {
	public static Main plugin;
	
	public Config(Main plugin) {
		Config.plugin = plugin;
	}
	
	public static String getString(String s) {
		return plugin.getConfig().getString(s);
	}
	
	public static int getInt(String s) {
		return plugin.getConfig().getInt(s);
	}
	
	public static boolean getBool(String s) {
		return plugin.getConfig().getBoolean(s);
	}
}

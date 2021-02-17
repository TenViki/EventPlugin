package dev.tenviki.eventplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.tenviki.eventplugin.Main;
import net.md_5.bungee.api.ChatColor;

public class Msg {
	public static Main plugin;
	
	public Msg(Main plugin) {
		Msg.plugin = plugin;
	}
	
	public static void broadcast(String config) {
		String msg = ChatColor.translateAlternateColorCodes('&',  Config.getString(config));
		Bukkit.broadcastMessage(msg);
	}
	
	public static void broadcastRaw(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&',  msg);
		Bukkit.broadcastMessage(msg);
	}
	
	
	public static void sendToPlayer(Player p, String config) {
		String msg = ChatColor.translateAlternateColorCodes('&',  Config.getString(config));
		p.sendMessage(msg);
	}
	
	public static void sendToPlayer(CommandSender p, String config) {
		String msg = ChatColor.translateAlternateColorCodes('&',  Config.getString(config));
		p.sendMessage(msg);
	}
	
	public static void sendRawToPlayer(Player p, String msg) {
		msg =  ChatColor.translateAlternateColorCodes('&', msg);
		p.sendMessage(msg);
	}
	
	public static void sendRawToPlayer(CommandSender p, String msg) {
		msg =  ChatColor.translateAlternateColorCodes('&', msg);
		p.sendMessage(msg);
	}
}

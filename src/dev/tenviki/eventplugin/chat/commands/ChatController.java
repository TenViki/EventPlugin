package dev.tenviki.eventplugin.chat.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.tenviki.eventplugin.Main;
import dev.tenviki.eventplugin.utils.Config;
import dev.tenviki.eventplugin.utils.Msg;

public class ChatController {
	
	private static Main plugin;
	
	public ChatController(Main plugin) {
		ChatController.plugin = plugin;
		
	}
	
	public static void muteChat(CommandSender s) {
		plugin.chatMuted = !plugin.chatMuted;
		
		String name = "";
		
		if(s instanceof Player) {
			Player p = (Player) s;
			name = p.getDisplayName();
		}else {
			name = "Server";
		}
		
		if(plugin.chatMuted) {
			Msg.broadcastRaw(Config.getString("chat-mute").replace("{player}", name));
		}else {
			Msg.broadcastRaw(Config.getString("chat-unmute").replace("{player}", name));
		}
	}
}

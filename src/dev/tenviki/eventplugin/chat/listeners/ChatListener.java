package dev.tenviki.eventplugin.chat.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import dev.tenviki.eventplugin.Main;
import dev.tenviki.eventplugin.utils.Msg;

public class ChatListener implements Listener{
	private Main plugin;
	
	public ChatListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(plugin.chatMuted && !p.hasPermission("ep.chat.mute.bypass")) {
			Msg.sendToPlayer(p, "chat-trytosend");
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPermission("ep.chat.blockedcmds.bypass")) {
			String msg = e.getMessage();
			for(String cmd : plugin.getConfig().getStringList("chat-blocked-commands"))
			{
			   if(msg.contains(cmd)) {
				   Msg.sendToPlayer(p, "no-permission");
				   e.setCancelled(true);
			   }
			}
		}
	}
}

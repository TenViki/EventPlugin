package dev.tenviki.eventplugin.chat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.tenviki.eventplugin.utils.Msg;

import dev.tenviki.eventplugin.Main;

public class Chat implements CommandExecutor{
	private Main plugin;
	
	public Chat(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("chat").setExecutor(this);
		
		new ChatController(this.plugin);
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(args.length >= 1) {
			
			if(args[0].equalsIgnoreCase("mute")) {
				
				if(hasPermission(s, "ep.chat.mute")) {
					ChatController.muteChat(s);					
				}
			}
			
			else {
				sendHelp(s);
			}
		}
		
		else{
			sendHelp(s);
		}
		
		return true;
	}
	
	public void sendHelp(CommandSender s) {
		for(String msg : plugin.getConfig().getStringList("chat-help"))
		{
		   Msg.sendRawToPlayer(s, msg);
		}
	}
	
	public boolean hasPermission(CommandSender s, String msg) {
		if(s.hasPermission(msg)) return true;
		Msg.sendToPlayer(s, "no-permission");

		return false;
	}
}

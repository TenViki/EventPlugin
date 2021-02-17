package dev.tenviki.eventplugin.event.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.tenviki.eventplugin.utils.Msg;

import dev.tenviki.eventplugin.Main;

public class Event implements CommandExecutor{
	private Main plugin;
	
	public Event(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("event").setExecutor(this);
		
		new Countdown(plugin);
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(args.length >= 1) {
			
			if(args[0].equalsIgnoreCase("countdown")) {
				
				if(hasPermission(s, "ep.event.countdown")){
					if(args.length != 2) {
						sendHelp(s);
						return true;
					}
					
					try {						
						int count = Integer.parseInt(args[1]);
						
						Countdown.countdown(count);
					}
					
					catch(NumberFormatException e) {
						Msg.sendToPlayer(s, "not-a-number");
						return true;
					}
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
		for(String msg : plugin.getConfig().getStringList("event-help"))
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

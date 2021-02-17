package dev.tenviki.eventplugin.ep;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.tenviki.eventplugin.utils.Msg;

import dev.tenviki.eventplugin.Main;

public class Ep implements CommandExecutor{
	private Main plugin;
	
	public Ep(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("ep").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
			sendHelp(s);
			return true;
		}
		
		if(args[0].equalsIgnoreCase("reload")) {
			if(!hasPermission(s, "ep.admin.reload")) return true;
			
			plugin.reloadConfig();
			Msg.sendToPlayer(s, "config-reload");
		}
		
		return true;
		
		
	}
	
	public void sendHelp(CommandSender s) {
		for(String msg : plugin.getConfig().getStringList("help"))
		{
		   Msg.sendRawToPlayer(s, msg.replace("{v}", plugin.pluginVersion));
		}
	}
	
	public boolean hasPermission(CommandSender s, String msg) {
		if(s.hasPermission(msg)) return true;
		Msg.sendToPlayer(s, "no-permission");

		return false;
	}
}
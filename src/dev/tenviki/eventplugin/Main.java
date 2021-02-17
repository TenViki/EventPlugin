package dev.tenviki.eventplugin;

import org.bukkit.plugin.java.JavaPlugin;

import dev.tenviki.eventplugin.chat.commands.Chat;
import dev.tenviki.eventplugin.chat.listeners.ChatListener;
import dev.tenviki.eventplugin.ep.Ep;
import dev.tenviki.eventplugin.event.commands.Event;
import dev.tenviki.eventplugin.utils.Config;
import dev.tenviki.eventplugin.utils.Msg;

public class Main extends JavaPlugin{
	
	public String pluginVersion = this.getDescription().getVersion(); //Gets plugin.yml
	
	// Assigning global variables
	public boolean chatMuted = false;
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		System.out.println("[EventPlugin] Event plugin se zapíná...");
		
		// Utility setup
		new Config(this);
		new Msg(this);
		
		// Chat settings
		new Chat(this);
		new ChatListener(this);
		
		//Events setup
		new Event(this);
		
		//EP setup
		new Ep(this);
	}
}

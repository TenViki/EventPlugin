package dev.tenviki.eventplugin.event.commands;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

import dev.tenviki.eventplugin.Main;
import dev.tenviki.eventplugin.utils.Config;
import dev.tenviki.eventplugin.utils.Msg;

public class Countdown{
	
	private static Main plugin;
	
	public Countdown(Main plugin) {
		Countdown.plugin = plugin;
		
	}
	
	public static void countdown(int num) {
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		
		// Start a reepeating task and store his id
		int id = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			int secs = num;
			
            @Override
            public void run() {
            	Msg.broadcastRaw(Config.getString("event-countdown").replace("{s}", String.valueOf(secs)));
            	secs--;
            }
        }, 0, 20);
		
		scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
			//int count = 4;
			
            @Override
            public void run() {
            	Bukkit.getScheduler().cancelTask(id);
                Msg.broadcast("event-countdown-end");
            }
        }, num * 20);
	}
}

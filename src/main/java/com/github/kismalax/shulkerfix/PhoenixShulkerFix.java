package com.github.kismalax.shulkerfix;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class PhoenixShulkerFix extends JavaPlugin {
	private static PhoenixShulkerFix instance = null;
	
	@Override
	public void onEnable() {
		instance = this;
		prepareConfig();
		
		getServer().getPluginManager().registerEvents(new PhoenixShulkerFixEventListener(), this);
		getLogger().info("Listener registered");
	}
	
	@Override
	public void onDisable() {
		HandlerList.unregisterAll(instance);
		getLogger().info("Listener unregistered");
		instance = null;
	}
	
	private void prepareConfig() {
		FileConfiguration config = getConfig();
		
		config.addDefault("debug", false);
		
		config.options().copyDefaults(true);
		saveConfig();
	}
	
	public static PhoenixShulkerFix getInstance() {
		if (instance == null) throw new IllegalStateException("PhoenixShulkerFix is not loaded");
		return instance;
	}
}

package com.github.kismalax.shulkerfix;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class PhoenixShulkerFix extends JavaPlugin {
	private static PhoenixShulkerFix instance = null;
	
	@Override
	public void onEnable() {
		instance = this;
		
		getServer().getPluginManager().registerEvents(new PhoenixShulkerFixEventListener(), this);
		getLogger().info("Registered listener");
	}
	
	@Override
	public void onDisable() {
		HandlerList.unregisterAll(instance);
		instance = null;
	}
	
	public static PhoenixShulkerFix getInstance() {
		if (instance == null) throw new IllegalStateException("PhoenixShulkerFix is not loaded");
		return instance;
	}
}

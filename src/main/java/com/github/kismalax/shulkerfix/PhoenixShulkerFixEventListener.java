package com.github.kismalax.shulkerfix;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class PhoenixShulkerFixEventListener implements Listener {

	@EventHandler
	public void onCreatureSpawnEvent​(CreatureSpawnEvent e) {
		if (e.getEntityType() == EntityType.SHULKER && e.getSpawnReason() == SpawnReason.BREEDING) {
			e.setCancelled(true);
			if (PhoenixShulkerFix.getInstance().getConfig().getBoolean("debug")) {
				PhoenixShulkerFix.getInstance().getLogger().warning("Shulker attempt to spawn at"
						+ " x:" + e.getLocation().getBlockX()
						+ " y:" + e.getLocation().getBlockY()
						+ " z:" + e.getLocation().getBlockZ()
						+ " @" + e.getLocation().getWorld().getName() + ", canceled");
			}
		}
	}

}

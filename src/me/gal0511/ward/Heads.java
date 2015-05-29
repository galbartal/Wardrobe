package me.gal0511.ward;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

	public class Heads implements Listener{
		private Inventory inv;
  
		public Heads(Plugin pl){
			Bukkit.getServer().getPluginManager().registerEvents(this, pl);
		}
  
		public void show(Player p){
			this.inv = Bukkit.getServer().createInventory(null, 36, "§bHeads");
    
    
			p.openInventory(this.inv);
		}
  
		@EventHandler
		public void onInventoryClick(InventoryClickEvent e){
			if (!e.getInventory().getName().equalsIgnoreCase(this.inv.getName())) {
				return;
			}
    
			@SuppressWarnings("unused")
			Player p = (Player) e.getWhoClicked();
    
			if(e.getCurrentItem() == null){
				e.setCancelled(true);
			}
		}
	}
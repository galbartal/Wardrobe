package me.xgal.ward;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Ward implements Listener{
  
		public static void open(Player p){
			Inventory inv = Bukkit.getServer().createInventory(null, 36, "§bWardrobe");
			
			ItemStack no = new ItemStack(Material.REDSTONE_LAMP_OFF, 1);
			ItemMeta noname = no.getItemMeta();
			noname.setDisplayName("§cClear Armor");
			ArrayList<String> lore5 = new ArrayList<String>();
			lore5.add("§bRight click to get rid of your armor.");
			noname.setLore(lore5);
			no.setItemMeta(noname);
    
		    inv.setItem(35, no);
    
    
			inv.setItem(2, new ItemStack(Material.LEATHER_HELMET));
			inv.setItem(11, new ItemStack(Material.LEATHER_CHESTPLATE));
			inv.setItem(20, new ItemStack(Material.LEATHER_LEGGINGS));
			inv.setItem(29, new ItemStack(Material.LEATHER_BOOTS));
    

			inv.setItem(3, new ItemStack(Material.GOLD_HELMET));
			inv.setItem(12, new ItemStack(Material.GOLD_CHESTPLATE));
			inv.setItem(21, new ItemStack(Material.GOLD_LEGGINGS));
			inv.setItem(30, new ItemStack(Material.GOLD_BOOTS));
    

			inv.setItem(4, new ItemStack(Material.CHAINMAIL_HELMET));
			inv.setItem(13, new ItemStack(Material.CHAINMAIL_CHESTPLATE));
			inv.setItem(22, new ItemStack(Material.CHAINMAIL_LEGGINGS));
			inv.setItem(31, new ItemStack(Material.CHAINMAIL_BOOTS));
    

			inv.setItem(5, new ItemStack(Material.IRON_HELMET));
			inv.setItem(14, new ItemStack(Material.IRON_CHESTPLATE));
			inv.setItem(23, new ItemStack(Material.IRON_LEGGINGS));
			inv.setItem(32, new ItemStack(Material.IRON_BOOTS));
    

			inv.setItem(6, new ItemStack(Material.DIAMOND_HELMET));
			inv.setItem(15, new ItemStack(Material.DIAMOND_CHESTPLATE));
			inv.setItem(24, new ItemStack(Material.DIAMOND_LEGGINGS));
			inv.setItem(33, new ItemStack(Material.DIAMOND_BOOTS));
    
			p.openInventory(inv);
		}
  
		@EventHandler
		public void onInventoryClick(InventoryClickEvent e){
			if (!e.getInventory().getName().equalsIgnoreCase("§bWardrobe")) {
				return;
			}
    
			Player p = (Player) e.getWhoClicked();
    
			if(e.getCurrentItem() == null){
				e.setCancelled(true);
			}
			
			
			if(e.getSlot() == 2){
				e.setCancelled(true);
				if(p.hasPermission("ward.leather")){
					p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 3){
				e.setCancelled(true);
				if(p.hasPermission("ward.gold")){
					p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 4){
				e.setCancelled(true);
				if(p.hasPermission("ward.chain")){
					p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 5){
				e.setCancelled(true);
				if(p.hasPermission("ward.iron")){
					p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 6){
				e.setCancelled(true);
				if(p.hasPermission("ward.diamond")){
					p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 11){
				e.setCancelled(true);
				if(p.hasPermission("ward.leather")){
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 12){
				e.setCancelled(true);
				if(p.hasPermission("ward.gold")){
					p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 13){
				e.setCancelled(true);
				if(p.hasPermission("ward.chain")){
					p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 14){
				e.setCancelled(true);
				if(p.hasPermission("ward.iron")){
					p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 15){
				e.setCancelled(true);
				if(p.hasPermission("ward.diamond")){
					p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 20){
				e.setCancelled(true);
				if(p.hasPermission("ward.leather")){
					p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 21){
				e.setCancelled(true);
				if(p.hasPermission("ward.gold")){
					p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 22){
				e.setCancelled(true);
				if(p.hasPermission("ward.chain")){
					p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 23){
				e.setCancelled(true);
				if(p.hasPermission("ward.iron")){
					p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 24){
				e.setCancelled(true);
				if(p.hasPermission("ward.diamond")){
					p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 29){
				e.setCancelled(true);
				if(p.hasPermission("ward.leather")){
					p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 30){
				e.setCancelled(true);
				if(p.hasPermission("ward.gold")){
					p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 31){
				e.setCancelled(true);
				if(p.hasPermission("ward.chain")){
					p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 32){
				e.setCancelled(true);
				if(p.hasPermission("ward.iron")){
					p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}
			
			if(e.getSlot() == 33){
				e.setCancelled(true);
				if(p.hasPermission("ward.diamond")){
					p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
					p.updateInventory();
				} else {
					p.sendMessage("§6Wardrobe> §bYou dont have permission for this!");
				}
			}			
    
			if(e.getSlot() == 35){
				e.setCancelled(true);
				p.sendMessage("§6Wardrobe> §cYou are now nude!");
				p.closeInventory();
				p.getInventory().setArmorContents(null);
				p.updateInventory();
			}
		}
	}
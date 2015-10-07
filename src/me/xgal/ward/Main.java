package me.xgal.ward;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	String noperm = getConfig().getString("no-permission-message");

	public String colorize(String msg) {
		String coloredMsg = "";
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '&') {
				coloredMsg = coloredMsg + '§';
			} else {
				coloredMsg = coloredMsg + msg.charAt(i);
			}
		}
		return coloredMsg;
	}

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new Ward(), this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if ((e.getLine(0).equalsIgnoreCase("[Wardrobe]"))
				&& (p.hasPermission("ward.sign"))) {
			e.setLine(0, "§8**********");
			e.setLine(1, "§6Wardrobe");
			e.setLine(2, "§bRight-Click");
			e.setLine(3, "§8**********");
		}
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.WALL_SIGN
					|| e.getClickedBlock().getType() == Material.SIGN_POST) {
				Sign s = (Sign) e.getClickedBlock().getState();
				if (s.getLine(0).equalsIgnoreCase("§6Wardrobe")) {
					if (p.hasPermission("ward.open")) {
						Ward.open(p);
					}
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§4The console cannot use Wardrobe!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ward")) {
			if (p.hasPermission("ward.open")) {
				Ward.open(p);
			} else {
				p.sendMessage(colorize(noperm));
			}
		}
		if (cmd.getName().equalsIgnoreCase("wget")) {
			if (p.hasPermission("ward.get")) {
				ItemStack c = new ItemStack(Material.BONE, 1);
				ItemMeta cname = c.getItemMeta();
				cname.setDisplayName("§eWardrobe");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("§fRight click to open the wardrobe!");
				cname.setLore(lore);
				c.setItemMeta(cname);
				p.getInventory().addItem(new ItemStack[] { c });
				p.updateInventory();
				p.sendMessage("§eYou have gotten the wardrobe item!");
			} else {
				p.sendMessage("§6Wardrobe> §bYou do not have permission to get the wardrobe item!");
			}
		}
		return false;
	}
}
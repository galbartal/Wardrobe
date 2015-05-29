package me.gal0511.ward;

import java.io.File;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
  implements Listener
{
	

	public static File headsFile;
	public static FileConfiguration heads;
	
	
  private Ward wr;
  String noperm = getConfig().getString("no-permission-message");
  
  public String colorize(String msg){
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
  
  public void onEnable(){
    this.wr = new Ward(this);
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Bukkit.getServer().getLogger().info("Armor Wardrobe" + getDescription().getVersion() + " Has Been Enabled!");
    getConfig().options().copyDefaults(true);
    saveConfig();
    

	headsFile = new File(getDataFolder(), "heads.yml");
	heads = YamlConfiguration.loadConfiguration(headsFile);
	heads.addDefault("Head1", "gal0511");
	heads.addDefault("Head2", "notch");
	heads.addDefault("Head3", "jeb_");
	heads.addDefault("Head4", "");
	heads.addDefault("Head5", "");
	heads.options().copyDefaults(true);
	saveHeads();
    
    
  }
 

	public static void saveHeads(){
		try {
		heads.save(headsFile);
		} catch (Exception e) {
		}
		}
  
	
  @EventHandler
  public void onSignChange(SignChangeEvent e){
    Player p = e.getPlayer();
    if ((e.getLine(0).equalsIgnoreCase("[Wardrobe]")) && 
      (p.hasPermission("ward.sign"))){
      e.setLine(0, "§8**********");
      e.setLine(1, "§6Wardrobe");
      e.setLine(2, "§bRight-Click");
      e.setLine(3, "§8**********");
    }
  }
  
  @EventHandler
  public void PlayerInteract(PlayerInteractEvent e){
    if ((e.getPlayer().getItemInHand().getType() == Material.BONE) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)))) {
      this.wr.show(e.getPlayer());
    }
    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }
    if ((e.getClickedBlock().getState() instanceof Sign)){
      Sign s = (Sign)e.getClickedBlock().getState();
      Player player = e.getPlayer();
      if ((s.getLine(1).equalsIgnoreCase("§6Wardrobe")) && 
        (player.hasPermission("ward.open"))) {
        this.wr.show(e.getPlayer());
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    if (!(sender instanceof Player)){
      sender.sendMessage("§4The console cannot use Wardrobe!");
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ward")){
      if (p.hasPermission("ward.open")) {
        this.wr.show(p);
      } else {
        p.sendMessage(colorize(this.noperm));
      }
    }
    if (cmd.getName().equalsIgnoreCase("wget")){
    	if(p.hasPermission("ward.get")){
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
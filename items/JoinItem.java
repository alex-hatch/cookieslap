package me.alex.firstplugin.items;

import me.alex.firstplugin.statechange.InitializeGameState;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
public class JoinItem implements Listener {

    public static void giveJoinItem(Player p){
        ItemStack greenWool = new ItemStack(Material.SLIME_BALL);
        String greenWoolName = ChatColor.GREEN + "Join Game" + ChatColor.GRAY + " (Right Click)";
        ItemMeta greenWoolItemMeta = greenWool.getItemMeta();
        greenWoolItemMeta.setDisplayName(greenWoolName);
        greenWool.setItemMeta(greenWoolItemMeta);
        p.getInventory().setItem(8, greenWool);
    }

    public static ItemMeta getJoinItemMeta() {
        ItemStack greenWool = new ItemStack(Material.SLIME_BALL);
        String greenWoolName = ChatColor.GREEN + "Join Game" + ChatColor.GRAY + " (Right Click)";
        ItemMeta greenWoolItemMeta = greenWool.getItemMeta();
        greenWoolItemMeta.setDisplayName(greenWoolName);
        greenWool.setItemMeta(greenWoolItemMeta);
        return greenWoolItemMeta;
    }

    @EventHandler
    public void onJoinItemClick(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if (e.getItem().getItemMeta().equals(getJoinItemMeta())) {
                InitializeGameState.initGameState(e.getPlayer());
            }
        }

    }

}

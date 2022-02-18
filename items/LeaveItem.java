package me.alex.firstplugin.items;

import me.alex.firstplugin.statechange.InitializeSpawnState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LeaveItem implements Listener {
    public static void giveLeaveItem(Player p) {
        ItemStack redWool = new ItemStack(Material.REDSTONE);
        String redWoolName = ChatColor.RED + "Leave Game" + ChatColor.GRAY + " (Right Click)";
        ItemMeta redWoolItemMeta = redWool.getItemMeta();
        redWoolItemMeta.setDisplayName(redWoolName);
        redWool.setItemMeta(redWoolItemMeta);
        p.getInventory().setItem(8, redWool);
    }

    public static ItemMeta getLeaveItemMeta() {
        ItemStack redWool = new ItemStack(Material.REDSTONE);
        String redWoolName = ChatColor.RED + "Leave Game" + ChatColor.GRAY + " (Right Click)";
        ItemMeta redWoolItemMeta = redWool.getItemMeta();
        redWoolItemMeta.setDisplayName(redWoolName);
        redWool.setItemMeta(redWoolItemMeta);
        return redWoolItemMeta;
    }

    @EventHandler
    public void onLeaveItemClick(PlayerInteractEvent e) {
        if (e.getItem() == null) {
            return;
        }

        // Correct item check
        if (!(e.getItem().getItemMeta().equals(getLeaveItemMeta()))) {
            return;
        }

        if (!(e.getPlayer().isOnGround())) {
            e.getPlayer().sendMessage(ChatColor.RED + "You must be standing still on the ground to use this!");
            return;
        }

        boolean delay = true;
        while(delay) {
            InitializeSpawnState.initSpawnState(e.getPlayer());
            delay = false;
        }
    }
}

package me.alex.firstplugin.items;

import me.alex.firstplugin.shop.ConstructShop;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItem implements Listener {

    public static void giveShopItem(Player p) {
        ItemStack emerald = new ItemStack(Material.EMERALD, 1);
        String emeraldName = ChatColor.YELLOW + "Shop" + ChatColor.GRAY + " (Right Click)";
        ItemMeta emeraldItemMeta = emerald.getItemMeta();
        emeraldItemMeta.setDisplayName(emeraldName);
        emerald.setItemMeta(emeraldItemMeta);
        p.getInventory().setItem(4, emerald);
    }

    @EventHandler
    public void onJoinItemClick(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Shop" + ChatColor.GRAY + " (Right Click)")) {
                ConstructShop constructShop = new ConstructShop();
                constructShop.createInventory(e.getPlayer());
            }
        }
    }
}

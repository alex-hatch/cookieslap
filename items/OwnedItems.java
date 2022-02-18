package me.alex.firstplugin.items;

import me.alex.firstplugin.shop.ConstructShop;
import me.alex.firstplugin.statechange.InitializeGameState;
import me.alex.firstplugin.statechange.PlayerJoin;
import me.alex.firstplugin.stats.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class OwnedItems implements Listener {

    public static void giveOwnedItem(Player p) {
        ItemStack chest = new ItemStack(Material.CHEST, 1);
        String chestName = ChatColor.YELLOW + "Collection" + ChatColor.GRAY + " (Right Click)";
        ItemMeta chestItemMeta = chest.getItemMeta();
        chestItemMeta.setDisplayName(chestName);
        chest.setItemMeta(chestItemMeta);
        p.getInventory().setItem(0, chest);
    }

    /**
     * Build the owned item inventory when right click chest in spawn
     * @param e
     */
    @EventHandler
    public void onOwnedItemClick(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Collection" + ChatColor.GRAY + " (Right Click)")) {

                if(Weapons.weapons.size() == 0) {
                    Weapons.initializeWeapons();
                }

                ConstructShop constructShop = new ConstructShop();
                Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "Collection");
                ArrayList<String> ownedWeapons = PlayerConfig.getOwnedWeapons(e.getPlayer());
                ownedWeapons.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Weapons.weapons.get(o1).getPrice() - Weapons.weapons.get(o2).getPrice();
                    }
                });
                for(int i = 0; i < ownedWeapons.size(); i++) {
                    inventory.setItem(i, Weapons.weapons.get(ownedWeapons.get(i)).getItem());
                }
                e.getPlayer().openInventory(inventory);
            }
        }
    }
}

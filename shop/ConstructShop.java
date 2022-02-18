package me.alex.firstplugin.shop;

import me.alex.firstplugin.items.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructShop {

    private final ArrayList<ItemStack> shopItems;

    public ConstructShop() {

        if(Weapons.weapons.size() == 0) {
            Weapons.initializeWeapons();
        }

        ArrayList<Weapon> allWeapons = new ArrayList<>(Weapons.weapons.values());
        allWeapons.sort(new Comparator<Weapon>() {
            @Override
            public int compare(Weapon o1, Weapon o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });

        ArrayList<ItemStack> shopItems = new ArrayList<>();

        for(int i = 1; i < allWeapons.size(); i++) {
            shopItems.add(allWeapons.get(i).getShopItem());
        }

        this.shopItems = shopItems;
    }


    public void createInventory(Player p) {
        Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "Item Shop");

        for(int i = 0; i < shopItems.size(); i++) {
            inventory.setItem(i,shopItems.get(i));
        }

        p.openInventory(inventory);
    }

    public ArrayList<ItemStack> getShopItemsInOrder() {
        return shopItems;
    }
}

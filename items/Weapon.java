package me.alex.firstplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * To register a new weapon, create a class for the item and implemenet this interface
 * add item to "weapons" and "shopItemInOrder" inside of the ConstructShop class
 */
public interface Weapon {

    ItemStack getShopItem();

    int getPrice();

    String getDescription();

    String getName();

    void giveWeapon(Player p);

    ItemStack getItem();

}

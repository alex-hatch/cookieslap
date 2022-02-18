package me.alex.firstplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CookieItem implements Weapon{
    private int price = 0;
    private static final String name = ChatColor.GREEN + "SUPER COOKIE";
    private static final String description = ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Knockback 25!";
    private ItemStack cookieItem;

    public CookieItem() {
        ItemStack cookie = new ItemStack(Material.COOKIE, 1);
        cookie.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta cookieMeta = cookie.getItemMeta();
        String cookieName = name;
        ArrayList<String> cookieLore = new ArrayList<>();
        cookieLore.add(description);
        cookieMeta.setLore(cookieLore);
        cookieMeta.setDisplayName(cookieName);
        cookieMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cookie.setItemMeta(cookieMeta);
        cookieItem = cookie;
    }

    @Override
    public void giveWeapon(Player p) {
        p.getInventory().addItem(cookieItem);
    }

    @Override
    public ItemStack getItem() {
        return cookieItem;
    }

    @Override
    public ItemStack getShopItem() {
        ItemStack cookie = new ItemStack(Material.COOKIE, 1);
        cookie.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta cookieMeta = cookie.getItemMeta();
        String cookieName = name;
        ArrayList<String> cookieLore = new ArrayList<>();
        cookieLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Knockback 25!");
        cookieLore.add(" ");
        cookieLore.add(ChatColor.YELLOW + "" + price + " Coins");
        cookieMeta.setLore(cookieLore);
        cookieMeta.setDisplayName(cookieName);
        cookieMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cookie.setItemMeta(cookieMeta);
        return cookie;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}

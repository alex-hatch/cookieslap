package me.alex.firstplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StickItem implements Weapon{
    private static int price = 100;
    private static final String name = ChatColor.GREEN + "SUPER STICK";
    private static final String description = ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Slightly more (or less) effective than a cookie";
    private final ItemStack stickItem;

    public StickItem() {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta stickMeta = stick.getItemMeta();
        String stickName = name;
        ArrayList<String> stickLore = new ArrayList<>();
        stickLore.add(description);
        stickMeta.setLore(stickLore);
        stickMeta.setDisplayName(stickName);
        stickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stick.setItemMeta(stickMeta);

        stickItem = stick;
    }

    @Override
    public void giveWeapon(Player p) {
        p.getInventory().addItem(stickItem);
    }

    @Override
    public ItemStack getItem() {
        return stickItem;
    }

    public ItemStack getShopItem() {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta stickMeta = stick.getItemMeta();
        String stickName = name;
        ArrayList<String> stickLore = new ArrayList<>();
        stickLore.add(description);
        stickLore.add(" ");
        stickLore.add(ChatColor.YELLOW + "" + price + " Coins");
        stickMeta.setLore(stickLore);
        stickMeta.setDisplayName(stickName);
        stickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stick.setItemMeta(stickMeta);
        return stick;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
}

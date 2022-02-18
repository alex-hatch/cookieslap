package me.alex.firstplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GoldenAppleItem implements Weapon{
    private static final int price = 9999;
    private static final String description = ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Its..... GOLDEN!";
    private static final String name = ChatColor.GOLD + "Golden Apple";

    private ItemStack gappleItem;

    public GoldenAppleItem() {
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 1);
        gapple.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta gappleMeta = gapple.getItemMeta();
        String gappleName = name;
        ArrayList<String> gappleLore = new ArrayList<>();
        gappleLore.add(description);
        gappleMeta.setLore(gappleLore);
        gappleMeta.setDisplayName(gappleName);
        gappleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gapple.setItemMeta(gappleMeta);
        gappleItem = gapple;
    }

    public ItemStack getShopItem() {
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 1);
        gapple.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta gappleMeta = gapple.getItemMeta();
        String gappleName = name;
        ArrayList<String> gappleLore = new ArrayList<>();
        gappleLore.add(description);
        gappleLore.add(" ");
        gappleLore.add(ChatColor.YELLOW + "" + price + " Coins");
        gappleMeta.setLore(gappleLore);
        gappleMeta.setDisplayName(gappleName);
        gappleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gapple.setItemMeta(gappleMeta);
        return gapple;
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

    @Override
    public void giveWeapon(Player p) {
        p.getInventory().addItem(gappleItem);
    }

    @Override
    public ItemStack getItem() {
        return gappleItem;
    }
}

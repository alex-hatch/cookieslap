package me.alex.firstplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DiamondItem implements Weapon{
    private static int price = 5000;
    private static final String name = ChatColor.AQUA + "Diamond";
    private static final String description = ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Diamond Hands";
    private final ItemStack diamondItem;

    public DiamondItem() {
        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
        diamond.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta diamondMeta = diamond.getItemMeta();
        String diamondName = name;
        ArrayList<String> diamondLore = new ArrayList<>();
        diamondLore.add(description);
        diamondMeta.setLore(diamondLore);
        diamondMeta.setDisplayName(diamondName);
        diamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        diamond.setItemMeta(diamondMeta);
        diamondItem = diamond;
    }

    @Override
    public ItemStack getShopItem() {
        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
        diamond.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta diamondMeta = diamond.getItemMeta();
        String diamondName = name;
        ArrayList<String> diamondLore = new ArrayList<>();
        diamondLore.add(description);
        diamondLore.add(" ");
        diamondLore.add(ChatColor.YELLOW + "" + price + " Coins");
        diamondMeta.setLore(diamondLore);
        diamondMeta.setDisplayName(diamondName);
        diamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        diamond.setItemMeta(diamondMeta);
        return diamond;
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
        p.getInventory().addItem(diamondItem);
    }

    @Override
    public ItemStack getItem() {
        return diamondItem;
    }
}

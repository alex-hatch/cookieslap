package me.alex.firstplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CakeItem implements Weapon {
    private static final int price = 1000;
    private static final String name = ChatColor.WHITE + "Cake";
    private final ItemStack cakeItem;
    private static final String description = ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "It's a lie!";

    public CakeItem() {
        ItemStack cake = new ItemStack(Material.CAKE, 1);
        cake.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta cakeMeta = cake.getItemMeta();
        String cakeName = name;
        ArrayList<String> cakeLore = new ArrayList<>();
        cakeLore.add(description);
        cakeMeta.setLore(cakeLore);
        cakeMeta.setDisplayName(cakeName);
        cakeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cake.setItemMeta(cakeMeta);
        cakeItem = cake;
    }

    @Override
    public ItemStack getShopItem() {
        ItemStack cake = new ItemStack(Material.CAKE, 1);
        cake.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta cakeMeta = cake.getItemMeta();
        String cakeName = name;
        ArrayList<String> cakeLore = new ArrayList<>();
        cakeLore.add(description);
        cakeLore.add(" ");
        cakeLore.add(ChatColor.YELLOW + "" + price + " Coins");
        cakeMeta.setLore(cakeLore);
        cakeMeta.setDisplayName(cakeName);
        cakeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cake.setItemMeta(cakeMeta);
        return cake;
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
        p.getInventory().addItem(cakeItem);
    }

    @Override
    public ItemStack getItem() {
        return cakeItem;
    }
}

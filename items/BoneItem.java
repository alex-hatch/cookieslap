package me.alex.firstplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BoneItem implements Weapon{
    private static final int price = 250;
    private static final String name = ChatColor.GREEN + "SUPER BONE";
    private final ItemStack boneItem;
    private static final String description = ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Who's bone is this?";

    public BoneItem() {
        ItemStack bone = new ItemStack(Material.BONE, 1);
        bone.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta boneMeta = bone.getItemMeta();
        String boneName = name;
        ArrayList<String> boneLore = new ArrayList<>();
        boneLore.add(description);
        boneMeta.setLore(boneLore);
        boneMeta.setDisplayName(boneName);
        boneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bone.setItemMeta(boneMeta);

        boneItem = bone;
    }

    @Override
    public void giveWeapon(Player p) {
        p.getInventory().addItem(boneItem);
    }

    @Override
    public ItemStack getItem() {
        return boneItem;
    }

    @Override
    public ItemStack getShopItem() {
        ItemStack bone = new ItemStack(Material.BONE, 1);
        bone.addUnsafeEnchantment(Enchantment.KNOCKBACK, 25);
        ItemMeta boneMeta = bone.getItemMeta();
        String boneName = name;
        ArrayList<String> boneLore = new ArrayList<>();
        boneLore.add(description);
        boneLore.add(" ");
        boneLore.add(ChatColor.YELLOW + "" + price + " Coins");
        boneMeta.setLore(boneLore);
        boneMeta.setDisplayName(boneName);
        boneMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bone.setItemMeta(boneMeta);
        return bone;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }


}

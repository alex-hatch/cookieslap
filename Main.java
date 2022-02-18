package me.alex.firstplugin;

import me.alex.firstplugin.disabled.*;
import me.alex.firstplugin.game.Kill;
import me.alex.firstplugin.items.*;
import me.alex.firstplugin.shop.Purchase;
import me.alex.firstplugin.statechange.*;
import me.alex.firstplugin.stats.GiveCoins;
import me.alex.firstplugin.stats.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // Initialize Player Config
        PlayerConfig.setup();
        PlayerConfig.getConfig().options().copyDefaults(true);
        PlayerConfig.save();

        // Register Events
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new Kill(), this);
        getServer().getPluginManager().registerEvents(new Spawn(), this);
        getServer().getPluginManager().registerEvents(new DisableBreaking(), this);
        getServer().getPluginManager().registerEvents(new DisableDrops(), this);
        getServer().getPluginManager().registerEvents(new DisableBuilding(), this);
        getServer().getPluginManager().registerEvents(new DisableSpawnPVP(), this);
        getServer().getPluginManager().registerEvents(new DisableCommands(), this);
        getServer().getPluginManager().registerEvents(new DisableExplosion(), this);
        getServer().getPluginManager().registerEvents(new LeaveItem(), this);
        getServer().getPluginManager().registerEvents(new JoinItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerActualDeath(), this);
        getServer().getPluginManager().registerEvents(new ChatFormat(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new ShopItem(), this);
        getServer().getPluginManager().registerEvents(new Purchase(), this);
        getServer().getPluginManager().registerEvents(new DisableItemClickPickup(), this);
        getServer().getPluginManager().registerEvents(new OwnedItems(), this);
        getServer().getPluginManager().registerEvents(new DisableEating(), this);

        // Register Commands
        Start start = new Start();
        Spawn spawn = new Spawn();
        GiveCoins giveCoins = new GiveCoins();

        getCommand("spawn").setExecutor(spawn);
        getServer().getPluginManager().registerEvents(new Start(), this);
        getCommand("start").setExecutor(start);
        getServer().getPluginManager().registerEvents(new DisableHealthAndFood(), this);
        getCommand("givecoins").setExecutor(giveCoins);
        getServer().getPluginManager().registerEvents(new GiveCoins(), this);


        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Cookie Slap Enabled");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Cookie Slap disabled");
    }
}
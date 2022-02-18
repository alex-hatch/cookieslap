package me.alex.firstplugin.statechange;

import me.alex.firstplugin.items.*;
import me.alex.firstplugin.shop.ConstructShop;
import me.alex.firstplugin.stats.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String uuid = p.getUniqueId().toString();

        // For the first time a player joins the server
        if (!PlayerConfig.getConfig().contains("Players." + uuid)) {
            PlayerConfig.getConfig().set("Players." + uuid + ".Kills", 0);
            PlayerConfig.getConfig().set("Players." + uuid + ".Deaths", 0);
            PlayerConfig.getConfig().set("Players." + uuid + ".Coins", 0);
            PlayerConfig.getConfig().set("Players." + uuid + ".HighestStreak", 0);
            PlayerConfig.getConfig().set("Players." + uuid + ".OwnedWeapons", new ArrayList<String>());
            ArrayList<String> ownedWeapons = (ArrayList<String>) PlayerConfig.getConfig().get("Players." + uuid + ".OwnedWeapons");
            Weapon defaultWeapon = new CookieItem();
            ownedWeapons.add(defaultWeapon.getName());
            PlayerConfig.getConfig().set("Players." + uuid + ".OwnedWeapons", ownedWeapons);
            PlayerConfig.getConfig().set("Players." + uuid + ".ChosenWeapon", ChatColor.GREEN + "SUPER COOKIE");
            PlayerConfig.save();
        }
        event.setJoinMessage(ChatColor.GOLD + event.getPlayer().getDisplayName() + ChatColor.GRAY + " has joined the game");
        InitializeSpawnState.initSpawnState(p);
    }
}

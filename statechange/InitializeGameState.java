package me.alex.firstplugin.statechange;

import me.alex.firstplugin.game.CurrentGameStats;
import me.alex.firstplugin.game.Game;
import me.alex.firstplugin.items.*;
import me.alex.firstplugin.scoreboard.game.GameScoreboard;
import me.alex.firstplugin.shop.ConstructShop;
import me.alex.firstplugin.stats.PlayerConfig;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InitializeGameState {
    public static ArrayList<Location> gameSpawnLocations = new ArrayList<>();

    public static void initGameState(Player p) {
        if(gameSpawnLocations.size() == 0) {
            gameSpawnLocations.add(new Location(p.getWorld(), 90,52,-416));
            gameSpawnLocations.add(new Location(p.getWorld(), 99,52,-418));
            gameSpawnLocations.add(new Location(p.getWorld(), 89,51,-428));
            gameSpawnLocations.add(new Location(p.getWorld(), 79,52,-419));
            gameSpawnLocations.add(new Location(p.getWorld(), 83,52,-411));
            gameSpawnLocations.add(new Location(p.getWorld(), 90,51,-409));
        }
        Random r = new Random();
        Location map1 = gameSpawnLocations.get(r.nextInt(gameSpawnLocations.size()));
        p.teleport(map1);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.getInventory().clear();
        Weapon itemToGive = Weapons.weapons.get(PlayerConfig.getConfig().get("Players." + p.getUniqueId() + ".ChosenWeapon"));
        if(itemToGive == null) {
            p.getInventory().setItem(0, new CookieItem().getItem());
            p.sendMessage("error");
        } else {
            itemToGive.giveWeapon(p);
        }
        // LeaveItem.giveLeaveItem(p);
        GameScoreboard.generateScoreboard(p);
        p.setBedSpawnLocation(map1, true);
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 5));
        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, Integer.MAX_VALUE, 5));
        Game.currentGameStats.put(p, new CurrentGameStats(p));
    }
}

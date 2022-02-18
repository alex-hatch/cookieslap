//TODO: Transfer the scoreboard update to the scoreboard class to encourage loose coupling.

package me.alex.firstplugin.game;

import me.alex.firstplugin.items.*;
import me.alex.firstplugin.scoreboard.game.GameScoreboard;
import me.alex.firstplugin.shop.ConstructShop;
import me.alex.firstplugin.statechange.InitializeGameState;
import me.alex.firstplugin.statechange.InitializeSpawnState;
import me.alex.firstplugin.statechange.PlayerJoin;
import me.alex.firstplugin.statechange.Start;
import me.alex.firstplugin.stats.ConfigHandler;
import me.alex.firstplugin.stats.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashMap;
import java.util.Random;

/**
 * Defines what should happen when a player "dies" in cookie slap.
 * Falling into the void counts as a death.
 */
public class Kill implements Listener {
    /**
     * Keeps track of the last person that hit a player that fell into the void.
     * Key: killed
     * Value: killer
     */
    public static HashMap<Entity, Entity> lastDamager = new HashMap<>();

    @EventHandler
    public void onDamage(EntityDamageEvent e) {

        if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {

            // If player falls into the void without being in the game
            if(!(Game.currentGameStats.containsKey((Player) e.getEntity()))) {
                InitializeSpawnState.initSpawnState((Player) e.getEntity());
                return;
            }

            // Move player back to starting spot
            Player killed = (Player) e.getEntity();
            Random r = new Random();
            Location map1 = InitializeGameState.gameSpawnLocations.get(r.nextInt(InitializeGameState.gameSpawnLocations.size()));
            killed.teleport(map1);
            killed.getInventory().clear();
            Weapon itemToGive = Weapons.weapons.get(PlayerConfig.getConfig().get("Players." + killed.getUniqueId() + ".ChosenWeapon"));
            itemToGive.giveWeapon(killed);
            // LeaveItem.giveLeaveItem(killed);
            Player killer = (Player) lastDamager.get(e.getEntity());

            // Null check to see if the player was actually hit into the void or just jumped into the void
            if (killer != null) {
                killed.sendMessage(ChatColor.RED + "You were knocked off by " + ChatColor.DARK_RED + killer.getDisplayName() + "!");
                killer.sendMessage(ChatColor.GOLD + "+5 coins " + ChatColor.GREEN + "for knocking " + killed.getDisplayName() + " into the void");
                // Killer left while killed was falling into the void
                if(Game.currentGameStats.containsKey(killer)) {
                    GameScoreboard.updateKillerScoreboard(killer);
                }
            } else {
                killed.sendMessage(ChatColor.RED + "Don't walk off the map!");
            }
            GameScoreboard.updateKilledScoreBoard(killed);
            ConfigHandler.updateStatsOnKill(killer, killed);
            if(Game.currentGameStats.containsKey(killer)) {
                lastDamager.remove(e.getEntity());
            }
        }
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            Player p = (Player) e.getEntity();
            p.setHealth(20);
        }
    }

    @EventHandler
    public void populateHitters(EntityDamageByEntityEvent e) {
        lastDamager.put(e.getEntity(), e.getDamager());
    }

}

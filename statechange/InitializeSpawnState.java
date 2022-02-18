package me.alex.firstplugin.statechange;

import me.alex.firstplugin.game.Game;
import me.alex.firstplugin.items.JoinItem;
import me.alex.firstplugin.items.OwnedItems;
import me.alex.firstplugin.items.ShopItem;
import me.alex.firstplugin.scoreboard.lobby.LobbyScoreboard;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class InitializeSpawnState {
    public static void initSpawnState(Player p) {
        Location spawn = new Location(p.getWorld(), 100.494, 53.0, -23.447);
        p.setBedSpawnLocation(spawn, true);
        p.teleport(spawn);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.removePotionEffect(PotionEffectType.HEAL);
        p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        LobbyScoreboard.generateScoreboard(p);
        Game.currentGameStats.remove(p);
        p.getInventory().clear();
        // JoinItem.giveJoinItem(p);
        ShopItem.giveShopItem(p);
        OwnedItems.giveOwnedItem(p);
    }
}

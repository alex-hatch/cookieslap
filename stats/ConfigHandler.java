package me.alex.firstplugin.stats;

import me.alex.firstplugin.game.Game;
import me.alex.firstplugin.statechange.Start;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ConfigHandler {

    public static void updateStatsOnKill(Player killer, Player killed) {
        if (killer != null) {
            int kills = PlayerConfig.getConfig().getInt("Players." + killer.getUniqueId().toString() + ".Kills");
            int coins = PlayerConfig.getConfig().getInt("Players." + killer.getUniqueId().toString() + ".Coins");
            PlayerConfig.getConfig().set("Players." + killer.getUniqueId().toString() + ".Kills", kills + 1);
            PlayerConfig.getConfig().set("Players." + killer.getUniqueId().toString() + ".Coins", coins + 5);
            int currentStreak = Game.currentGameStats.get(killer).getGameStreak();
            int highestStreak = PlayerConfig.getConfig().getInt("Players." + killer.getUniqueId().toString() + ".HighestStreak");
            if (currentStreak > highestStreak) {
                PlayerConfig.getConfig().set("Players." + killer.getUniqueId().toString() + ".HighestStreak", currentStreak);
            }
            PlayerConfig.save();

            if (currentStreak >= 5) {
                killer.getServer().broadcastMessage(ChatColor.ITALIC + "" + ChatColor.GOLD + killer.getDisplayName() + ChatColor.GRAY + " is on a " + currentStreak + " kill streak!");
            }
        }

        int deaths = PlayerConfig.getConfig().getInt("Players." + killed.getUniqueId().toString() + ".Deaths");
        PlayerConfig.getConfig().set("Players." + killed.getUniqueId().toString() + ".Deaths", deaths + 1);
        PlayerConfig.save();
    }
}

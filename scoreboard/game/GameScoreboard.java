package me.alex.firstplugin.scoreboard.game;

import me.alex.firstplugin.game.Game;
import me.alex.firstplugin.statechange.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class GameScoreboard {

    public static void generateScoreboard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Kills", "");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.RED + "Game Stats");
        Score kills = objective.getScore(ChatColor.WHITE + "Kills: " + ChatColor.RED + "0");
        Score currentStreak = objective.getScore(ChatColor.WHITE + "Streak: " + ChatColor.RED + "0");

        kills.setScore(2);
        currentStreak.setScore(1);
        p.setScoreboard(board);
    }

    public static void updateKillerScoreboard(Player killer) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Kills", "");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.RED + "Cookie Slap");


        Game.currentGameStats.get(killer).incGameKills();
        Game.currentGameStats.get(killer).incGameStreak();
        Score kills = objective.getScore(ChatColor.WHITE + "Kills: " + ChatColor.RED + Game.currentGameStats.get(killer).getGameKills());
        Score streak = objective.getScore(ChatColor.WHITE + "Streak: " + ChatColor.RED + Game.currentGameStats.get(killer).getGameStreak());
        kills.setScore(2);
        streak.setScore(1);
        killer.setScoreboard(board);
    }

    public static void updateKilledScoreBoard(Player killed) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Kills", "");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.RED + "Cookie Slap");

        Game.currentGameStats.get(killed).resetGameStreak();
        Score kills = objective.getScore(ChatColor.WHITE + "Kills: " + ChatColor.RED + Game.currentGameStats.get(killed).getGameKills());
        Score streak = objective.getScore(ChatColor.WHITE + "Streak: " + ChatColor.RED + Game.currentGameStats.get(killed).getGameStreak());
        kills.setScore(2);
        streak.setScore(1);
        killed.setScoreboard(board);
    }

    public static void disableScoreBoard(Player p) {
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

}

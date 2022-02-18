package me.alex.firstplugin.game;

import me.alex.firstplugin.statechange.Start;
import org.bukkit.entity.Player;

public class CurrentGameStats {
    private int gameKills;
    private int gameStreak;
    private final Player player;

    public CurrentGameStats(Player p) {
        gameKills = 0;
        gameStreak = 0;
        this.player = p;
    }

    public void incGameKills() {
        gameKills++;
    }

    public int getGameKills() {
        return gameKills;
    }

    public void incGameStreak() {
        gameStreak++;
    }

    public int getGameStreak() {
        return gameStreak;
    }

    public void resetGameStreak() {
        gameStreak = 0;
    }

    public Player getPlayer() {
        return player;
    }
}

package me.alex.firstplugin.game;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Game {
    /**
     * If player is in the hashmap, then they are currently playing the game
     */
    public static HashMap<Player, CurrentGameStats> currentGameStats = new HashMap<>();

}

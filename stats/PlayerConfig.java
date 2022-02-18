package me.alex.firstplugin.stats;

import me.alex.firstplugin.items.Weapon;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerConfig {

    private static File file;
    private static FileConfiguration playerFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("CookieSlap").getDataFolder(), "playerconfig");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        playerFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig() {
        return playerFile;
    }

    public static void save() {
        try {
            playerFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        playerFile = YamlConfiguration.loadConfiguration(file);
    }

    public static int getCoins(Player p) {
        return playerFile.getInt("Players." + p.getUniqueId().toString() + ".Coins");
    }

    public static void setCoins(Player p, int newAmount) {
        playerFile.set("Players." + p.getUniqueId().toString() + ".Coins", newAmount);
    }

    public static ArrayList<String> getOwnedWeapons(Player p) {
        return (ArrayList<String>) playerFile.getStringList("Players." + p.getUniqueId() + ".OwnedWeapons");
    }
}

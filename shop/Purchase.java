//TODO: Make a hashmap of items to price and search the hashmap for the item clicked
package me.alex.firstplugin.shop;

import me.alex.firstplugin.game.Game;
import me.alex.firstplugin.game.Kill;
import me.alex.firstplugin.items.*;
import me.alex.firstplugin.scoreboard.lobby.LobbyScoreboard;
import me.alex.firstplugin.statechange.PlayerJoin;
import me.alex.firstplugin.statechange.Start;
import me.alex.firstplugin.stats.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

public class Purchase implements Listener {

    @EventHandler
    public void onPurchase(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null) {
            return;
        }

        if(!e.getCurrentItem().hasItemMeta()) {
            return;
        }

        // If player is in a game, they should not be purchasing an item
        if(Game.currentGameStats.containsKey(p)) {
            return;
        }

        Weapon itemClicked = Weapons.weapons.get(e.getCurrentItem().getItemMeta().getDisplayName());

        if(itemClicked == null) {
            return;
        }

        if(PlayerConfig.getOwnedWeapons(p).contains(itemClicked.getName())) {
            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Collection" + ChatColor.GRAY + " (Right Click)")) {
                PlayerConfig.getConfig().set("Players." + p.getUniqueId() + ".ChosenWeapon", itemClicked.getName());
                PlayerConfig.save();
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "New weapon selected");
                LobbyScoreboard.generateScoreboard(p);
                return;
            }
            p.sendMessage(ChatColor.YELLOW + "You already own this item!");
            p.closeInventory();
            return;
        }

        if(PlayerConfig.getCoins(p) < itemClicked.getPrice()) {
            p.sendMessage(ChatColor.RED + "You do not have enough coins for this");
            p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.G));
            PlayerConfig.save();
        } else {
            PlayerConfig.setCoins(p, PlayerConfig.getCoins(p) - itemClicked.getPrice());
            p.sendMessage(ChatColor.GREEN + "You purchased a " + itemClicked.getName() + "!");
            p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Note.Tone.E));
            ArrayList<String> playerWeapons = (ArrayList<String>) PlayerConfig.getOwnedWeapons(p);
            playerWeapons.add(itemClicked.getName());
            PlayerConfig.getConfig().set("Players." + p.getUniqueId() + ".OwnedWeapons", playerWeapons);

            PlayerConfig.save();
            LobbyScoreboard.generateScoreboard(p);
        }
            p.closeInventory();
    }
}


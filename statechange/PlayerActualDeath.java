package me.alex.firstplugin.statechange;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerActualDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage("");
        e.getEntity().sendMessage(ChatColor.RED + "That wasn't supposed to happen. Please rejoin the server and let an admin know you died.");
    }

}

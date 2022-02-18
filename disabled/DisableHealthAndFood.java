package me.alex.firstplugin.disabled;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class DisableHealthAndFood implements Listener {
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        Player p = (Player) event.getEntity();
        event.setFoodLevel(p.getFoodLevel());
    }

}
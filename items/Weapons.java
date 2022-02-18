package me.alex.firstplugin.items;

import java.util.HashMap;

public class Weapons {
    public static final HashMap<String, Weapon> weapons = new HashMap<>();

    public static void initializeWeapons() {
        if(weapons.size() == 0) {
            CookieItem cookieItem = new CookieItem();
            BoneItem boneItem = new BoneItem();
            StickItem stickItem = new StickItem();
            CakeItem cakeItem = new CakeItem();
            GoldenAppleItem gapple = new GoldenAppleItem();
            DiamondItem diamond = new DiamondItem();

            weapons.put(cookieItem.getName(), cookieItem);
            weapons.put(stickItem.getName(), stickItem);
            weapons.put(boneItem.getName(), boneItem);
            weapons.put(cakeItem.getName(), cakeItem);
            weapons.put(gapple.getName(), gapple);
            weapons.put(diamond.getName(), diamond);
        }
    }
}

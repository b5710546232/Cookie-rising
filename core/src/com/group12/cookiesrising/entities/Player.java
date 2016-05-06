package com.group12.cookiesrising.Entities;

import com.group12.cookiesrising.gameobjects.Enemy;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Player {
    private double dmg;
    private double money;
    public Player(){
        dmg = 1;
    }

    public void attack(Enemy m){
        m.takeDamage(dmg);
    }


}

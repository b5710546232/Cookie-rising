package com.group12.cookiesrising.Entities;

import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Player {
    private List<Hero> heros;
    private double dmg;
    private double money;
    public Player(){
        dmg = 1;
        heros = new ArrayList<Hero>();
    }

    public void attack(Enemy m){
        m.takeDamage(dmg);
    }

    public void addHero(Hero h){
        heros.add(h);
    }

    public List<Hero> getHeros(){
        return heros;
    }

}

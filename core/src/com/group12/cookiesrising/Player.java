package com.group12.cookiesrising;

import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Party;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Player {

    private double dmg;
    private double money;
    public Party party;

    public Player(){
        dmg = 1;
        //will load later;
        money = 0;
        party = new Party();
    }

    public void addHero(Hero h){
        party.addHero(h);
    }

    public void attack(Enemy m){
        m.takeDamage(dmg);
    }

    public void takeMoney(double money){
        this.money += money;
    }

    public double getMoney(){
        return this.money;
    }

    public String getDamageText() {
        return dmg+"";
    }
}

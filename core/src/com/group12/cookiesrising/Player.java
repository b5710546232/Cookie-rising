package com.group12.cookiesrising;

import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Party;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Player {

    private double attackPoint;
    private double money;
    private double healPoint;
    private double criticalRate;
    public Party party;

    public Player(){
        attackPoint = 1;
        //will load later;
        money = 0;
        party = new Party();
        healPoint = 1;
        criticalRate = 1;
    }
    public void upgradeAtk(){ attackPoint++; }
    public void upgradeHeal(){ healPoint++; }
    public void upgradeCrt(){ criticalRate++; }

    public void addHero(Hero h){
        party.addHero(h);
    }

    public void attack(Enemy m){
        m.takeDamage(attackPoint);
    }

    public void takeMoney(double money){
        this.money += money;
    }

    public double getMoney(){
        return this.money;
    }

    public String getDamageText() {
        return attackPoint+"";
    }
}

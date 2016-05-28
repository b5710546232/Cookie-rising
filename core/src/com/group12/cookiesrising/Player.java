package com.group12.cookiesrising;

import com.group12.cookiesrising.Listener.AttackButtonListener;
import com.group12.cookiesrising.Listener.CriticalButtonListener;
import com.group12.cookiesrising.Listener.HealButtonListener;
import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Party;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Player extends Observable implements Upgradable,Observer{

    private int attackPoint;
    private double money;
    private int healPoint;
    private int criticalRate;
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

    public int getAttackPoint() {
        return attackPoint;
    }

    public int getCriticalRate() {
        return criticalRate;
    }

    public int getHealPoint() {
        return healPoint;
    }

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

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof AttackButtonListener){
            upgradeAtk();
        }else if (o instanceof HealButtonListener){
            upgradeHeal();
        }else if (o instanceof CriticalButtonListener){
            upgradeCrt();
        }
    }
}

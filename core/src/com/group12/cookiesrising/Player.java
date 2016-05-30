package com.group12.cookiesrising;

import com.group12.cookiesrising.Listener.AttackButtonListener;
import com.group12.cookiesrising.Listener.CriticalButtonListener;
import com.group12.cookiesrising.Listener.HealButtonListener;
import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Party;
import com.group12.cookiesrising.util.RandomGenerator;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Player extends Observable implements Upgradable,Observer,Health{

    private int attackPoint;
    private double money;
    private int healPoint;
    private int criticalRate;


    private boolean isCritical;
    public Party party;
    private final int CRI_RATE_MIN = 1;
    private final int CRI_RATE_MAX = 100;
    private RandomGenerator rng;

    private int criticalFactor = 2;

    public Player(){
        attackPoint = 1;
        //will load later;
        money = 0;
        party = new Party();
        healPoint = 1;
        criticalRate = 1;
        rng = new RandomGenerator(CRI_RATE_MIN,CRI_RATE_MAX);
    }
    public void upgradeAtk(){ attackPoint++; }
    public void upgradeHeal(){ healPoint++; }
    public void upgradeCrt(){ criticalRate++; }

    public int getAttackPoint() {
        return attackPoint;
    }

    public boolean isCritical() {
        return isCritical;
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
        rng.random();
        if(criticalRate<=rng.getValue()){
            //cri
            criticalFactor = 2;

            isCritical = true;
        }
        else{
            criticalFactor = 1;

            isCritical = false;
        }
        m.takeDamage(attackPoint*criticalFactor);

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

    @Override
    public double getHp() {
        double hp = 0;
        for (Hero h : party.getHeroList()){
            hp+=h.getHp();
        }
        return hp;
    }

    @Override
    public double getMaxHp() {
        double maxHp = 0;
        for (Hero h : party.getHeroList()){
            maxHp+=h.getMaxHp();
        }
        return maxHp;
    }

    public Party getParty() {
        return party;
    }
}

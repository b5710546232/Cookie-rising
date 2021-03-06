package com.group12.cookiesrising;

import com.badlogic.gdx.Gdx;
import com.group12.cookiesrising.Listener.AttackButtonListener;
import com.group12.cookiesrising.Listener.CriticalButtonListener;
import com.group12.cookiesrising.Listener.HealButtonListener;
import com.group12.cookiesrising.Listener.HeroButtonListener;
import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Party;
import com.group12.cookiesrising.gametext.TextPool;
import com.group12.cookiesrising.util.Assets;
import com.group12.cookiesrising.util.RandomGenerator;
import com.group12.cookiesrising.util.SaveManager;

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
    private String dmgText;

    private boolean isCritical;
    public Party party;
    private final int CRI_RATE_MIN = 1;
    private final int CRI_RATE_MAX = 100;
    public static final int ATK = 0;
    public static final int HEAL = 1;
    public static final int CRI = 2;
    private RandomGenerator rng;

    private int criticalFactor = 2;

    public Player(){

        //will load later;
        party = new Party();
        healPoint = 1;
        criticalRate = 1;
        dmgText = attackPoint+"";
        rng = new RandomGenerator(CRI_RATE_MIN,CRI_RATE_MAX);
        loadData();
    }
    public void upgradeAtk(){
        int price = getUpgradeCost(ATK);
        if (money>=price){
            money-=price;
            attackPoint++;
        }
    }
    public void upgradeHeal(){
        int price = getUpgradeCost(HEAL);
        if (money>=price){
            money-=price;
            healPoint++;
        }
    }
    public void upgradeCrt(){
        int price = getUpgradeCost(CRI);
        if (money>=price){
            money-=price;
            criticalRate++;
        }
    }

    @Override
    public int getUpgradeCost(int field) {
        int level = 0;
        if (field == ATK) level = attackPoint;
        else if (field==HEAL) level = healPoint;
        else if (field==CRI) level = criticalRate;
        return (int)(100*Math.pow(1.2,level-1));
    }

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
        if(criticalRate>=rng.getValue()){
            //cri
            criticalFactor = 2;

            isCritical = true;
        }
        else{
            criticalFactor = 1;

            isCritical = false;
        }
        m.takeDamage(attackPoint*criticalFactor);
        dmgText = (int)(attackPoint*criticalFactor) + "";

    }

    public void takeMoney(double money){
        this.money += money;
    }

    public double getMoney(){
        return this.money;
    }

    public String getDamageText() {
        return dmgText;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof AttackButtonListener){
            upgradeAtk();
        }else if (o instanceof HealButtonListener){
            upgradeHeal();
        }else if (o instanceof CriticalButtonListener){
            upgradeCrt();
        }else if (o instanceof HeroButtonListener){
            upgradeHero(((HeroButtonListener) o).getHero_num());
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

    public void upgradeHero(int hero_num){
        int cost = party.getHeroList().get(hero_num).getUpgradeCost(0);
        if (cost<=money){
            money-=cost;
            party.getHeroList().get(hero_num).upgrade();
        }
    }

    public void loadData(){
        if(SaveManager.loadDataValue("money",double.class) != null){
            money = SaveManager.loadDataValue("money",int.class);
        } else{
            money = 0;
        }
        if(SaveManager.loadDataValue("player_attackpoint",int.class)!=null){
            attackPoint = SaveManager.loadDataValue("player_attackpoint",int.class);
        } else{
            attackPoint = 1;
        }
        if(SaveManager.loadDataValue("player_criticalrate",int.class)!=null){
            criticalRate = SaveManager.loadDataValue("player_criticalrate",int.class);
        } else{
            criticalRate = 1;
        }
        if(SaveManager.loadDataValue("player_healpoint",int.class)!=null){
            healPoint = SaveManager.loadDataValue("player_healpoint",int.class);
        } else{
            healPoint = 1;
        }

    }
    public void saveData(){
        SaveManager.saveDataValue("money",money);
        SaveManager.saveDataValue("player_attackpoint",getAttackPoint());
        SaveManager.saveDataValue("player_criticalrate",getCriticalRate());
        SaveManager.saveDataValue("player_healpoint",getHealPoint());
    }
    public void heal(Hero h){
        h.takeDamage(-getHealPoint());
    }
}

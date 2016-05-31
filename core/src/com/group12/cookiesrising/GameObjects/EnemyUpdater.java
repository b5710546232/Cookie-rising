package com.group12.cookiesrising.gameobjects;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class EnemyUpdater {
    private Enemy e;
    private final int CYCLE = 1;
    private int currentCycle = 1;

    public EnemyUpdater(Enemy e) {
        this.e = e;
    }

    public void update(){
        if(currentCycle%CYCLE ==0){
            e.setMaxHealthPoint(e.getMaxHp()+5);
            e.setMoney(e.getMoney()+10);
            //e.setAttackPoint(e.getAttackPoint()+0.5);
            e.setAttackPoint(2);
            e.setSpeed(e.getSpeed()*0.95f);
            currentCycle =0;
        }
        currentCycle++;
    }
}

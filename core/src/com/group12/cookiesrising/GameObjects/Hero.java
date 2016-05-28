package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.Upgradable;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Hero extends AbstractGameObject implements Hittable,Upgradable {

    private double attackPoint;
    private double healthPoint;
    private double healPoint;
    private double criticalRate;
    private int level;
    private boolean isAlive;

    public Hero(int x,int y) {
        super(x,y);
      init();
    }

    private void init() {
        attackPoint = 1;
        healthPoint = 10;
        healPoint = 1;
        criticalRate = 1;
        level = 1;
    }

    public void attack(Enemy m){
        if(m.isAlive())
        m.takeDamage(attackPoint);
    }

    public void takeDamage(double dmg){
        if(isActive)healthPoint -= dmg;
        if(healthPoint <=0){
            isActive = false;
            healthPoint = 0;
        }
    }

    public void upgradeAtk(){ attackPoint++; }
    public void upgradeHeal(){ healPoint++; }
    public void upgradeCrt(){ criticalRate++; }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hero,position.x,position.y);
    }
}

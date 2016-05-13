package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Hero extends AbstractGameObject {

    private double attackPoint;
    private double healthPoint;
    private double speed;
    private double criticalRate;
    private boolean isAlive;

    public Hero(int x,int y) {
        super(x,y);
      init();
    }

    private void init() {
        attackPoint = 1;
        healthPoint = 10;
    }

    public void attack(Enemy m){
        if(m.isAlive)
        m.takeDamage(attackPoint);
    }

    public void takeDamge(double dmg){
        if(isActive)healthPoint -= dmg;
    }



    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hero,position.x,position.y);
    }
}

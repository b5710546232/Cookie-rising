package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Hero extends AbstractGameObject {

    private double attackPoint;
    private double speed;
    private double criticalRate;

    public Hero(int x,int y) {
        super(x,y);
        attackPoint = 1;
    }

    private void init() {

    }

    public void attack(Enemy m){
        if(m.isAlive)
        m.takeDamage(attackPoint);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hero,position.x,position.y);
    }
}

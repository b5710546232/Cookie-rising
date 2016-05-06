package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Hero implements IGameObjectDrawable{

    private double attackPoint;
    private double speed;
    private double criticalRate;
    private Vector2 positon;

    public Hero() {
        init();
        attackPoint = 1;
    }

    private void init() {
        positon = new Vector2(100,100);
    }

    public void attack(Enemy m){
        if(m.isAlive)
        m.takeDamage(attackPoint);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hero,positon.x,positon.y);
    }
}

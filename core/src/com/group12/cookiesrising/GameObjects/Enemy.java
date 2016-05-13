package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Enemy implements IGameObjectDrawable{
    public static final String TAG = Enemy.class.getName();
    private double healthPoint;
    private double attackPoint;
    public boolean isAlive;
    private double money;


    public Enemy() {
        init();
    }

    public void init(){
        isAlive = true;
        healthPoint = 10;
        attackPoint = 1;
        money = 100;
    }

    public double getMoney(){
        return money;
    }

    public void takeDamage(double dmg){
        healthPoint-=dmg;
        Gdx.app.log(TAG,"current hp = "+healthPoint);
        if(healthPoint<=0){
            isAlive = false;
            Gdx.app.log(TAG,"monster die");
        }
    }

    public void attack(Hero h){
        h.takeDamge(attackPoint);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.mon,570,100);
    }
}

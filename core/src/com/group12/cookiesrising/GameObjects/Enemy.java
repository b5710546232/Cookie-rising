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
    public boolean isAlive;


    public Enemy() {
        init();
    }

    public void init(){
        isAlive = true;
        healthPoint = 100;
    }

    public void takeDamage(double dmg){
        healthPoint-=dmg;
        Gdx.app.log(TAG,"current hp = "+healthPoint);
        if(healthPoint<=0){
            isAlive = false;
            Gdx.app.log(TAG,"monster die");
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.mon,570,100);
    }
}

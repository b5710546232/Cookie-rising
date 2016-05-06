package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Monster implements IGameObjectDrawable{
    private double healthPoint;
    public boolean isAlive;


    public Monster() {

    }

    public void init(){
        isAlive = true;
        healthPoint = 10;
    }

    public void takeDamage(double dmg){
        healthPoint-=dmg;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.mon,570,100);
    }
}

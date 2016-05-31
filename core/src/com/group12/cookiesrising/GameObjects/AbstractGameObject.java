package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public abstract class AbstractGameObject{
    protected Vector2 position;
    public boolean isAlive;
    public boolean isActive;


    public AbstractGameObject(int x , int y) {
        position = new Vector2(x,y);
        isActive = false;
    }

    public abstract void update(float delta);
    public abstract void draw(SpriteBatch batch);

    public Vector2 getPosition() {
        return position;
    }

    public AbstractGameObject() {
        isActive = false;
    }

}

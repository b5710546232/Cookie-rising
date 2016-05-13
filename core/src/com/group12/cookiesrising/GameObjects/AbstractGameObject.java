package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public abstract class AbstractGameObject implements IGameObjectDrawable{
    protected Vector2 position;
    public boolean isAlive;
    public boolean isActive;


    public AbstractGameObject(int x , int y) {
        position = new Vector2(x,y);
        isActive = false;
    }


    public AbstractGameObject() {
        isActive = false;
    }

}

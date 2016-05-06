package com.group12.cookiesrising.gameworld;

import com.group12.cookiesrising.composite.CompositeGameObjectDrawable;
import com.group12.cookiesrising.gameobjects.BG;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Monster;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class GameWorld {
    private static final String TAG = GameWorld.class.getName();


    CompositeGameObjectDrawable gameObjectContainer;

    public GameWorld(){
        init();
    }

    private void init() {
        gameObjectContainer = new CompositeGameObjectDrawable();
        Monster m = new Monster();
        Hero h = new Hero();
        BG bg = new BG();
        gameObjectContainer.add(bg);
        gameObjectContainer.add(m);
        gameObjectContainer.add(h);
    }

    public void update(float detaTime){

    }
    public CompositeGameObjectDrawable getGameObjectContainer() {
        return gameObjectContainer;
    }
}

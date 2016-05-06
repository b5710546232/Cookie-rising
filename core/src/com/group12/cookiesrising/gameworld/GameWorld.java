package com.group12.cookiesrising.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
import com.group12.cookiesrising.Entities.Player;
import com.group12.cookiesrising.composite.CompositeGameObjectDrawable;
import com.group12.cookiesrising.gameobjects.BG;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Enemy;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class GameWorld {
    private static final String TAG = GameWorld.class.getName();


    CompositeGameObjectDrawable gameObjectContainer;
    private Player player;
    private Enemy currentEnemy;
    private Hero hero;

    public GameWorld(){
        init();
    }

    private void init() {

        player = new Player();


        gameObjectContainer = new CompositeGameObjectDrawable();
        Enemy m = new Enemy();
        hero = new Hero();
        BG bg = new BG();
        gameObjectContainer.add(bg);
        gameObjectContainer.add(m);
        gameObjectContainer.add(hero);
        // for testing.
        currentEnemy = m;

        // test auto attack.
        Timer.schedule(new Timer.Task(){

            @Override
            public void run() {
                hero.attack(currentEnemy);
            }
        },0,1);
    }

    public void playerAttack(){
        Gdx.app.error(TAG,"call");
        if(currentEnemy.isAlive) {
            this.player.attack(currentEnemy);
            Gdx.app.log(TAG," player attack to monster");
        }
    }

    public void update(float detaTime){

    }
    public CompositeGameObjectDrawable getGameObjectContainer() {
        return gameObjectContainer;
    }
}

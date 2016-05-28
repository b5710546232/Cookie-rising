package com.group12.cookiesrising.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
import com.group12.cookiesrising.Player;
import com.group12.cookiesrising.composite.CompositeGameObjectDrawable;
import com.group12.cookiesrising.composite.CompositeTextObjectDrawable;
import com.group12.cookiesrising.gameobjects.BG;
import com.group12.cookiesrising.gameobjects.Coin;
import com.group12.cookiesrising.gametext.CoinText;
import com.group12.cookiesrising.gametext.DamageTextPool;
import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gametext.StatusText;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class GameWorld {
    private static final String TAG = GameWorld.class.getName();

    CompositeGameObjectDrawable worldContainer;
    CompositeGameObjectDrawable gameObjectContainer;

    CompositeTextObjectDrawable worldTextContainer;

    private Player player;
    private Enemy currentEnemy;
    private Hero hero;
    private Timer.Task nextEnemyTimerTask;
    private float waitTime = 1f;
    private Timer.Task dpsTimer;
    private DamageTextPool dmgTextPool;
    private StatusText statusText;
    private CoinText coinText;
    private boolean lock = false;

    public GameWorld(){
        init();
    }

    private void init() {

        player = new Player();

        worldContainer = new CompositeGameObjectDrawable();
        gameObjectContainer = new CompositeGameObjectDrawable();
        worldTextContainer = new CompositeTextObjectDrawable();
        currentEnemy  = new Enemy();
        hero = new Hero(200,136);
//        player.party.addHero(hero);
        player.party.addHero(hero);
        BG bg = new BG();
        Coin coin = new Coin();
        coinText = new CoinText(player);
        statusText = new StatusText(player);
        gameObjectContainer.add(bg);
        gameObjectContainer.add(currentEnemy);
        gameObjectContainer.add(hero);
        gameObjectContainer.add(coin);
        dmgTextPool = new DamageTextPool(10);

        worldContainer.add(gameObjectContainer);

        worldTextContainer.add(dmgTextPool);
        worldTextContainer.add(coinText);
        worldTextContainer.add(statusText);
        // for testing.

        Timer.instance().clear();
        nextEnemyTimerTask = new Timer.Task() {
            @Override
            public void run() {
                nextEnemy();
                Gdx.app.log(TAG," next enemy");
            }
        };
        // test auto attack.
        this.dpsTimer = new Timer.Task(){

            @Override
            public void run() {

                autoAttack();
            }
        };



        Timer.schedule(this.dpsTimer,0,1);
        Timer.instance().start();
    }

    private void autoAttack() {
        if(currentEnemy != null &&currentEnemy.isAlive()) {
            hero.attack(currentEnemy);
            dmgTextPool.getDamageText(this.player.getDamageText(),450,200);
        }
    }

    public void playerAttack(){
        Gdx.app.error(TAG,"call");
        if(currentEnemy != null &&currentEnemy.isAlive() && !lock) {
            lock = true;
            this.player.attack(currentEnemy);
            dmgTextPool.getDamageText(this.player.getDamageText(),450,200);
            Gdx.app.log(TAG," player attack to monster");
        }
    }

    public void nextEnemy(){
//        currentEnemy = new Enemy();
//        gameObjectContainer.add(currentEnemy);
        currentEnemy.respawn();

    }

    public void update(float delta){
        worldTextContainer.update(delta);
        lock = false;
        if(!currentEnemy.isAlive()&&currentEnemy.waitForSpawn()){
            player.takeMoney(currentEnemy.getMoney());
            Gdx.app.log(TAG, "player money: " + player.getMoney());
//            gameObjectContainer.remove(currentEnemy);
//            currentEnemy = null;
            waitTime = (float)(Math.random()*5 +1 );
            Gdx.app.log(TAG, "spawn delay: " + waitTime);
            Timer.schedule(nextEnemyTimerTask, waitTime, 0 ,0);
            Gdx.app.error(TAG,"call death");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public CompositeGameObjectDrawable getWorldContainer() {
        return worldContainer;
    }

    public CompositeTextObjectDrawable getWorldTextContainer() {
        return worldTextContainer;
    }
}

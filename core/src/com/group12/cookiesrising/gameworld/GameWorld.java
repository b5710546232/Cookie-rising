package com.group12.cookiesrising.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;
import com.group12.cookiesrising.Listener.HeroButtonListener;
import com.group12.cookiesrising.Player;
import com.group12.cookiesrising.composite.CompositeGameObject;
import com.group12.cookiesrising.composite.CompositeTextDraw;
import com.group12.cookiesrising.composite.TextDraw;
import com.group12.cookiesrising.gameobjects.BG;
import com.group12.cookiesrising.gameobjects.Coin;
import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.gameobjects.Gunner;
import com.group12.cookiesrising.gameobjects.HealthBar;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Mage;
import com.group12.cookiesrising.gameobjects.Party;
import com.group12.cookiesrising.gameobjects.Warrior;
import com.group12.cookiesrising.gametext.AbstractGameTextFactory;
import com.group12.cookiesrising.gametext.CoinText;
import com.group12.cookiesrising.gametext.CriticalDamgeFactory;
import com.group12.cookiesrising.gametext.DamageTextFactory;
import com.group12.cookiesrising.gametext.HealTextFactory;
import com.group12.cookiesrising.gametext.HeroLevelText;
import com.group12.cookiesrising.gametext.StatusText;
import com.group12.cookiesrising.gametext.TextPool;
import com.group12.cookiesrising.gametext.UpgradeCostText;
import com.group12.cookiesrising.util.Assets;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class GameWorld implements Observer{
    private static final String TAG = GameWorld.class.getName();

    CompositeGameObject worldContainer;
    CompositeGameObject gameObjectContainer;

    CompositeTextDraw worldTextContainer;

    private Player player;
    private Enemy currentEnemy;
    private Hero warrior;
    private Hero mage;
    private Hero gunner;
    private Timer.Task nextEnemyTimerTask;
    private float waitTime = 1;
    private Timer.Task warriorTimer,mageTimer,gunnerTimer,warriorSpawn,mageSpawn,gunnerSpawn;
    private Timer.Task enemyAttackTimer;
    private TextPool dmgTextPool;
    private TextPool criTextPool;
    private TextPool healTextPool;
    private AbstractGameTextFactory damgeTextFactory;
    private AbstractGameTextFactory criticalDamageTextFactory;
    private AbstractGameTextFactory healTextFactory;
    private TextDraw textDraw;
    private boolean lock = false;
    private TextDraw textDraw2;

    public GameWorld(){
        init();
    }

    private BitmapFont font;
    private BitmapFont font2;

    private void init() {

        player = new Player();
        font = new BitmapFont();
        font2 = new BitmapFont(Gdx.files.internal("fonts/Visitor.fnt"));
        damgeTextFactory = new DamageTextFactory();
        criticalDamageTextFactory = new CriticalDamgeFactory();
        healTextFactory = new HealTextFactory();

        worldContainer = new CompositeGameObject();
        gameObjectContainer = new CompositeGameObject();
        worldTextContainer = new CompositeTextDraw();
        textDraw = new TextDraw(font);
        textDraw2 = new TextDraw(font2);
        currentEnemy  = new Enemy();
        warrior = new Warrior(250,136);
        mage = new Mage(170,136);
        gunner = new Gunner(90,136);
        player.addHero(warrior);
        player.addHero(mage);
        player.addHero(gunner);
        BG bg = new BG();
        Coin coin = new Coin();
        CoinText coinText = new CoinText(player);
        StatusText statusText = new StatusText(player);
        HealthBar hpEnemy = new HealthBar(currentEnemy,400,270,1);
        HealthBar hpHero = new HealthBar(warrior,250,200,2);
        HealthBar hpMage = new HealthBar(mage,170,200,2);
        HealthBar hpGunner = new HealthBar(gunner,90,200,2);
        HeroLevelText heroLevelText = new HeroLevelText(player);
        UpgradeCostText upgradeCostText = new UpgradeCostText(player);
        gameObjectContainer.add(bg);
        gameObjectContainer.add(currentEnemy);
        gameObjectContainer.add(warrior);
        gameObjectContainer.add(gunner);
        gameObjectContainer.add(coin);
        gameObjectContainer.add(mage);
        gameObjectContainer.add(hpEnemy);
        gameObjectContainer.add(hpHero);
        gameObjectContainer.add(hpMage);
        gameObjectContainer.add(hpGunner);
        dmgTextPool = new TextPool(damgeTextFactory,10);
        criTextPool = new TextPool(criticalDamageTextFactory,3);
        healTextPool = new TextPool(healTextFactory,10);
        worldContainer.add(gameObjectContainer);

        textDraw2.add(dmgTextPool);
        textDraw2.add(criTextPool);
        textDraw2.add(healTextPool);
        textDraw.add(coinText);
        textDraw.add(statusText);
        textDraw.add(heroLevelText);
        textDraw.add(upgradeCostText);
        worldTextContainer.add(textDraw);
        worldTextContainer.add(textDraw2);
        // for testing.

        Timer.instance().clear();
        nextEnemyTimerTask = new Timer.Task() {
            @Override
            public void run() {
                nextEnemy();
                Gdx.app.log(TAG," next enemy");
            }
        };
        // test auto action.
        this.warriorTimer = new Timer.Task(){

            @Override
            public void run() {
                warriorAttack();
            }
        };
        this.enemyAttackTimer = new Timer.Task() {
            @Override
            public void run() {
                enemyAttack();
            }
        };
        this.mageTimer = new Timer.Task() {
            @Override
            public void run() {
                mageAttack();
            }
        };
        this.gunnerTimer = new Timer.Task() {
            @Override
            public void run() {
                gunnerAttack();
            }
        };
        this.warriorSpawn = new Timer.Task() {
            @Override
            public void run() {
                spawn(warrior);
               // Timer.schedule(warriorTimer,0,warrior.getSpeed());
            }
        };

        this.mageSpawn = new Timer.Task() {
            @Override
            public void run() {
                spawn(mage);
               // Timer.schedule(mageTimer,0,mage.getSpeed());
            }
        };

        this.gunnerSpawn = new Timer.Task() {
            @Override
            public void run() {
                spawn(gunner);
               // Timer.schedule(gunnerTimer,0,gunner.getSpeed());
            }
        };

        int delay = 3;
        int interval = 3;
        Timer.schedule(this.warriorTimer,delay, warrior.getSpeed());
        Timer.schedule(this.mageTimer,delay+1,mage.getSpeed());
        Timer.schedule(this.gunnerTimer,delay+2,gunner.getSpeed());
        Timer.schedule(this.enemyAttackTimer,delay,currentEnemy.getSpeed());
        Timer.instance().start();
    }

    private void enemyAttack(){
        if (currentEnemy.isAlive()){
            Party party = player.getParty();
            int target = (int)Math.floor(Math.random()*(party.getHeroList().size()+1));
//            Gdx.app.log(getClass().getName(),"random = "+target);
            if (target==3) {
                currentEnemy.action(party);
                for(Hero h: party.getHeroList()){
                    if (h.isAlive()){
                        dmgTextPool.getDamageText(Integer.toString((int)Math.floor(currentEnemy.getAttackPoint())),Math.round(h.getPosition().x),Math.round(h.getPosition().y));
                    }
                }
            }else {
                Hero h = party.getHeroList().get(target);
                currentEnemy.action(h);
                if (h.isAlive()){
                    dmgTextPool.getDamageText(Integer.toString((int)Math.floor(currentEnemy.getAttackPoint())),Math.round(h.getPosition().x),Math.round(h.getPosition().y));
                }
            }
        }
    }
    private void warriorAttack() {
        if(currentEnemy != null &&currentEnemy.isAlive()&&warrior.isAlive()) {
            warrior.action(currentEnemy);
            if(this.warrior.isCritical()){
                // criText
                criTextPool.getDamageText(this.warrior.getDmgText(),448,200);
            }
            else {
                // normalText
                dmgTextPool.getDamageText(this.warrior.getDmgText(), 450, 200);
            }
        }
    }
    private void mageAttack(){
        Party p = player.getParty();
        double max =0;
        Hero h =null,temp;
        for(int i = 0; i<p.getHeroList().size();i++){
            temp = p.getHeroList().get(i);
            if( (max < calPerHP( temp ) ) && temp.isAlive() ){
                h = temp;
                max = calPerHP(temp);
            }
        }
        if(h!=null){
            mage.action(h);
            healTextPool.getDamageText(mage.getDmgText(),Math.round(h.getPosition().x),Math.round(h.getPosition().y));
        }
    }

    private double calPerHP(Hero h){
        return (h.getMaxhealthPoint()-h.getHealthPoint())/h.getMaxhealthPoint()*100;
    }

    private void gunnerAttack(){
        if(currentEnemy != null &&currentEnemy.isAlive()&&gunner.isAlive()) {
            gunner.action(currentEnemy);
            if(this.gunner.isCritical()){
                // criText
                criTextPool.getDamageText(this.gunner.getDmgText(),448,200);
            }
            else {
                // normalText
                dmgTextPool.getDamageText(this.gunner.getDmgText(), 450, 200);
            }
        }
    }



    private void spawn(Hero h){
        h.respawn();
    }

    public void playerAttack(){
        Gdx.app.error(TAG,"call");
        if(currentEnemy != null &&currentEnemy.isAlive() && !lock) {
            lock = true;
            this.player.attack(currentEnemy);
            if(this.player.isCritical()){
                // criText
                criTextPool.getDamageText(this.player.getDamageText(),448,200);
            }
            else {
                // normalText
                dmgTextPool.getDamageText(this.player.getDamageText(), 450, 200);
            }

            Gdx.app.log(TAG," player action to monster");
        }
    }

    public void playerHeal(){
        Party p = player.getParty();
        double max =0;
        Hero h =null,temp;
        for(int i = 0; i<p.getHeroList().size();i++){
            temp = p.getHeroList().get(i);
            if( (max < calPerHP( temp ) ) && temp.isAlive() ){
                h = temp;
                max = calPerHP(temp);
            }
        }
        if(h!=null){
            player.heal(h);
            healTextPool.getDamageText(mage.getDmgText(),Math.round(h.getPosition().x),Math.round(h.getPosition().y));
            Assets.heal_sound.play(1.0f);
        }
    }

    public void nextEnemy(){
        currentEnemy.respawn();
        Timer.schedule(enemyAttackTimer,0,currentEnemy.getSpeed());
    }

    public void update(float delta){
        worldTextContainer.update(delta);
        worldContainer.update(delta);
        lock = false;
        if(!currentEnemy.isAlive()&&currentEnemy.waitForSpawn()){
            player.takeMoney(currentEnemy.getMoney());
            Gdx.app.log(TAG, "player money: " + player.getMoney());
//            waitTime = (float)(Math.random()*5 +1 );
            waitTime = 0.8f;
            Gdx.app.log(TAG, "spawn delay: " + waitTime);
            Timer.schedule(nextEnemyTimerTask, waitTime, 0 ,0);
            Gdx.app.error(TAG,"call death");
        }

        if(!warrior.isAlive()&&warrior.waitForSpawn()){
            waitTime = 20;
            Gdx.app.log(TAG, "spawn delay: " + waitTime);
            Timer.schedule(warriorSpawn, waitTime, 0 ,0);
            Gdx.app.error(TAG,"call death");
        }

        if(!mage.isAlive()&&mage.waitForSpawn()){
            waitTime = 20;
            Gdx.app.log(TAG, "spawn delay: " + waitTime);
            Timer.schedule(mageSpawn, waitTime, 0 ,0);
            Gdx.app.error(TAG,"call death");
        }

        if(!gunner.isAlive()&&gunner.waitForSpawn()){
            waitTime = 20;
            Gdx.app.log(TAG, "spawn delay: " + waitTime);
            Timer.schedule(gunnerSpawn, waitTime, 0 ,0);
            Gdx.app.error(TAG,"call death");
        }
    }

    public void saveGame(){
        currentEnemy.saveData();
        player.saveData();
        warrior.saveData();
        mage.saveData();
        gunner.saveData();
    }

    public Player getPlayer() {
        return player;
    }

    public CompositeGameObject getWorldContainer() {
        return worldContainer;
    }

    public CompositeTextDraw getWorldTextContainer() {
        return worldTextContainer;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof HeroButtonListener){
            int index = ((HeroButtonListener) o).getHero_num();
            if (index==0){
                warriorTimer.cancel();
                Timer.instance().scheduleTask(warriorTimer,0,warrior.getSpeed());
            }
            else if (index==1){
                mageTimer.cancel();
                Timer.instance().scheduleTask(mageTimer,0,mage.getSpeed());
            }
            else if (index==2){
                gunnerTimer.cancel();
                Timer.instance().scheduleTask(gunnerTimer,0,gunner.getSpeed());
            }
        }
    }
}

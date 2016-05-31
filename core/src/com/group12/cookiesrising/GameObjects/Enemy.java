package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Health;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.State.AliveState;
import com.group12.cookiesrising.State.DeathState;
import com.group12.cookiesrising.State.State;
import com.group12.cookiesrising.util.Assets;
import com.group12.cookiesrising.util.SaveManager;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Enemy extends AbstractGameObject implements Health,Hittable {
    private Animation anim;
    public static final String TAG = Enemy.class.getName();
    public double healthPoint;

    public void setMaxHealthPoint(double maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public double maxHealthPoint;
    public boolean waitForSpawn;
    public double getAttackPoint() {
        return attackPoint;
    }
    private String name;
    public double attackPoint;
    private float speed;
    public void setMoney(double money) {
        this.money = money;
    }

    public void setAttackPoint(double attackPoint) {
        this.attackPoint = attackPoint;
    }

    public double money;
    protected State currentState,deathState,aliveState;
    private float stateTime;
    private boolean isHited;

    public EnemyUpdater getUpdater() {
        return updater;
    }

    private EnemyUpdater updater;
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getDeathState() {
        return deathState;
    }

    public State getAliveState() {
        return aliveState;
    }

    public Enemy() {
        deathState = new DeathState(this);
        aliveState = new AliveState(this);
        currentState = aliveState;
        updater = new EnemyUpdater(this);
        maxHealthPoint = 10;
        attackPoint = 1;
        money = 100;
        speed = 5;
        init();
    }

    public void init(){
        waitForSpawn = true;
        healthPoint = maxHealthPoint;
        currentState = aliveState;
        name = "Cookie Ung";
        stateTime = 0;
        isHited = false;
        isActive = true;
        setAnimation(Assets.anim_enemy01_idle);
    }

    public String getName() {
        return name;
    }

    public double getMoney(){
        return money;
    }

    public void takeDamage(double dmg){
        currentState.takeDamage(dmg);
    }

    public void changeState(){
        currentState.changeState();
    }

    public void attack(Hittable h){
        currentState.attack(h);
    }

    public void respawn(){
        currentState.respawn();
    }

    public boolean isAlive(){
        return currentState.isAlive();
    }

    public boolean waitForSpawn(){
        if(waitForSpawn){
            waitForSpawn = false;
            return true;
        }
        return waitForSpawn;
    }

    @Override
    public void update(float delta) {

        stateTime += delta;
        if(anim.equals(Assets.anim_enemy01_die)){
            if(anim.isAnimationFinished(stateTime)){
                isActive = false;
            }
        }
        if(!anim.getPlayMode().equals(Animation.PlayMode.LOOP)){
            if(anim.isAnimationFinished(stateTime)){
                setAnimation(Assets.anim_enemy01_idle);
                if(isHited){
                    isHited = false;
                }

            }
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        if(isActive) {
            batch.draw(anim.getKeyFrame(stateTime), 400, 136);
        }
    }

    @Override
    public double getHp() {
        return healthPoint;
    }

    @Override
    public double getMaxHp() {
        return maxHealthPoint;
    }
    public void setAnimation(Animation anim){
        stateTime = 0;
        this.anim = anim;
    }
    public boolean isActive(){ return isActive;}
    public void hitted(){
        isHited = true;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        if (speed<=0) speed = 1;
        this.speed = speed;
    }

    private void loadDate(){
        
    }

    public void saveData(){
        SaveManager.saveDataValue("enemy_money",getMoney());
        SaveManager.saveDataValue("enemy_attackpoint",getAttackPoint());
        SaveManager.saveDataValue("enemy_healpoint",getMaxHp());
        SaveManager.saveDataValue("enemy_speed",getSpeed());
        SaveManager.saveDataValue("enemy_name",getName());

    }
}

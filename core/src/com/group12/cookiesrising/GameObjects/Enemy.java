package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.State.AliveState;
import com.group12.cookiesrising.State.DeathState;
import com.group12.cookiesrising.State.State;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class Enemy extends AbstractGameObject{
    public static final String TAG = Enemy.class.getName();
    public double healthPoint;
    public boolean waitForSpawn;
    public double getAttackPoint() {
        return attackPoint;
    }

    public double attackPoint;
    public double money;
    protected State currentState,deathState,aliveState;

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
        init();
    }

    public void init(){
        waitForSpawn = true;
        healthPoint = 10;
        attackPoint = 1;
        money = 100;
        currentState = aliveState;
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

    public void attack(Hero h){
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

    }

    @Override
    public void draw(SpriteBatch batch) {
        if(isAlive())
        batch.draw(Assets.mon,400,136);
    }
}

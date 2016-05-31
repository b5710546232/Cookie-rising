//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Health;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.State.State;
import com.group12.cookiesrising.Upgradable;
import com.group12.cookiesrising.util.Assets;

public abstract class Hero extends AbstractGameObject implements Hittable,Health,Upgradable {

    public State currentState;

    public State getAliveState() {
        return aliveState;
    }

    public State getDeathState() {
        return deathState;
    }

    public void setAliveState(State aliveState) {
        this.aliveState = aliveState;
    }

    public void setDeathState(State deathState) {
        this.deathState = deathState;
    }

    private State aliveState,deathState;

    public double getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(double attackPoint) {
        this.attackPoint = attackPoint;
    }

    public double getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public double getMaxhealthPoint() {
        return maxhealthPoint;
    }

    public void setMaxhealthPoint(double maxhealthPoint) {
        this.maxhealthPoint = maxhealthPoint;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public double getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(double criticalRate) {
        this.criticalRate = criticalRate;
    }

    public boolean isAlive() {
        return currentState.isAlive();
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    protected double attackPoint;
    protected double healthPoint,maxhealthPoint;
    protected float speed;
    protected double criticalRate;
    protected boolean isAlive;
    private int level;

    public Hero(int x, int y) {
        super(x, y);
        this.init();
        this.healthPoint = 10.0D;
        this.maxhealthPoint = 10D;
        speed = 5;
    }

    @Override
    public void update(float delta) {

    }

    public void init() {
        healthPoint = maxhealthPoint;
        level = 1;
        isAlive = true;
    }

    public void attack(Hittable m) {
        currentState.attack(m);
    }

    public void takeDamage(double dmg) {
        currentState.takeDamage(dmg);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hero, this.position.x, this.position.y);
    }

    @Override
    public double getHp() {
        return healthPoint;
    }

    @Override
    public double getMaxHp() {
        return maxhealthPoint;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void upgradeAtk() {

    }

    @Override
    public void upgradeHeal() {

    }

    @Override
    public void upgradeCrt() {

    }

    @Override
    public int getUpgradeCost(int field) {
        return (int)(100*Math.pow(1.2,level-1));
    }

    public void upgrade(){
        upgradeAtk();
        upgradeHeal();
        upgradeCrt();
        level++;
    }

    public String getDmgText() {
        return (int)attackPoint+"";
    }

}

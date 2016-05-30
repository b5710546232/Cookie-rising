//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Health;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.Upgradable;
import com.group12.cookiesrising.util.Assets;

public class Hero extends AbstractGameObject implements Hittable,Health,Upgradable {
    protected double attackPoint;
    protected double healthPoint,maxhealthPoint;
    protected double speed;
    protected double criticalRate;
    protected boolean isAlive;
    private int level;

    public Hero(int x, int y) {
        super(x, y);
        this.init();
    }

    @Override
    public void update(float delta) {

    }

    private void init() {
        this.attackPoint = 1.0D;
        this.healthPoint = 10.0D;
        this.maxhealthPoint = 10D;
        level = 1;
        isAlive = true;
    }

    public void attack(Enemy m) {
        if(m.isAlive()) {
            Gdx.app.log(getClass().getName(),m.isAlive()+"");
            m.takeDamage(this.attackPoint);
        }

    }

    public void takeDamage(double dmg) {
        Gdx.app.log(getClass().getName(),"current HP = "+healthPoint);
        if(this.isAlive) {
            this.healthPoint -= dmg;
        }

        if(this.healthPoint <= 0.0D) {
            this.isActive = false;
            this.healthPoint = 0.0D;
        }

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

    }

}

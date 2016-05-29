//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Health;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.util.Assets;

public class Hero extends AbstractGameObject implements Hittable,Health {
    protected double attackPoint;
    protected double healthPoint,maxhealthPoint;
    protected double speed;
    protected double criticalRate;
    protected boolean isAlive;

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
    }

    public void attack(Enemy m) {
        if(m.isAlive()) {
            m.takeDamage(this.attackPoint);
        }

    }

    public void takeDamage(double dmg) {
        if(this.isActive) {
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
}

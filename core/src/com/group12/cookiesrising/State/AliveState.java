package com.group12.cookiesrising.State;

import com.badlogic.gdx.Gdx;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.gameobjects.Enemy;

/**
 * Created by nattapat on 5/26/2016 AD.
 */
public class AliveState implements State {

    Enemy e;

    public AliveState(Enemy e){
        this.e = e;
    }

    @Override
    public void attack(Hittable target) {
        target.takeDamage(e.getAttackPoint());
    }

    @Override
    public void takeDamage(double dmg) {
        e.healthPoint-=dmg;
        Gdx.app.log(e.TAG,"current hp = "+e.healthPoint);
        if(e.healthPoint<=0){
            Gdx.app.log(e.TAG,"monster die");
            changeState();
        }
    }

    @Override
    public void idle() {

    }

    @Override
    public void changeState() {
        e.setCurrentState(e.getDeathState());
    }

    @Override
    public void respawn() {

    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void update(float delta) {

    }
}

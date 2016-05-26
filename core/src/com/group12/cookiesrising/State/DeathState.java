package com.group12.cookiesrising.State;

import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.gameobjects.Enemy;

/**
 * Created by nattapat on 5/26/2016 AD.
 */
public class DeathState implements State {

    Enemy e;

    public DeathState(Enemy e){
        this.e = e;
    }

    @Override
    public void attack(Hittable target) {
        target.takeDamage(e.getAttackPoint());
    }

    @Override
    public void takeDamage(double dmg) {

    }

    @Override
    public void idle() {

    }

    @Override
    public void changeState() {
        e.setCurrentState(e.getAliveState());
    }

    @Override
    public void respawn() {
        e.init();
        changeState();
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}

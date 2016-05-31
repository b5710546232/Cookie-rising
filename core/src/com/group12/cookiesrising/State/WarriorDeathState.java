package com.group12.cookiesrising.State;

import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.gameobjects.Warrior;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by DELL on 5/31/2016.
 */
public class WarriorDeathState implements State {
    private Warrior h;

    public WarriorDeathState(Warrior h) {
        this.h = h;
    }



    @Override
    public void attack(Hittable target) {
        //You're death
    }

    @Override
    public void takeDamage(double dmg) {
        //You're death
    }

    @Override
    public void idle() {

    }

    @Override
    public void changeState() {
        h.setCurrentState(h.getAliveState());
    }

    @Override
    public void respawn() {
        h.init();
        changeState();
    }

    @Override
    public boolean isAlive() {
        return false;//YOU'RE DEATH, GODDAMN IT!!!.
    }

    @Override
    public void update(float delta) {

    }
}

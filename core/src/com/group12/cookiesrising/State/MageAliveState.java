package com.group12.cookiesrising.State;

import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.gameobjects.Mage;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by DELL on 5/31/2016.
 */
public class MageAliveState implements State{

    public MageAliveState(Mage h) {
        this.h = h;
    }

    private Mage h;

    @Override
    public void action(Hittable target) {
        if(target.isAlive()) {
            h.setAnimation(Assets.anim_mage_heal);
            target.takeDamage( -h.getAttackPoint());
        }
    }

    @Override
    public void takeDamage(double dmg) {
        h.setHealthPoint(h.getHealthPoint()-dmg);
        //h.hitted();
        //h.setAnimation(Assets.anim_enemy01_hitted);
        if(h.getHealthPoint()<=0){
            h.setHealthPoint(0);
            //h.setAnimation(Assets.anim_enemy01_die);
            changeState();
        }

        else if(h.getHealthPoint()>h.getMaxhealthPoint()){
            h.setHealthPoint(h.getMaxhealthPoint());
        }
    }

    @Override
    public void idle() {

    }

    @Override
    public void changeState() {
        h.currentState = h.getDeathState();
    }

    @Override
    public void respawn() {
        //you're not death yet.
    }

    @Override
    public boolean isAlive() {
        return true;//Yes, very.
    }

    @Override
    public void update(float delta) {

    }
}

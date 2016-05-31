package com.group12.cookiesrising.State;

import com.badlogic.gdx.Gdx;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.gameobjects.Hero;
import com.group12.cookiesrising.gameobjects.Warrior;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by DELL on 5/31/2016.
 */
public class WarriorAliveState implements State {

    private Warrior h;

    public WarriorAliveState(Warrior h) {
        this.h = h;
    }

    @Override
    public void action(Hittable target) {
        if(target.isAlive()) {
            h.setAnimation(Assets.anim_warrior_atk);
            target.takeDamage(h.getAttackPoint());
        }
    }

    @Override
    public void takeDamage(double dmg) {
        Gdx.app.log(getClass().getName(),"Take damage "+dmg+" HP = "+h.getHp());
        h.setHealthPoint(h.getHealthPoint()-dmg);
        //h.hitted();
        //h.setAnimation(Assets.anim_enemy01_hitted);
        if(h.getHealthPoint()<=0){
            h.setWaitForSpawn(true);
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

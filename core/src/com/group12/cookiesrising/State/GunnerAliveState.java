package com.group12.cookiesrising.State;

import com.badlogic.gdx.Gdx;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.gameobjects.Gunner;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by DELL on 5/31/2016.
 */
public class GunnerAliveState implements State{
    Gunner h;

    public GunnerAliveState(Gunner h) {
        this.h = h;
    }

    @Override
    public void action(Hittable target) {
        if(target.isAlive()) {
            h.setAnimation(Assets.anim_gunner_atk);
            if (h.isCritical()){
                target.takeDamage(h.getAttackPoint()*2);
            }else {
                target.takeDamage(h.getAttackPoint());
            }
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
            h.setAnimation(Assets.anim_gunner_faint);
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

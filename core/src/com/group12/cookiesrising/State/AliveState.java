package com.group12.cookiesrising.State;

import com.badlogic.gdx.Gdx;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.gameobjects.Enemy;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/26/2016 AD.
 */
public class AliveState implements State {

    Enemy e;

    public AliveState(Enemy e){
        this.e = e;
    }

    @Override
    public void action(Hittable target) {
        e.setAnimation(e.getAnim_att());
        target.takeDamage(e.getAttackPoint());
    }

    @Override
    public void takeDamage(double dmg) {
        e.healthPoint-=dmg;
        e.hitted();
        e.setAnimation(e.getAnim_hitted());
        Gdx.app.log(e.TAG,"current hp = "+e.healthPoint);
        Assets.hitted_sound.play(1.0f);
        if(e.healthPoint<=0){
            e.healthPoint = 0;
            Gdx.app.log(e.TAG,"monster die");
            e.setAnimation(e.getAnim_die());
            Assets.mon_die_sound.play(1.0f);
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

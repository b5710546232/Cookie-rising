package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;

/**
 * Created by nattapat on 6/1/2016 AD.
 */
public class EnemyDataAnimation {
    private  Animation anim_idle;
    private  Animation anim_die;
    private  Animation anim_attack;
    private  Animation anim_hiited;

    private String name;

    public EnemyDataAnimation(String name,Animation anim_idle, Animation anim_die, Animation anim_attack, Animation anim_hiited) {
        this.anim_idle = anim_idle;
        this.anim_die = anim_die;
        this.anim_attack = anim_attack;
        this.anim_hiited = anim_hiited;
    }

    public String getName() {
        return name;
    }



    public Animation getidle() {
        return anim_idle;
    }

    public Animation getDie() {
        return anim_die;
    }

    public Animation getAttack() {
        return anim_attack;
    }

    public Animation getHiited() {
        return anim_hiited;
    }
}

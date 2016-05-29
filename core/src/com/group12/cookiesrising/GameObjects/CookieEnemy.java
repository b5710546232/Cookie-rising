package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class CookieEnemy extends Enemy {
    private Animation anim;
    private boolean isHited;
    private float stateTime;
    public CookieEnemy() {
      init();

    }

    @Override
    public void init() {
        super.init();
        isHited = false;
        stateTime = 0;
        isAlive = true;
        isActive = true;
        setAniamtion(Assets.anim_enemy01_idle);
    }

    @Override
    public void takeDamage(double dmg){
//        Gdx.app.log("ag","clll");
        healthPoint -= dmg;
        if(healthPoint<0){
                isAlive = false;
                setAniamtion(Assets.anim_enemy01_die);
            }
        if(isAlive){
            isHited = true;
            setAniamtion(Assets.anim_enemy01_hitted);
        }

    }

    public void setAniamtion(Animation anim){
        stateTime = 0;
        this.anim = anim;
    }


    @Override
    public void update(float delta) {
        stateTime += delta;
        if(anim.equals(Assets.anim_enemy01_die)){
            if(anim.isAnimationFinished(stateTime)){
                isActive = false;
            }
        }
        if(!anim.getPlayMode().equals(Animation.PlayMode.LOOP)){
            if(anim.isAnimationFinished(stateTime)){
                setAniamtion(Assets.anim_enemy01_idle);
                if(isHited){
                    isHited = false;
                }

            }
        }
    }
    public void respawn(){
        init();
    }

    @Override
    public void draw(SpriteBatch batch) {
        if(isActive)
            batch.draw(anim.getKeyFrame(stateTime),400,136);
    }
}


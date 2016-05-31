package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.State.GunnerAliveState;
import com.group12.cookiesrising.State.HeroDeathState;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class Gunner extends Hero {
    private Animation anim;
    private float stateTime;
    public Gunner(int x, int y) {

        super(x, y);
        setAnimation(Assets.anim_gunner_idle);
        setAliveState(new GunnerAliveState(this));
        setDeathState(new HeroDeathState(this));
        currentState = getAliveState();
    }

    @Override
    public void update(float delta) {
        stateTime+=delta;
        if(anim != Assets.anim_gunner_idle && !anim.getPlayMode().equals(Animation.PlayMode.LOOP)){
            if(anim.isAnimationFinished(stateTime)){
                setAnimation(Assets.anim_gunner_idle);
            }
        }
    }
    public void setAnimation(Animation anim){
        stateTime = 0;
        this.anim = anim;
    }

    @Override
    public void attack(Hittable m) {
        currentState.attack(m);

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(anim.getKeyFrame(stateTime),position.x,position.y);
    }
}

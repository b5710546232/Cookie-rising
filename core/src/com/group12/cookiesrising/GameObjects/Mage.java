package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Hittable;
import com.group12.cookiesrising.State.HeroDeathState;
import com.group12.cookiesrising.State.MageAliveState;
import com.group12.cookiesrising.State.WarriorAliveState;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class Mage extends Hero {
    private Animation anim;
    private float stateTime;
    public Mage(int x, int y) {

        super(x, y);
        setAnimation(Assets.anim_mage_idle);
        setAliveState(new MageAliveState(this));
        setDeathState(new HeroDeathState(this));
        setAttackPoint(1.0);
        setSpeed(7.5F);
        currentState = getAliveState();
    }

    @Override
    public void update(float delta) {
        stateTime+=delta;
        if(anim != Assets.anim_mage_idle && !anim.getPlayMode().equals(Animation.PlayMode.LOOP)){
            if(anim.isAnimationFinished(stateTime)){
                setAnimation(Assets.anim_mage_idle);
            }
        }
    }
    public void setAnimation(Animation anim){
        stateTime = 0;
        this.anim = anim;
    }

    @Override
    public void upgradeAtk() {
        setMaxhealthPoint(getMaxhealthPoint()+1);
        setHealthPoint(getHealthPoint()+1);
        setAttackPoint(getAttackPoint()*1.2);
    }

    @Override
    public void upgradeHeal() {
        if(getLevel()%10==0)
        setSpeed(getSpeed()-0.1f);
    }

    @Override
    public void upgradeCrt() {
//never
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(anim.getKeyFrame(stateTime),position.x,position.y);
    }
}

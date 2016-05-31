package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.State.HeroDeathState;
import com.group12.cookiesrising.State.WarriorAliveState;
import com.group12.cookiesrising.util.Assets;
import com.group12.cookiesrising.util.SaveManager;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class Warrior extends Hero{

    private Animation anim;
    private float stateTime;

    public Warrior(int x, int y) {
        super(x, y);
        setAliveState(new WarriorAliveState(this));
        setDeathState(new HeroDeathState(this));
        setAttackPoint(2);
        setSpeed(10);
        setAnimation(Assets.anim_warrior_idle);
        currentState = getAliveState();
        loadData();

    }

    @Override
    public void update(float delta) {
        stateTime+=delta;
        if(anim != Assets.anim_warrior_idle && !anim.getPlayMode().equals(Animation.PlayMode.LOOP)){
            if(anim.isAnimationFinished(stateTime)){
                setAnimation(Assets.anim_warrior_idle);
            }
        }
    }
    public void setAnimation(Animation anim){
        stateTime = 0;
        this.anim = anim;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(anim.getKeyFrame(stateTime),position.x,position.y);
    }

    @Override
    public void upgradeAtk() {
        setMaxhealthPoint(getMaxhealthPoint()+2);
        setHealthPoint(getHealthPoint()+2);
        setAttackPoint(getAttackPoint()*1.2);
    }

    @Override
    public void upgradeHeal() {
        if(getLevel()%10==0)
            setSpeed(getSpeed()-0.2f);
    }

    @Override
    public void upgradeCrt() {
        if(getLevel()%10==0)
            setCriticalRate(getCriticalRate()+1);
    }
    private void loadData(){
        if(SaveManager.loadDataValue("warrior",Warrior.class)==null)return;
        Warrior temp = SaveManager.loadDataValue("warrior",Mage.class);
        level = temp.getLevel();
        attackPoint = temp.getAttackPoint();
        maxhealthPoint = temp.getMaxhealthPoint();
        speed = temp.getSpeed();


    }
    public void saveData(){
        SaveManager.saveDataValue("warrior",this);
    }
}

package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.State.HeroDeathState;
import com.group12.cookiesrising.State.MageAliveState;
import com.group12.cookiesrising.util.Assets;
import com.group12.cookiesrising.util.SaveManager;

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
        loadData();
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
        if(isAlive())
            setHealthPoint(getHealthPoint()+1);
        setAttackPoint(getAttackPoint()+Math.ceil(level/3f));
    }

    @Override
    public void upgradeHeal() {
        if(getLevel()%10==0)
        setSpeed(getSpeed()-0.2f);
        if (getSpeed()<1f) setSpeed(1f);
    }

    @Override
    public void upgradeCrt() {
//never
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(anim.getKeyFrame(stateTime),position.x,position.y);
    }

    private void loadData(){
        if(SaveManager.loadDataValue("mage_level",int.class) != null){
            level = SaveManager.loadDataValue("mage_level",int.class);
        } else{
            level = 1;
        }
        if(SaveManager.loadDataValue("mage_attackpoint",double.class)!=null){
            attackPoint = SaveManager.loadDataValue("mage_attackpoint",double.class);
        } else{
            attackPoint = 1;
        }
        if(SaveManager.loadDataValue("mage_criticalrate",double.class)!=null){
            criticalRate = SaveManager.loadDataValue("mage_criticalrate",double.class);
        } else{
            criticalRate = 1;
        }
        if(SaveManager.loadDataValue("mage_speed",double.class)!=null){
            speed = SaveManager.loadDataValue("mage_speed",double.class);
        } else{
            speed = 5f;
        }
        if(SaveManager.loadDataValue("mage_maxhealpoint",double.class)!=null){
            maxhealthPoint = SaveManager.loadDataValue("mage_maxhealpoint",double.class);
        } else{
            maxhealthPoint = 10;
        }
//        if(SaveManager.loadDataValue("mage",Mage.class)==null)return;
//        Mage temp = SaveManager.loadDataValue("mage",Mage.class);
//        level = temp.getLevel();
//        attackPoint = temp.getAttackPoint();
//        maxhealthPoint = temp.getMaxhealthPoint();
//        Gdx.app.error("hi","safe");
//        speed = temp.getSpeed();


    }
    public void saveData(){

        SaveManager.saveDataValue("mage_level",level);
        SaveManager.saveDataValue("mage_attackpoint",getAttackPoint());
        SaveManager.saveDataValue("mage_criticalrate",getCriticalRate());
        SaveManager.saveDataValue("mage_maxhealpoint",maxhealthPoint);
        SaveManager.saveDataValue("mage_speed",speed);
    }

    @Override
    public void init() {
        setAnimation(Assets.anim_mage_idle);
        super.init();
    }
}

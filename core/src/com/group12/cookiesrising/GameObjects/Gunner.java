package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.State.GunnerAliveState;
import com.group12.cookiesrising.State.HeroDeathState;
import com.group12.cookiesrising.util.Assets;
import com.group12.cookiesrising.util.SaveManager;

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
        setAttackPoint(1);
        setSpeed(3);
        currentState = getAliveState();
        loadData();
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
    public void draw(SpriteBatch batch) {
        batch.draw(anim.getKeyFrame(stateTime),position.x,position.y);
    }

    @Override
    public void upgradeAtk() {
        setMaxhealthPoint(getMaxhealthPoint()+3);
        if(isAlive())
            setHealthPoint(getHealthPoint()+1);
        setSpeed(getSpeed()*0.95f);
        //setSpeed(0.05f);
        if (getSpeed()<=0.05f) setSpeed(0.05f);
    }

    @Override
    public void upgradeHeal() {
        if(getLevel()%2==0)
            setAttackPoint(getAttackPoint()+Math.ceil(level/5f));
    }

    @Override
    public void upgradeCrt() {
        if(getLevel()%2==0)
            setCriticalRate(getCriticalRate()+1);
    }
    private void loadData(){
        if(SaveManager.loadDataValue("gunner_level",int.class) != null){
            level = SaveManager.loadDataValue("gunner_level",int.class);
        } else{
            level = 1;
        }
        if(SaveManager.loadDataValue("gunner_attackpoint",double.class)!=null){
            attackPoint = SaveManager.loadDataValue("gunner_attackpoint",double.class);
        } else{
            attackPoint = 1;
        }
        if(SaveManager.loadDataValue("gunner_criticalrate",double.class)!=null){
            criticalRate = SaveManager.loadDataValue("gunner_criticalrate",double.class);
        } else{
            criticalRate = 1;
        }
        if(SaveManager.loadDataValue("gunner_speed",double.class)!=null){
            speed = SaveManager.loadDataValue("gunner_speed",double.class);
        } else{
            speed = 3;
        }
        if(SaveManager.loadDataValue("gunner_maxhealpoint",double.class)!=null){
            maxhealthPoint = SaveManager.loadDataValue("gunner_maxhealpoint",double.class);
        } else{
            maxhealthPoint = 10;
        }
//        if(SaveManager.loadDataValue("gunner",Warrior.class)==null)return;
//        Warrior temp = SaveManager.loadDataValue("gunner",Mage.class);
//        level = temp.getLevel();
//        attackPoint = temp.getAttackPoint();
//        maxhealthPoint = temp.getMaxhealthPoint();
//        speed = temp.getSpeed();


    }
    public void saveData(){
        SaveManager.saveDataValue("gunner_level",level);
        SaveManager.saveDataValue("gunner_attackpoint",getAttackPoint());
        SaveManager.saveDataValue("gunner_criticalrate",getCriticalRate());
        SaveManager.saveDataValue("gunner_maxhealpoint",maxhealthPoint);
        SaveManager.saveDataValue("gunner_speed",speed);
//        SaveManager.saveDataValue("gunner",this);
    }

    @Override
    public void init() {
        super.init();
        setAnimation(Assets.anim_gunner_idle);
    }
}

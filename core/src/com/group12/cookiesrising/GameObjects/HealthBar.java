package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Health;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class HealthBar extends AbstractGameObject {
    private Health health;
    private float x,y;
    public HealthBar(Health health,float x,float y){
        this.health = health;
        this.x =x;
        this.y=y;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hp_bg,x,y);
        batch.draw(Assets.hp_knob,x+5,y+5,(float)(113*(health.getHp()/health.getMaxHp())),14);
    }
}

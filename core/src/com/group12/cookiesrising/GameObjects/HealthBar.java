package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Health;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class HealthBar extends AbstractGameObject {
    private Health health;
    private float x,y,ratio;
    public HealthBar(Health health,float x,float y,float ratio){
        this.health = health;
        this.x =x;
        this.y=y;
        this.ratio = ratio;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hp_bg,x,y,123/ratio,24/ratio);
        batch.draw(Assets.hp_knob,x+5/ratio,y+5/ratio,(float)(113*(health.getHp()/health.getMaxHp()))/ratio,14/ratio);
    }
}

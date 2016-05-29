package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Health;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class HealthBar extends AbstractGameObject {
    private Health health;
    public HealthBar(Health health){
        this.health = health;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hp_bg,258.5f,318f);
        batch.draw(Assets.hp_knob,263.5f,323f,(float)(113*(health.getHp()/health.getMaxHp())),14);
    }
}

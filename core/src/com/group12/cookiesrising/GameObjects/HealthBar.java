package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/29/2016 AD.
 */
public class HealthBar extends AbstractGameObject {
    private Enemy enemy;
    public HealthBar(Enemy e){
        this.enemy =e;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.hp_bg,300,300);
        batch.draw(Assets.hp_knob,300,300);
    }
}

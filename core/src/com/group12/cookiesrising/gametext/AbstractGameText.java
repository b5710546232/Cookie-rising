package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by nattapat on 5/13/2016 AD.
 */
public abstract class AbstractGameText {
    public abstract void update(float delta);
    public abstract void draw(BitmapFont font , SpriteBatch batch);
    public boolean isActive = false;

}

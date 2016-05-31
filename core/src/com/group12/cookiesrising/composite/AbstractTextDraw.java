package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public abstract class AbstractTextDraw implements Disposable{
    public  abstract  void draw(SpriteBatch batch);
    public  abstract  void update(float delta);
}

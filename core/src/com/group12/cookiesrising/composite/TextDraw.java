package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.group12.cookiesrising.gametext.AbstractGameText;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class TextDraw implements Drawable, Disposable{
    public BitmapFont font;
    private Array<AbstractGameText> list;
    public TextDraw(BitmapFont font) {
        this.font = font;
        list = new Array<AbstractGameText>() {};
    }

    public void add(AbstractGameText child){
        list.add(child);
    }

    public void update(float delta){
        for(AbstractGameText t :list){
            t.update(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(AbstractGameText t:list){
            t.draw(font,batch);
        }
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}

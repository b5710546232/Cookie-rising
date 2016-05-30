package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class CompositeTextDraw implements Disposable,Drawable {

    private Array<TextDraw> children;

    public CompositeTextDraw() {
        children = new Array<TextDraw>();
    }
    public void add(TextDraw child){
        children.add(child);
    }

    @Override
    public void dispose() {
        for(TextDraw child:children){
            child.dispose();
        }
    }

    public void update(float delta){
        for(TextDraw child:children){
            child.update(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(TextDraw child:children){
            child.draw(batch);
        }
    }


}

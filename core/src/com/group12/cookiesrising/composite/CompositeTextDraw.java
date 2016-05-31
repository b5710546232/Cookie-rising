package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class CompositeTextDraw extends AbstractTextDraw {

    private Array<AbstractTextDraw> children;

    public CompositeTextDraw() {
        children = new Array<AbstractTextDraw>();
    }
    public void add(TextDraw child){
        children.add(child);
    }

    @Override
    public void dispose() {
        for(AbstractTextDraw child:children){
            child.dispose();
        }
    }
    @Override
    public void update(float delta){
        for(AbstractTextDraw child:children){
            child.update(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(AbstractTextDraw child:children){
            child.draw(batch);
        }
    }


}

package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.gametext.ITextDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 5/10/2016 AD.
 */
public class CompositeTextObjectDrawble implements ITextDrawable {
    private List<ITextDrawable> children;
    public CompositeTextObjectDrawble() {
        this.children = new ArrayList<ITextDrawable>();
    }

    public void add(ITextDrawable child){
        children.add(child);
    }

    public void remove(ITextDrawable child){
        children.remove(child);
    }


    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        for(ITextDrawable child : children){
            child.draw(font,batch);
        }
    }
}

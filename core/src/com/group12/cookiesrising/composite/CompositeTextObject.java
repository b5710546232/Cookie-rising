package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.gametext.AbstractGameText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 5/10/2016 AD.
 */
public class CompositeTextObject extends AbstractGameText {
    private List<AbstractGameText> children;
    public CompositeTextObject() {
        this.children = new ArrayList<AbstractGameText>();
    }

    public void add(AbstractGameText child){
        children.add(child);
    }

    public void remove(AbstractGameText child){
        children.remove(child);
    }


    @Override
    public void update(float delta) {
        for(AbstractGameText child: children){
            child.update(delta);
        }
    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        for(AbstractGameText child : children){
            child.draw(font,batch);
        }
    }
}

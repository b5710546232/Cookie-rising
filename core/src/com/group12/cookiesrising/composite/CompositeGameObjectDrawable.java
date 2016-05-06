package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.gameobjects.IGameObjectDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 5/6/2016 AD.
 *
 * CompositeGameObjectDrawable
 *
 * use Composite Pattern for draw every child
 * and can add and remove child of IGameObjectDrawble.
 */
public class CompositeGameObjectDrawable implements IGameObjectDrawable{
    private List<IGameObjectDrawable> children;

    public CompositeGameObjectDrawable() {
        this.children = new ArrayList<IGameObjectDrawable>();
    }


    @Override
    public void draw(SpriteBatch batch) {
        for(IGameObjectDrawable child:children){
            child.draw(batch);
        }
    }

    public void add(IGameObjectDrawable child){
        children.add(child);
    }

    public void remove(IGameObjectDrawable child){
        children.remove(child);
    }

    public IGameObjectDrawable get(CompositeGameObjectDrawable child){
        int index = children.indexOf(child);
        return children.get(index);
    }
}


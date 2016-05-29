package com.group12.cookiesrising.composite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.gameobjects.AbstractGameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 5/6/2016 AD.
 *
 * CompositeGameObject
 *
 * use Composite Pattern for draw every child
 * and can add and remove child of IGameObjectDrawble.
 */
public class CompositeGameObject extends AbstractGameObject{


    public CompositeGameObject() {
        this.children = new ArrayList<AbstractGameObject>();
    }

    private List<AbstractGameObject> children;


    @Override
    public void draw(SpriteBatch batch) {
        for(AbstractGameObject child:children){
            child.draw(batch);
        }
    }
    @Override
    public void update(float delta) {
        for(AbstractGameObject child:children){
            child.update(delta);
        }
    }

    public void add(AbstractGameObject child){
        children.add(child);
    }


    public void remove(AbstractGameObject child){
        children.remove(child);
    }

    public AbstractGameObject get(AbstractGameObject child){
        int index = children.indexOf(child);
        return children.get(index);
    }
}


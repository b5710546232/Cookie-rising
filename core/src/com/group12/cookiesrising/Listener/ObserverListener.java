package com.group12.cookiesrising.Listener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Observable;

/**
 * Created by YukiReii on 28/5/2559.
 */
public class ObserverListener extends Observable{
    public final String TAG = this.getClass().getName();
    private ClickListener clickListener;
    private String messege;
    public ObserverListener(final String messege){
        this.messege = messege;
        clickListener = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.log(TAG,messege);
                setChanged();
                notifyObservers(this);
            }
        };
    }
    public ClickListener getListener(){
        return clickListener;
    }
}

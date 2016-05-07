package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public class DamageText extends Actor implements  IGameObjectDrawable , Disposable{
    public static final String TAG = DamageText.class.getName();
    private BitmapFont font;
    private Vector2 position;
    private String text;
    private boolean isAlive = false;
    private float limit = 0;

    public DamageText(String s){
        text = s;
        position = new Vector2(400,100);
        font = new BitmapFont();
    }

    public void init(){
        isAlive = true;
        limit = 0;
    }

    @Override
    public void draw(SpriteBatch batch) {
        update();
        if(isAlive)
        font.draw(batch,text,position.x,position.y);
    }

    private void update() {
        limit += Gdx.graphics.getDeltaTime();
        if(limit>=1){
            isAlive = false;
        }
        position.y += 100*Gdx.graphics.getDeltaTime();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}

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
    public boolean isActive = false;
    private float limit = 0;

    public DamageText(){
        text = "";
        position = new Vector2(0,0);
        font = new BitmapFont();
    }

    public void init(String text,int x , int y){
        this.text = text;
        isActive = true;
        limit = 0;
        position.x = x;
        position.y = y;
    }

    public void reset(){
        position.x = 0;
        position.y = 0;
        isActive = false;
    }

    @Override
    public void draw(SpriteBatch batch) {
        update();
        if(isActive)font.draw(batch,text,position.x,position.y);
    }

    private void update() {
        limit += Gdx.graphics.getDeltaTime();
        if(limit>=1){
            reset();
        }
        position.y += 100*Gdx.graphics.getDeltaTime();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}

package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public class DamageText extends AbstractGameText {
    public static final String TAG = DamageText.class.getName();
    private Vector2 position;
    private String text;
    public boolean isActive = false;
    private float limit = 0;

    public DamageText(){
        text = "";
        position = new Vector2(0,0);
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
    public void update(float delta) {
        limit += delta;
        if(limit>=1){
            reset();
        }
        position.y += 100*delta;
    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        if(isActive)font.draw(batch,text,position.x,position.y);
    }
}

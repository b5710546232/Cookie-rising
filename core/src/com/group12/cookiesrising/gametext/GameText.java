package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public class GameText extends AbstractGameText{
    public static final String TAG = GameText.class.getName();
    protected Vector2 position;
    protected String text;
    protected boolean isActive = false;
    protected float limit = 0;
    protected int speed = 100;

    public GameText(){
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
        position.y += speed*delta;
    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        if(isActive){
            font.draw(batch,text,position.x,position.y);
        }
    }

    protected void setDefualt(BitmapFont font){
        font.getData().setScale(1,1);
        font.setColor(font.getColor().r,font.getColor().g,font.getColor().b,1);
    }
}

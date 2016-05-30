package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class CriticalDamageText extends GameText{
    private float alpha = 1;
    public CriticalDamageText() {
        super();
        this.speed = 98;
    }

    @Override
    public void init(String text, int x, int y) {
        super.init(text, x, y);
        alpha = 1;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        alpha-=delta/1.5;
    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        if(isActive){
            font.setColor(font.getColor().r,font.getColor().g,font.getColor().b,alpha);
            font.getData().setScale(2,2);
            font.draw(batch,text,position.x,position.y);
            setDefualt(font);
        }
    }



}

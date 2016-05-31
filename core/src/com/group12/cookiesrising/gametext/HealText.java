package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by YukiReii on 31/5/2559.
 */
public class HealText extends DamageText{
    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        if(isActive){
            font.setColor(Color.GREEN);
            font.setColor(font.getColor().r,font.getColor().g,font.getColor().b,alpha);
            font.draw(batch,text,position.x,position.y);
            setDefualt(font);
            font.setColor(Color.WHITE);
        }
    }
}

package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class DamageText extends GameText {
    private float alpha = 1;
    public DamageText() {
        super();
    }

    @Override
    public void init(String text, int x, int y) {
        super.init(text, x, y);
        alpha = 1;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        alpha-=delta;
    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        if(isActive){
            font.setColor(font.getColor().r,font.getColor().g,font.getColor().b,alpha);
            font.draw(batch,text,position.x,position.y);
            setDefualt(font);
        }
    }
}

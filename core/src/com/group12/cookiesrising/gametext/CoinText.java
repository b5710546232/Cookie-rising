package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by YukiReii on 28/5/2559.
 */
public class CoinText extends AbstractGameText{
    private double value;
    public CoinText(double value){
        this.value = value;
    }
    @Override
    public void update(float delta) {

    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        font.draw(batch,Double.toString(value),52,339);
    }
}

package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by YukiReii on 30/5/2559.
 */
public class HeroLevelText extends AbstractGameText{

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        String h3 = Integer.toString(0);
        String h2 = Integer.toString(0);
        String h1 = Integer.toString(0);
        font.draw(batch,h3,98-(h3.length()-1)*5,40);
        font.draw(batch,h2,188-(h2.length()-1)*5,40);
        font.draw(batch,h1,278-(h1.length()-1)*5,40);
    }
}

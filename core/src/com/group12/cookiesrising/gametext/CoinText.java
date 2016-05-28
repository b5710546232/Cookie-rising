package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Player;

/**
 * Created by YukiReii on 28/5/2559.
 */
public class CoinText extends AbstractGameText{
    private Player player;
    public CoinText(Player player){
        this.player = player;
    }
    @Override
    public void update(float delta) {

    }


    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        font.draw(batch,Double.toString(player.getMoney()),52,339);
    }
}

package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Player;

/**
 * Created by YukiReii on 30/5/2559.
 */
public class HeroLevelText extends AbstractGameText{
    private Player player;
    public HeroLevelText(Player player){
        this.player = player;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        String h3 = Integer.toString(player.getParty().getHeroList().get(2).getLevel());
        String h2 = Integer.toString(player.getParty().getHeroList().get(1).getLevel());
        String h1 = Integer.toString(player.getParty().getHeroList().get(0).getLevel());
        font.draw(batch,h3,98-(h3.length()-1)*5,50);
        font.draw(batch,h2,188-(h2.length()-1)*5,50);
        font.draw(batch,h1,278-(h1.length()-1)*5,50);
    }
}

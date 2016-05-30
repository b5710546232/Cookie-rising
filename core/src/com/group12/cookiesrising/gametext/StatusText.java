package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Player;

/**
 * Created by YukiReii on 28/5/2559.
 */
public class StatusText extends AbstractGameText{
    private Player player;

    public StatusText(Player player){
        this.player = player;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        String atk = Integer.toString(player.getAttackPoint());
        String heal = Integer.toString(player.getHealPoint());
        String cri = Integer.toString(player.getCriticalRate());
        font.draw(batch,atk,380-(atk.length()-1)*5,50);
        font.draw(batch,heal,470-(heal.length()-1)*5,50);
        font.draw(batch,cri,560-(cri.length()-1)*5,50);
    }
}

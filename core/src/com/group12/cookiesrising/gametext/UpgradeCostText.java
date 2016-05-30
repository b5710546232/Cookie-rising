package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.Player;

/**
 * Created by YukiReii on 30/5/2559.
 */
public class UpgradeCostText extends AbstractGameText{
    private Player player;
    public UpgradeCostText(Player player){
        this.player = player;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        String h3cost = Integer.toString(player.getParty().getHeroList().get(2).getUpgradeCost(0));
        String h2cost = Integer.toString(player.getParty().getHeroList().get(1).getUpgradeCost(0));
        String h1cost = Integer.toString(player.getParty().getHeroList().get(0).getUpgradeCost(0));
        String atkcost = Integer.toString(player.getUpgradeCost(Player.ATK));
        String healcost = Integer.toString(player.getUpgradeCost(Player.HEAL));
        String cricost = Integer.toString(player.getUpgradeCost(Player.CRI));
        font.draw(batch,h3cost,65,33);
        font.draw(batch,h2cost,155,33);
        font.draw(batch,h1cost,245,33);
        font.draw(batch,atkcost,365,33);
        font.draw(batch,healcost,455,33);
        font.draw(batch,cricost,545,33);
    }
}

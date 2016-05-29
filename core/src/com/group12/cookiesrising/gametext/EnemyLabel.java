package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.gameobjects.Enemy;

/**
 * Created by YukiReii on 29/5/2559.
 */
public class EnemyLabel extends AbstractGameText {
    private Enemy enemy;
    public EnemyLabel(Enemy enemy){
        this.enemy =enemy;
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        font.draw(batch,enemy.getName(),320f-enemy.getName().length()/2f*7.5f,318f);
    }
}

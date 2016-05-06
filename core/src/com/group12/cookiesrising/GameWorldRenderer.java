package com.group12.cookiesrising;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 * WorldRenderer
 */
public class GameWorldRenderer {
    private final GameWorld world;

    public GameWorldRenderer(GameWorld world) {
        this.world = world;
    }

    public void render(float delta, SpriteBatch batch){
        batch.draw(Assets.mon,450,200);
    }

}

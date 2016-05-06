package com.group12.cookiesrising.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.group12.cookiesrising.GameWorld;
import com.group12.cookiesrising.GameWorldRenderer;
import com.group12.cookiesrising.util.Assets;
import com.group12.cookiesrising.util.Constants;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class GamePlayScreen extends ScreenAdapter {

    public static final String TAG = GamePlayScreen.class.getName();
    private  Game game;
    private SpriteBatch batch;
    private ExtendViewport viewport;

    private GameWorld world;
    private GameWorldRenderer renderer;


    public GamePlayScreen(Game game) {
        this.game = game;
        world = new GameWorld();
        renderer = new GameWorldRenderer(world);

    }

    @Override
    public void render(float delta) {
        //Apply viewport
        viewport.apply();
        testInput();
        // update world
        world.update(delta);

        //render
        //clearing the screen
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        // projection batch to camera.
        // start draw sprite
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.enableBlending();
        batch.begin();
        batch.draw(Assets.bg,0,0);
        renderer.render(delta,batch);

        batch.end();

    }

    private void testInput() {
        if(Gdx.input.justTouched()){
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            Vector3 inputs = new Vector3(x, y, 0);
            viewport.getCamera().unproject(inputs);
            //Log the postion x and y when touch.
            Gdx.app.log(TAG,"touch x = "+inputs.x+"  ||  "+"touch y = "+inputs.y);
            if(inputs.x <= 640/2){
                Gdx.app.error(TAG,"touch left side");
            }
            else{
                Gdx.app.error(TAG,"touch right side");
            }

        }
    }

    @Override
    public void show() {
        super.show();
        // TODO Init the Assets
        Assets.instance.init();

        batch = new SpriteBatch();
        viewport = new ExtendViewport(Constants.VIEWPORT_WIDTH
                , Constants.VIEWPORT_HEIGHT);

    }

    @Override
    public void resize(int width, int height) {
        // update the viewport
        viewport.update(width,height,true);
    }

    @Override
    public void dispose() {
        //dispose
        Assets.instance.dispose();
        batch.dispose();
    }

}

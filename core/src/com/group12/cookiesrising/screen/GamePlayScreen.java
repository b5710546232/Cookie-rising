package com.group12.cookiesrising.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.group12.cookiesrising.gameworld.GameWorld;
import com.group12.cookiesrising.gameworld.GameWorldRenderer;
import com.group12.cookiesrising.util.Assets;
import com.group12.cookiesrising.util.Constants;

/**
 * Created by nattapat on 5/6/2016 AD.
 */
public class GamePlayScreen extends ScreenAdapter {

    public static final String TAG = GamePlayScreen.class.getName();
    private Game game;
    private GameWorld world;
    private GameWorldRenderer renderer;

    public GamePlayScreen(Game game) {
        super();
        this.game = game;
        world = new GameWorld();
        renderer = new GameWorldRenderer(world.getWorldContainer(),world.getWorldTextContainer());

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        testInput();
        // update world
        world.update(delta);
        renderer.render();
    }

    private void testInput() {
        if(Gdx.input.justTouched()){
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            Vector3 inputs = new Vector3(x, y, 0);
            renderer.getCamera().unproject(inputs);
            //Log the postion x and y when touch.
//            Gdx.app.log(TAG,"touch x = "+inputs.x+"  ||  "+"touch y = "+inputs.y);
            if(inputs.x <= 640/2){
//                Gdx.app.error(TAG,"touch left side");
            }
            else{
//                Gdx.app.error(TAG,"touch right side");
                world.playerAttack();
            }

        }
    }

    @Override
    public void show() {
        // this method will be called when this screen becomes the current screen for a Game.
        super.show();
        Assets.instance.init();
        renderer.init();

    }

    @Override
    public void resize(int width, int height) {
        // update the viewport
        super.resize(width,height);
        renderer.resize(width,height);
    }

    @Override
    public void dispose() {
        //dispose
        super.dispose();
        Assets.instance.dispose();
        renderer.dispose();
    }

}

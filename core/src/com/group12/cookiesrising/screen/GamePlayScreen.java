package com.group12.cookiesrising.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
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
    private Stage stage;
    private ProgressBar progressBar;
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
        stage.act(delta);
        stage.draw();
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
                Gdx.app.log("Progress",progressBar.getValue()+"");
                progressBar.setValue(progressBar.getValue()-10);
            }

        }
    }

    @Override
    public void show() {
        // this method will be called when this screen becomes the current screen for a Game.
        stage = new Stage(new StretchViewport(Constants.VIEWPORT_WIDTH,
                Constants.VIEWPORT_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        super.show();
        Assets.instance.init();
        renderer.init();
        progressBar = new ProgressBar(0,100,0.7f,false,new ProgressBar.ProgressBarStyle(new TextureRegionDrawable(Assets.atk),new TextureRegionDrawable(Assets.atk)));
        progressBar.setPosition(200,200);
        progressBar.setValue(100);
        stage.addActor(progressBar);
        initButton();
    }
    private void initButton(){
        ImageButton hero3Button = new ImageButton(new TextureRegionDrawable(Assets.atk));
        hero3Button.setPosition(10,10);
        stage.addActor(hero3Button);
        ImageButton hero2Button = new ImageButton(new TextureRegionDrawable(Assets.atk));
        hero2Button.setPosition(100,10);
        stage.addActor(hero2Button);
        ImageButton hero1Button = new ImageButton(new TextureRegionDrawable(Assets.atk));
        hero1Button.setPosition(190,10);
        stage.addActor(hero1Button);
        ImageButton playerButton = new ImageButton(new TextureRegionDrawable(Assets.atk));
        playerButton.setPosition(280,10);
        stage.addActor(playerButton);
        ImageButton atkButton = new ImageButton(new TextureRegionDrawable(Assets.atk));
        atkButton.setPosition(370,10);
        stage.addActor(atkButton);
        ImageButton healButton = new ImageButton(new TextureRegionDrawable(Assets.atk));
        healButton.setPosition(460,10);
        stage.addActor(healButton);
        ImageButton criButton = new ImageButton(new TextureRegionDrawable(Assets.atk));
        criButton.setPosition(550,10);
        stage.addActor(criButton);
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

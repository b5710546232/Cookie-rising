package com.group12.cookiesrising.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.group12.cookiesrising.Listener.AttackButtonListener;
import com.group12.cookiesrising.Listener.CriticalButtonListener;
import com.group12.cookiesrising.Listener.HealButtonListener;
import com.group12.cookiesrising.Listener.HeroButtonListener;
import com.group12.cookiesrising.Listener.ObservableListener;
import com.group12.cookiesrising.gameobjects.EnemyData;
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
        renderer.renderObject();
        stage.act(delta);
        stage.draw();
        renderer.renderText();
    }

    @Override
    public void pause() {
        super.pause();
        EnemyData.instance.clearAnim();
        world.saveGame();
    }

    private void testInput() {
        if(Gdx.input.justTouched()){
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            Vector3 inputs = new Vector3(x, y, 0);
            renderer.getCamera().unproject(inputs);
            //Log the postion x and y when touch.
//            Gdx.app.log(TAG,"touch x = "+inputs.x+"  ||  "+"touch y = "+inputs.y);
            if (inputs.y>=136){
                if(inputs.x <= 640/2){
                    world.playerHeal();
                }else {
                    world.playerAttack();
                }
            }
        }
    }

    @Override
    public void show() {
        // this method will be called when this screen becomes the current screen for a Game.
        Assets.instance.init();
        Assets.bgm.play();
        stage = new Stage(new StretchViewport(Constants.VIEWPORT_WIDTH,
                Constants.VIEWPORT_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        super.show();
        renderer.init();
        initButton();
    }
    private void initButton(){
        ObservableListener atkLis = new AttackButtonListener();
        ObservableListener healLis = new HealButtonListener();
        ObservableListener criLis = new CriticalButtonListener();
        ObservableListener hero1Lis = new HeroButtonListener(0);
        ObservableListener hero2Lis = new HeroButtonListener(1);
        ObservableListener hero3Lis = new HeroButtonListener(2);
        atkLis.addObserver(world.getPlayer());
        healLis.addObserver(world.getPlayer());
        criLis.addObserver(world.getPlayer());
        hero1Lis.addObserver(world.getPlayer());
        hero2Lis.addObserver(world.getPlayer());
        hero3Lis.addObserver(world.getPlayer());
        hero1Lis.addObserver(world);
        hero2Lis.addObserver(world);
        hero3Lis.addObserver(world);
        ImageButton hero3Button = new ImageButton(Assets.button_h3_up,Assets.button_h3_down);
        hero3Button.addListener(hero3Lis.getListener());
        hero3Button.setPosition(40,10);
        stage.addActor(hero3Button);
        ImageButton hero2Button = new ImageButton(Assets.button_h2_up,Assets.button_h2_down);
        hero2Button.addListener(hero2Lis.getListener());
        hero2Button.setPosition(130,10);
        stage.addActor(hero2Button);
        ImageButton hero1Button = new ImageButton(Assets.button_h1_up,Assets.button_h1_down);
        hero1Button.addListener(hero1Lis.getListener());
        hero1Button.setPosition(220,10);
        stage.addActor(hero1Button);

        ImageButton atkButton = new ImageButton(Assets.button_atk_up,Assets.button_atk_down);
        atkButton.addListener(atkLis.getListener());
        atkButton.setPosition(340,10);
        stage.addActor(atkButton);
        ImageButton healButton = new ImageButton(Assets.button_heal_up,Assets.button_heal_down);
        healButton.addListener(healLis.getListener());
        healButton.setPosition(430,10);
        stage.addActor(healButton);
        ImageButton criButton = new ImageButton(Assets.button_cri_up,Assets.button_cri_down);
        criButton.addListener(criLis.getListener());
        criButton.setPosition(520,10);
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
        stage.dispose();
    }
}

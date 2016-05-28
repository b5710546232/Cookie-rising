package com.group12.cookiesrising.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.group12.cookiesrising.composite.CompositeGameObjectDrawable;
import com.group12.cookiesrising.composite.CompositeTextObjectDrawable;
import com.group12.cookiesrising.util.Assets;

/**
 * Created by nattapat on 5/6/2016 AD.
 * WorldRenderer
 *
 * render all the sprite in game world.
 */
public class GameWorldRenderer  implements Disposable{

    private CompositeGameObjectDrawable worldContainer;
    private CompositeTextObjectDrawable worldTextContainer;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;
    private StretchViewport viewport;
    /**
     * Constructor
     * @param worldContainer - CompositeGameObjectDrawable of world that contain every gameobject world.
     * */

    public GameWorldRenderer(CompositeGameObjectDrawable worldContainer, CompositeTextObjectDrawable worldTextContainer) {
        this.worldContainer = worldContainer;
        this.worldTextContainer = worldTextContainer;
    }

    /**
     * draw all texture in world.
     * */
    public void render(){

        //Draw a black bg.prevents flickering.
        Gdx.gl.glClearColor(1, 0, 0, 1);
        //// Clears the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        //Apply viewport
        viewport.apply();


        batch.setProjectionMatrix(camera.combined);
        batch.enableBlending();

        batch.begin();

        worldContainer.draw(batch);
        worldTextContainer.draw(font,batch);
        batch.end();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
    /**
     * initial all
     * */
    public void init() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(640
                , 360,camera);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        font = new BitmapFont();

    }

    /**
     * resize by update the viewport.
     * */
    public void resize(int width, int height) {
        // update the viewport
        viewport.update(width,height,true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}

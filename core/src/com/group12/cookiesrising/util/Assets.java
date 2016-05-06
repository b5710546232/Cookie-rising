package com.group12.cookiesrising.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by nattapat on 5/6/2016 AD.
 * Assets class
 * provide all assets of this project
 *
 * This will use Singleton pattern
 *
 */
public class Assets implements Disposable{

    public static final String TAG = Assets.class.getName();

    // singleton
    public static final Assets instance = new Assets();
    public static  Texture mon;
    public static Texture bg;
    public static Texture hero;

    private Assets() {}

    /**
     *
     * initialize the Assets
     *
     * */
    public void init(){
        load();
    }


    /**
     * load all assets.
     * */
    private void load() {
        hero = new Texture(Gdx.files.internal("hero.png"));
        mon = new Texture(Gdx.files.internal("mon.png"));
        bg = new Texture(Gdx.files.internal("bg.png"));
    }


    @Override
    public void dispose() {

    }
}

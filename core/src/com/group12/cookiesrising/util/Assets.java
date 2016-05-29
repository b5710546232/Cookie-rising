package com.group12.cookiesrising.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
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
    public static Texture coin;
    public static Texture hero_sheet;
    public static Texture hp_bg,hp_knob;
    public static TextureRegion atk,cri,heal,h1b,h2b,h3b;
    public static Array<TextureRegion> hero_sheet_textureRegions;

    public static Animation anim_warrior_idle;
    public static Animation anim_warrior_atk;
    public static Animation anim_mage_heal;
    public static Animation anim_mage_idle;
    public static Animation anim_gunner_idle;
    public static Animation anim_gunner_atk;

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
        loadHero();
        hero = new Texture(Gdx.files.internal("hero.png"));
        mon = new Texture(Gdx.files.internal("mon.png"));
        bg = new Texture(Gdx.files.internal("bg.png"));
        coin = new Texture(Gdx.files.internal("coin.png"));
        hp_bg = new Texture(Gdx.files.internal("hp_status_bar.png"));
        hp_knob = new Texture(Gdx.files.internal("hp_green_bar.png"));
        atk = new TextureRegion(new Texture(Gdx.files.internal("atk_button.png")));
        heal = new TextureRegion(new Texture(Gdx.files.internal("heal_button.png")));
        cri = new TextureRegion(new Texture(Gdx.files.internal("cri_button.png")));
        h1b = new TextureRegion(new Texture(Gdx.files.internal("hero01_button.png")));
        h2b = new TextureRegion(new Texture(Gdx.files.internal("hero02_button.png")));
        h3b = new TextureRegion(new Texture(Gdx.files.internal("hero03_button.png")));
    }

    private void loadHero() {
        splitHeroSheetToArray();
        setWarriorAnimate();
        setMageAnimate();
        setGunnerAnimate();

    }

    private void setGunnerAnimate() {
        TextureRegion[] gunner_reg_idle = new TextureRegion[4];
        gunner_reg_idle[0] = hero_sheet_textureRegions.get(0);
        gunner_reg_idle[1] = hero_sheet_textureRegions.get(1);
        gunner_reg_idle[2] = hero_sheet_textureRegions.get(2);
        gunner_reg_idle[3] = hero_sheet_textureRegions.get(1);
        anim_gunner_idle = new Animation(0.25f,gunner_reg_idle);
        anim_gunner_idle.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] gunner_reg_atk = new TextureRegion[1];
        gunner_reg_atk[0] = hero_sheet_textureRegions.get(3);
        anim_gunner_atk = new Animation(0.25f,gunner_reg_atk);
        anim_gunner_atk.setPlayMode(Animation.PlayMode.NORMAL);
    }

    private void setMageAnimate() {
        TextureRegion[] mage_reg_idle = new TextureRegion[4];
        mage_reg_idle[0] = hero_sheet_textureRegions.get(8);
        mage_reg_idle[1] = hero_sheet_textureRegions.get(9);
        mage_reg_idle[2] = hero_sheet_textureRegions.get(10);
        mage_reg_idle[3] = hero_sheet_textureRegions.get(9);
        anim_mage_idle = new Animation(0.25f,mage_reg_idle);
        anim_mage_idle.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] mage_reg_heal = new TextureRegion[1];
        mage_reg_heal[0] = hero_sheet_textureRegions.get(11);
        anim_mage_heal = new Animation(0.25f,mage_reg_heal);
        anim_mage_heal.setPlayMode(Animation.PlayMode.NORMAL);
    }

    private void setWarriorAnimate() {
        TextureRegion[] wariror_reg_idle = new TextureRegion[4];
        wariror_reg_idle[0] = hero_sheet_textureRegions.get(4);
        wariror_reg_idle[1] = hero_sheet_textureRegions.get(5);
        wariror_reg_idle[2] = hero_sheet_textureRegions.get(6);
        wariror_reg_idle[3] = hero_sheet_textureRegions.get(5);
        anim_warrior_idle = new Animation(0.25f,wariror_reg_idle);
        anim_warrior_idle.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] wariror_reg_atk = new TextureRegion[1];
        wariror_reg_atk[0] = hero_sheet_textureRegions.get(7);
        anim_warrior_atk = new Animation(0.25f,wariror_reg_atk);
        anim_warrior_atk.setPlayMode(Animation.PlayMode.NORMAL);

    }

    private void splitHeroSheetToArray() {
        hero_sheet = new Texture(Gdx.files.internal("hero_sprite_sheet.png"));
        hero_sheet_textureRegions = new Array<TextureRegion>();
        int x = 64;
        int y = 64;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                hero_sheet_textureRegions.add(new TextureRegion(hero_sheet, x*j, y*i, 64, 64));
                Gdx.app.log("counter"," "+count++);
            }
        }
    }


    @Override
    public void dispose() {

    }
}

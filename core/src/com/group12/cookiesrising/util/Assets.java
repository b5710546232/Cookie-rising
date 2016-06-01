package com.group12.cookiesrising.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.group12.cookiesrising.gameobjects.EnemyData;
import com.group12.cookiesrising.gameobjects.EnemyDataAnimation;

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
    public static Texture enemy01_sheet;
    public static Texture enemy02_sheet;
    public static Texture enemy03_sheet;

    public static TextureRegionDrawable button_atk_up;
    public static TextureRegionDrawable button_atk_down;
    public static TextureRegionDrawable button_cri_up;
    public static TextureRegionDrawable button_cri_down;
    public static TextureRegionDrawable button_heal_up;
    public static TextureRegionDrawable button_heal_down;
    public static TextureRegionDrawable button_h1_up;
    public static TextureRegionDrawable button_h1_down;
    public static TextureRegionDrawable button_h2_up;
    public static TextureRegionDrawable button_h2_down;
    public static TextureRegionDrawable button_h3_up;
    public static TextureRegionDrawable button_h3_down;
//    private static Texture button_sheet;
    public static TextureRegion atk,cri,heal,h1b,h2b,h3b;
    public static Array<TextureRegion> hero_sheet_textureRegions;
    public static Array<TextureRegion> enemy01_sheet_textureRegions;
    public static Array<TextureRegion> enemy02_sheet_textureRegions;
    public static Array<TextureRegion> enemy03_sheet_textureRegions;
//    public static Array<TextureRegion> button_sheet_textureRegions;
//    public static Array<TextureRegionDrawable> button_sheet_drawable;

    public static Animation anim_warrior_idle;
    public static Animation anim_warrior_atk;
    public static Animation anim_warrior_faint;
    public static Animation anim_mage_heal;
    public static Animation anim_mage_idle;
    public static Animation anim_mage_faint;
    public static Animation anim_gunner_idle;
    public static Animation anim_gunner_atk;
    public static Animation anim_gunner_faint;

    public static Animation anim_enemy01_idle;
    public static Animation anim_enemy01_atk;
    public static Animation anim_enemy01_hitted;
    public static Animation anim_enemy01_die;

    public static Animation anim_enemy02_idle;
    public static Animation anim_enemy02_atk;
    public static Animation anim_enemy02_hitted;
    public static Animation anim_enemy02_die;

    public static Animation anim_enemy03_idle;
    public static Animation anim_enemy03_atk;
    public static Animation anim_enemy03_hitted;
    public static Animation anim_enemy03_die;

    public static Sound hitted_sound;
    public static Sound mon_die_sound;
    public static Sound click_sound;
    public static Sound heal_sound;
    public static Music bgm;
    private static EnemyDataAnimation mon03_anim;
    private static EnemyDataAnimation mon02_anim;
    private static EnemyDataAnimation mon01_anim;

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
        loadEnemy();
        loadButton();
        loadSoundFX();
        loadBgm();
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

    private void loadSoundFX() {
        hitted_sound = Gdx.audio.newSound(Gdx.files.internal("sfx/Hit_Hurt11.wav"));
        mon_die_sound = Gdx.audio.newSound(Gdx.files.internal("sfx/Explosion11.wav"));
        click_sound = Gdx.audio.newSound(Gdx.files.internal("sfx/Powerup19.wav"));
        heal_sound = Gdx.audio.newSound(Gdx.files.internal("sfx/Powerup26.wav"));
    }

    private void loadBgm(){
        bgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/newbattle.wav"));
        bgm.setLooping(true);
    }

    private void loadButton() {

        button_atk_up = createTextureRegionDrawable(new Texture(Gdx.files.internal("atk_button.png")));
        button_atk_down =createTextureRegionDrawable(new Texture(Gdx.files.internal("atk_button_down.png")));
        button_cri_up = createTextureRegionDrawable(new Texture(Gdx.files.internal("cri_button.png")));
        button_cri_down = createTextureRegionDrawable(new Texture(Gdx.files.internal("cri_button_down.png")));
        button_heal_up = createTextureRegionDrawable(new Texture(Gdx.files.internal("heal_button.png")));
        button_heal_down = createTextureRegionDrawable(new Texture(Gdx.files.internal("heal_button_down.png")));;
        button_h1_up = createTextureRegionDrawable(new Texture(Gdx.files.internal("hero01_button.png")));
        button_h1_down = createTextureRegionDrawable(new Texture(Gdx.files.internal("hero01_button_down.png")));
        button_h2_up = createTextureRegionDrawable(new Texture(Gdx.files.internal("hero02_button.png")));
        button_h2_down = createTextureRegionDrawable(new Texture(Gdx.files.internal("hero02_button_down.png")));
        button_h3_up = createTextureRegionDrawable(new Texture(Gdx.files.internal("hero03_button.png")));
        button_h3_down = createTextureRegionDrawable(new Texture(Gdx.files.internal("hero03_button_down.png")));

    }

    private TextureRegionDrawable createTextureRegionDrawable(Texture t) {
        TextureRegion tr = new TextureRegion(t);
        TextureRegionDrawable td = new TextureRegionDrawable(tr);
        return td;
    }

    private void loadEnemy() {
        splitEnemySheetToArray();
        setEnemy01Animate();
        setEnemy02Animate();
        setEnemy03Animate();
        EnemyData.instance.addEnemyAnimationData(mon01_anim);
        EnemyData.instance.addEnemyAnimationData(mon02_anim);
        EnemyData.instance.addEnemyAnimationData(mon03_anim);

    }

    private void setEnemy03Animate() {
        TextureRegion[] enemy03_reg_idle = new TextureRegion[4];
        enemy03_reg_idle[0] = enemy03_sheet_textureRegions.get(0);
        enemy03_reg_idle[1] = enemy03_sheet_textureRegions.get(1);
        enemy03_reg_idle[2] = enemy03_sheet_textureRegions.get(2);
        enemy03_reg_idle[3] = enemy03_sheet_textureRegions.get(1);
        TextureRegion[] enemy03_reg_atk= new TextureRegion[1];
        enemy03_reg_atk[0] = enemy03_sheet_textureRegions.get(3);


        TextureRegion[] enemy03_reg_hitted = new TextureRegion[2];
        enemy03_reg_hitted[0] = enemy03_sheet_textureRegions.get(4);
        enemy03_reg_hitted[1] = enemy03_sheet_textureRegions.get(5);

        TextureRegion[] enemy03_reg_die = new TextureRegion[3];
        enemy03_reg_die[0] = enemy03_sheet_textureRegions.get(4);
        enemy03_reg_die[1] = enemy03_sheet_textureRegions.get(6);
        enemy03_reg_die[2] = enemy03_sheet_textureRegions.get(7);
//
        anim_enemy03_idle = new Animation(0.2f,enemy03_reg_idle);
        anim_enemy03_idle.setPlayMode(Animation.PlayMode.LOOP);
//
        anim_enemy03_atk = new Animation(0.25f,enemy03_reg_atk);
        anim_enemy03_atk.setPlayMode(Animation.PlayMode.NORMAL);
//
        anim_enemy03_hitted = new Animation(0.1f,enemy03_reg_hitted);
        anim_enemy03_hitted.setPlayMode(Animation.PlayMode.NORMAL);
//
        anim_enemy03_die = new Animation(0.25f,enemy03_reg_die);
        anim_enemy03_die.setPlayMode(Animation.PlayMode.NORMAL);

        mon03_anim = new EnemyDataAnimation("Cookie03",anim_enemy03_idle,anim_enemy03_die,anim_enemy03_atk,anim_enemy03_hitted);

    }

    private void setEnemy02Animate() {
        TextureRegion[] enemy02_reg_idle = new TextureRegion[4];
        enemy02_reg_idle[0] = enemy02_sheet_textureRegions.get(0);
        enemy02_reg_idle[1] = enemy02_sheet_textureRegions.get(1);
        enemy02_reg_idle[2] = enemy02_sheet_textureRegions.get(2);
        enemy02_reg_idle[3] = enemy02_sheet_textureRegions.get(1);
        TextureRegion[] enemy02_reg_atk= new TextureRegion[1];
        enemy02_reg_atk[0] = enemy02_sheet_textureRegions.get(3);


        TextureRegion[] enemy02_reg_hitted = new TextureRegion[2];
        enemy02_reg_hitted[0] = enemy02_sheet_textureRegions.get(4);
        enemy02_reg_hitted[1] = enemy02_sheet_textureRegions.get(5);

        TextureRegion[] enemy02_reg_die = new TextureRegion[3];
        enemy02_reg_die[0] = enemy02_sheet_textureRegions.get(4);
        enemy02_reg_die[1] = enemy02_sheet_textureRegions.get(6);
        enemy02_reg_die[2] = enemy02_sheet_textureRegions.get(7);
//
        anim_enemy02_idle = new Animation(0.2f,enemy02_reg_idle);
        anim_enemy02_idle.setPlayMode(Animation.PlayMode.LOOP);
//
        anim_enemy02_atk = new Animation(0.25f,enemy02_reg_atk);
        anim_enemy02_atk.setPlayMode(Animation.PlayMode.NORMAL);
//
        anim_enemy02_hitted = new Animation(0.1f,enemy02_reg_hitted);
        anim_enemy02_hitted.setPlayMode(Animation.PlayMode.NORMAL);
//
        anim_enemy02_die = new Animation(0.25f,enemy02_reg_die);
        anim_enemy02_die.setPlayMode(Animation.PlayMode.NORMAL);

        mon02_anim = new EnemyDataAnimation("Cookie02",anim_enemy02_idle,anim_enemy02_die,anim_enemy02_atk,anim_enemy02_hitted);

    }

    private void setEnemy01Animate() {
        TextureRegion[] enemy01_reg_idle = new TextureRegion[4];
        enemy01_reg_idle[0] = enemy01_sheet_textureRegions.get(0);
        enemy01_reg_idle[1] = enemy01_sheet_textureRegions.get(1);
        enemy01_reg_idle[2] = enemy01_sheet_textureRegions.get(2);
        enemy01_reg_idle[3] = enemy01_sheet_textureRegions.get(1);
        TextureRegion[] enemy01_reg_atk= new TextureRegion[1];
        enemy01_reg_atk[0] = enemy01_sheet_textureRegions.get(3);

        TextureRegion[] enemy01_reg_hitted = new TextureRegion[2];
        enemy01_reg_hitted[0] = enemy01_sheet_textureRegions.get(4);
        enemy01_reg_hitted[1] = enemy01_sheet_textureRegions.get(5);

        TextureRegion[] enemy01_reg_die = new TextureRegion[3];
        enemy01_reg_die[0] = enemy01_sheet_textureRegions.get(4);
        enemy01_reg_die[1] = enemy01_sheet_textureRegions.get(6);
        enemy01_reg_die[2] = enemy01_sheet_textureRegions.get(7);

        anim_enemy01_idle = new Animation(0.2f,enemy01_reg_idle);
        anim_enemy01_idle.setPlayMode(Animation.PlayMode.LOOP);

        anim_enemy01_atk = new Animation(0.25f,enemy01_reg_atk);
        anim_enemy01_atk.setPlayMode(Animation.PlayMode.NORMAL);

        anim_enemy01_hitted = new Animation(0.1f,enemy01_reg_hitted);
        anim_enemy01_hitted.setPlayMode(Animation.PlayMode.NORMAL);

        anim_enemy01_die = new Animation(0.25f,enemy01_reg_die);
        anim_enemy01_die.setPlayMode(Animation.PlayMode.NORMAL);

        mon01_anim = new EnemyDataAnimation("Cookie01",anim_enemy01_idle,anim_enemy01_die,anim_enemy01_atk,anim_enemy01_hitted);



    }

    private void splitEnemySheetToArray() {
        int row = 2;
        int col = 4;
        int size = 128;
        int number = 8;
        enemy01_sheet = new Texture(Gdx.files.internal("mon01_sheet.png"));
        enemy01_sheet_textureRegions = createTextureRegionsArray(size,row,col,number,enemy01_sheet);

        enemy02_sheet = new Texture(Gdx.files.internal("mon02_sheet.png"));
        enemy02_sheet_textureRegions = createTextureRegionsArray(size,row,col,number,enemy02_sheet);

        enemy03_sheet = new Texture(Gdx.files.internal("mon03_sheet.png"));
        enemy03_sheet_textureRegions = createTextureRegionsArray(size,row,col,number,enemy03_sheet);
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

        TextureRegion[] gunner_reg_faint = new TextureRegion[1];
        gunner_reg_faint[0] = hero_sheet_textureRegions.get(12);
        anim_gunner_faint = new Animation(1f,gunner_reg_faint);
        anim_gunner_faint.setPlayMode(Animation.PlayMode.LOOP);
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

        TextureRegion[] mage_reg_faint = new TextureRegion[1];
        mage_reg_faint[0] = hero_sheet_textureRegions.get(14);
        anim_mage_faint = new Animation(1f,mage_reg_faint);
        anim_mage_faint.setPlayMode(Animation.PlayMode.LOOP);
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

        TextureRegion[] warrior_reg_faint = new TextureRegion[1];
        warrior_reg_faint[0] = hero_sheet_textureRegions.get(13);
        anim_warrior_faint = new Animation(1f,warrior_reg_faint);
        anim_warrior_faint.setPlayMode(Animation.PlayMode.LOOP);

    }

    private void splitHeroSheetToArray() {
//        hero_sheet = new Texture(Gdx.files.internal("hero_sprite_sheet.png"));
//        hero_sheet_textureRegions = new Array<TextureRegion>();
//        int x = 64;
//        int y = 64;
//        int count = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//                hero_sheet_textureRegions.add(new TextureRegion(hero_sheet, x*j, y*i, 64, 64));
//                Gdx.app.log("counter"," "+count++);
//            }
//        }
        hero_sheet = new Texture(Gdx.files.internal("hero_sprite_sheet.png"));
        int row = 4;
        int size = 64;
        int col = 4;
        int number = 15;
        hero_sheet_textureRegions = createTextureRegionsArray(size,row,col,number,hero_sheet);
    }


    private Array<TextureRegion> createTextureRegionsArray(int size,int row,int col,int numberOfSprite,Texture texture){
        Array<TextureRegion> sheet = new Array<TextureRegion>();
        int count = 0;
        for(int i = 0 ; i<row ;i++){
            for(int j = 0 ;j<col ; j++){
                if(count>=numberOfSprite) break;
                sheet.add(new TextureRegion(texture,j*size,i*size,size,size));
                count++;
            }
        }
        return sheet;

    }


    @Override
    public void dispose() {
        hitted_sound.dispose();
        hero_sheet.dispose();
        enemy01_sheet.dispose();
        bg.dispose();
        coin.dispose();
        hero.dispose();
    }
}

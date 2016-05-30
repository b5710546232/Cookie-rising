package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public class TextPool extends AbstractGameText {

    private Array<GameText> pool;

    public TextPool(int number) {
        pool = new Array<GameText>();
        if(number>0){
            for(int i= 0 ; i<number ; i++){
                pool.add(new GameText());
            }
        }
    }

    public TextPool(AbstractGameTextFactory factory,int number) {
        pool = new Array<GameText>();
        if(number>0){
            for(int i= 0 ; i<number ; i++){
                pool.add(factory.create());
            }
        }
    }

    public GameText getDamageText(String text, int x, int y){

        for(GameText gtext : pool){
            if(!gtext.isActive){
                Gdx.app.error("pool","out");
                gtext.init(text,x,y);
                return gtext;
            }
        }
        GameText newDmgText = new GameText();
        newDmgText.init(text,x,y);
        pool.add(newDmgText);
        Gdx.app.log("pool","total = "+pool.size);
        return newDmgText;
    }

    @Override
    public void update(float delta) {
        for(GameText gtext : pool){
            gtext.update(delta);
        }
    }


    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        for(GameText gtext : pool){
            if(gtext.isActive)
                gtext.draw(font,batch);
        }
    }
}

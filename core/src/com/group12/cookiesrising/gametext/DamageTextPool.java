package com.group12.cookiesrising.gametext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public class DamageTextPool extends AbstractGameText {

    private Array<DamageText> pool;

    public DamageTextPool(int number) {
        pool = new Array<DamageText>();
        if(number>0){
            for(int i= 0 ; i<number ; i++){
                pool.add(new DamageText());
            }
        }
    }

    public DamageText getDamageText(String text, int x, int y){
        for(DamageText dmgText : pool){
            if(!dmgText.isActive){
                Gdx.app.error("pool","out");
                dmgText.init(text,x,y);
                return dmgText;
            }
        }
        DamageText newDmgText = new DamageText();
        newDmgText.init(text,x,y);
        pool.add(newDmgText);
        Gdx.app.log("pool","total = "+pool.size);
        return newDmgText;
    }

    @Override
    public void update(float delta) {
        for(DamageText dmgText : pool){
            dmgText.update(delta);
        }
    }

    @Override
    public void draw(BitmapFont font, SpriteBatch batch) {
        for(DamageText dmgText : pool){
            if(dmgText.isActive)
                dmgText.draw(font,batch);
        }
    }
}

package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by nattapat on 5/7/2016 AD.
 */
public class DamageTextPool implements IGameObjectDrawable{

    private Array<DamageText> pool;

    public DamageTextPool(int number) {
        pool = new Array<DamageText>();
        if(number>0){
            for(int i= 0 ; i<number ; i++){
                pool.add(new DamageText());
            }
        }
    }

    public DamageText getDamageText(String text,int x, int y){
        for(DamageText dmgText : pool){
            if(!dmgText.isActive){
                Gdx.app.error("pool","out");
                dmgText.init(text,x,y);
                return dmgText;
            }
        }
        DamageText dmgtxt = new DamageText();
        dmgtxt.init(text,x,y);
        pool.add(dmgtxt);
        Gdx.app.log("pool","total = "+pool.size);
        return dmgtxt;
    }
    @Override
    public void draw(SpriteBatch batch) {
        for(DamageText dmgText : pool){
            if(dmgText.isActive)
                dmgText.draw(batch);
        }
    }

}

package com.group12.cookiesrising.gameobjects;

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
                dmgText.init(text,x,y);
                return dmgText;
            } else{
                DamageText dmgtxt = new DamageText();
                dmgtxt.init(text,x,y);
                pool.add(dmgtxt);
                return dmgtxt;
            }
        }
        return null;
    }
    @Override
    public void draw(SpriteBatch batch) {
        for(DamageText dmgText : pool){
            if(dmgText.isActive)
                dmgText.draw(batch);
        }
    }

}

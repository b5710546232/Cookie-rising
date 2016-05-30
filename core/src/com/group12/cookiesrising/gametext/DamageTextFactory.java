package com.group12.cookiesrising.gametext;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class DamageTextFactory extends AbstractGameTextFactory{

    @Override
    public GameText create() {
        return new DamageText();
    }
}

package com.group12.cookiesrising.gametext;

/**
 * Created by YukiReii on 31/5/2559.
 */
public class HealTextFactory extends AbstractGameTextFactory{
    @Override
    public GameText create() {
        return new HealText();
    }
}

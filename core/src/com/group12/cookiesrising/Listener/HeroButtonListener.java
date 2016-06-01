package com.group12.cookiesrising.Listener;

/**
 * Created by YukiReii on 31/5/2559.
 */
public class HeroButtonListener extends ObservableListener {
    private int hero_num;
    public HeroButtonListener(int hero_num){
        super("Hero "+hero_num);
        this.hero_num=hero_num;
    }

    public int getHero_num() {
        return hero_num;
    }
}

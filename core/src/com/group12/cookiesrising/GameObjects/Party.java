package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.group12.cookiesrising.Hittable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by it's a me, Gafig on 5/26/2016 AD.
 */
public class Party implements Hittable{

    List<Hero> heroList;

    public Party(){
        Gdx.app.log("party","Create");
        heroList = new ArrayList<Hero>();
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    @Override
    public void takeDamage(double dmg) {
        for(Hero h:heroList){
            h.takeDamage(dmg);
        }
    }

    public void takeHeal(double value){

    }

    public void addHero(Hero h){
        Gdx.app.error("paryt","add hero");
        heroList.add(h);
    }
}

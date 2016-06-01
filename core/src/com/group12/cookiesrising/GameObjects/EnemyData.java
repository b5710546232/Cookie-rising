package com.group12.cookiesrising.gameobjects;

import com.badlogic.gdx.Gdx;
import com.group12.cookiesrising.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 6/1/2016 AD.
 */
public class EnemyData {
    public static final EnemyData instance = new EnemyData();
    static List<EnemyDataAnimation> listAnim;
    private RandomGenerator rng;
    int count = 0;
    EnemyData(){
        listAnim = new ArrayList<EnemyDataAnimation>();
        rng = new RandomGenerator(0,listAnim.size());
    }

    public void addEnemyAnimationData(EnemyDataAnimation e){
        listAnim.add(e);
        rng.setMAX(listAnim.size()-1);
        Gdx.app.error("enemy size ",listAnim.size()+"");
    }

    public EnemyDataAnimation getEnemyDataAnimation(){
        rng.random();
        Gdx.app.error("anim v = "," "+rng.getValue());
        return listAnim.get(rng.getValue());
    }

    public void clearAnim(){
        listAnim.clear();
    }
}

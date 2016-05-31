package com.group12.cookiesrising.util;

import java.io.Serializable;

/**
 * Created by nattapat on 5/31/2016 AD.
 */
public class GameData implements Serializable{

    private int money;
    private int enemyLevel;
    private int warriorLevel;
    private int mageLevel;
    private int gunnerLevel;
    public static final GameData instance = new GameData();

    private GameData(){
    }

    public void init() {
        money = 0;
        enemyLevel = 1;

    }

    public int getMoney(){
        return money;
    }

    public int getEnemyLevel() {
        return enemyLevel;
    }


}

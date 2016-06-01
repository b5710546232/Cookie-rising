package com.group12.cookiesrising.util;

import java.util.Random;

/**
 * Created by nattapat on 5/30/2016 AD.
 */
public class RandomGenerator {
    private Random random;
    private int MAX = 0;
    private int MIN = 0;
    private int value;
    public RandomGenerator(int min,int max) {
        MAX = max;
        MIN = min;
        value = 0;
        random = new Random();
    }

    public void random(){
        value = MIN+random.nextInt(MAX);
    }

    public void setMAX(int m){
        MAX = m;
    }

    public void setMIN(int m){
        MIN = m;
    }

    public int getValue(){
        return value;
    }
}

package com.group12.cookiesrising.State;

import com.group12.cookiesrising.Hittable;

/**
 * Created by nattapat on 5/26/2016 AD.
 */
public interface State {
    public void action(Hittable target);
    public void takeDamage(double dmg);
    public void idle();
    public void changeState();
    public void respawn();
    public boolean isAlive();
    public void update(float delta);
}

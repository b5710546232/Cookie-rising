package com.group12.cookiesrising;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.Timer;
import com.group12.cookiesrising.Screen.GamePlayScreen;

public class Cookiesrising extends Game {
	GamePlayScreen gamePlayScreen;

	@Override
	public void create() {
		Timer.instance().clear();
		gamePlayScreen = new GamePlayScreen(this);
		this.setScreen(gamePlayScreen);
	}

}
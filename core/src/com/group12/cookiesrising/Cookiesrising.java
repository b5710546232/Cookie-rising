package com.group12.cookiesrising;

import com.badlogic.gdx.Game;
import com.group12.cookiesrising.screen.GamePlayScreen;

public class Cookiesrising extends Game {
	GamePlayScreen gamePlayScreen;

	@Override
	public void create() {
		gamePlayScreen = new GamePlayScreen(this);
		this.setScreen(gamePlayScreen);

	}

}
package com.david.game.mrnom;

import com.david.game.framework.Screen;
import com.david.game.framework.impl.AndroidGame;

public class MrNomGame extends AndroidGame {

	public Screen getStartScreen() {
		return new LoadingScreen(this);
	}

}

package com.david.game.framework.test;

import com.david.game.framework.Game;
import com.david.game.framework.Graphics.PixmapFormat;
import com.david.game.framework.Pixmap;
import com.david.game.framework.Screen;

public class StartScreen extends Screen {
	Pixmap p;
	int x;
	
	public StartScreen(Game game) {
		super(game);
		p = game.getGraphics().newPixmap("data/pic.png", PixmapFormat.RGB565);
	}

	@Override
	public void update(float deltaTime) {
		x += 50*deltaTime;
		if (x > 100) {
			x = 0;
		}
	}

	@Override
	public void present(float deltaTime) {
		game.getGraphics().clear(0);
		game.getGraphics().drawPixmap(p, x, 0, 0, 0, p.getWidth(), p.getHeight());
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		p.dispose();
	}
}

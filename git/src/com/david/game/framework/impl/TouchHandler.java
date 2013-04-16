package com.david.game.framework.impl;

import java.util.List;

import android.view.View.OnTouchListener;

import com.david.game.framework.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {
	public boolean isTownDown(int pointer);
	public int getTouchX(int pointer);
	public int getTouchY(int pointer);
	public List<TouchEvent> getTouchEvents();
}

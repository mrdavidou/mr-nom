package com.david.game.framework.impl;

import android.media.SoundPool;

import com.david.game.framework.Sound;

public class AndroidSound implements Sound {
	int soundID;
	SoundPool soundPool;
	
	public AndroidSound(int soundID, SoundPool soundPool) {
		this.soundID = soundID;
		this.soundPool = soundPool;
	}

	public void play(float volume) {
		soundPool.play(soundID, volume, volume, 0, 0, 1);
	}

	public void dispose() {
		soundPool.unload(soundID);
	}

}

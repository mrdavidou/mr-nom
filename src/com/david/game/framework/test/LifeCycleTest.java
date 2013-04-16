package com.david.game.framework.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LifeCycleTest extends Activity {
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	private void log(String text) {
		Log.d("LifeCycleTest", text);
		builder.append(text);
		builder.append("\n");
		textView.setText(builder.toString());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText(builder.toString());
		setContentView(textView);
		log("Game is created");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		log("Game is paused");
		
		//check if game is going to be destroyed after the onPause() method call
		if (isFinishing()) {
			log("Game is finishing");
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		log("Game is resumed");
	}
}

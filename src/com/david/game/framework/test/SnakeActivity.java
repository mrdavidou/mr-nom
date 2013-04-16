package com.david.game.framework.test;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SnakeActivity extends ListActivity {
	String tests[] = { "LifeCycleTest", "SingleTouchTest", "MultiTouchTest", 
			"KeyTest", "AcceleromterTest", "AssetsTest", "ExternalStorageTest",
			"SoundPoolTest", "MediaPlayerTest", "FullScreenTest", "RenderViewTest",
			"ShapeTest", "BitmapTest", "FontTest", "SurfaceViewTest", "UnitsConverter" };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
    }
    
    protected void onListItemClick(ListView list, View view, int position, long id) {
    	super.onListItemClick(list, view, position, id);
    	String testName = tests[position];
    	try {
    		Class c = Class.forName("com.david.game.snake." + testName);
    		Intent intent = new Intent(this, c);
    		startActivity(intent);
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
}
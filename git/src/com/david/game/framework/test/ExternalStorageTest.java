package com.david.game.framework.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class ExternalStorageTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		String state = Environment.getExternalStorageState();
		if (!state.equals(Environment.MEDIA_MOUNTED)) {
			textView.setText("No external storage mounted");
		} else {
			File externalDir = Environment.getExternalStorageDirectory();
			File textFile = new File(externalDir.getAbsolutePath() + File.separator + "test.txt");
			try {
				writeTextFile(textFile, "This is a test. Roger!");
				String text = readTextFile(textFile);
				textView.setText(text);
				if (!textFile.delete()) {
					textView.setText("Couldn't remove temporary file!");
				}
			} catch (IOException e) {
				textView.setText("Something went wrong! " + e.getMessage());
			}
		}
	}

	// Generic method, change it to static and add to framework library
	private String readTextFile(File textFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(textFile));
		StringBuilder text = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			text.append(line);
			text.append("\n");
		}
		reader.close();
		return text.toString();
	}

	// Generic method, change it to static and add to framework library
	private void writeTextFile(File textFile, String string) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(textFile));
		writer.write(string);
		writer.close();
	}
	
}

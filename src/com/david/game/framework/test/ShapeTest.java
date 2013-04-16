package com.david.game.framework.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ShapeTest extends Activity {
	Paint paint;
	
	class RenderView extends View {
		public RenderView(Context context) {
			super(context);
			paint = new Paint();
		}

		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawRGB(256, 256, 256);
			paint.setColor(Color.RED);
			canvas.drawLine(0, 0, canvas.getWidth()-1, canvas.getHeight()-1, paint);
			paint.setStyle(Style.STROKE);
			paint.setColor(0xff00ff00);
			canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 40, paint);
			paint.setStyle(Style.FILL);
			paint.setColor(0x770000ff);
			canvas.drawRect(100, 100, 200, 200, paint);
			invalidate();
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFeatureInt(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new RenderView(this));
	}
	
}

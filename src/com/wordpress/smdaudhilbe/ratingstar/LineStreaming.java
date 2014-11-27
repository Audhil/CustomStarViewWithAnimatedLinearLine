package com.wordpress.smdaudhilbe.ratingstar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
//import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

public class LineStreaming extends View {

	private Path path,mPath;
	private Paint mPaint;
	
	int dist = 1;
	private Handler myHandler;
	Runnable myRunnable = new Runnable() {
		
		@Override
		public void run() {
			invalidate();
		}
	};
	private Paint paint;

	public LineStreaming(Context context) {
		super(context);
		path = new Path();
		mPath = new Path();
		mPaint = new Paint();
		paint = new Paint();
		
		myHandler = new Handler();
	}

	public LineStreaming(Context context, AttributeSet attrs) {
		super(context, attrs);
		path = new Path();
		mPath = new Path();
		mPaint = new Paint();
		paint = new Paint();
		
		myHandler = new Handler();
		
		mPaint.setColor(Color.BLUE);
		mPaint.setStrokeWidth(10);
		mPaint.setStyle(Paint.Style.STROKE);
		
		paint.setColor(Color.YELLOW);
		paint.setStrokeWidth(10);
		paint.setStyle(Paint.Style.STROKE);
		
		mPath.moveTo(50, 50);
		mPath.lineTo(50, 500);
	}	

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		path.moveTo(50,50);
		
		if(dist <= 2){
			path.lineTo(50 + ((dist * (50 - 50)) / 5), 50 + ((dist * (500 - 50)) / 5));
			dist++;
			
			myHandler.postDelayed(myRunnable, 25);
		}	
		canvas.drawPath(mPath, mPaint);		
		canvas.drawPath(path, paint);
	}
}
package com.wordpress.smdaudhilbe.ratingstar;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

@SuppressLint("DrawAllocation")
public class RatingStarView extends View {
	
	private Path starPath,borderPath;
	private Paint starPaint,borderPaint;
	private List<PointF> listOfPoints,pointsToCover,toTalPointsIs;
	private int x,y,starStartAngle,rangeToCover,actualRangeCoverd = 1;
	private float x1,y1,x2,y2;
	boolean drawn = false;
	
	private int inte = 0;		

	public RatingStarView(Context context) {
		super(context);
		
		listOfPoints = new ArrayList<PointF>();
		pointsToCover = new ArrayList<PointF>();
		toTalPointsIs = new ArrayList<PointF>();
	}

	public RatingStarView(Context context, AttributeSet attrs) {
		super(context, attrs);

		starPath = new Path();
		
		starStartAngle = 125;
		
		borderPath = new Path();
		
		listOfPoints = new ArrayList<PointF>();
		pointsToCover = new ArrayList<PointF>();
		toTalPointsIs = new ArrayList<PointF>();

		starPaint = new Paint();
		starPaint.setColor(Color.GRAY);
		starPaint.setStyle(Paint.Style.STROKE);
		starPaint.setStrokeCap(Paint.Cap.ROUND);
		starPaint.setStrokeWidth(8);
		
		borderPaint = new Paint();
		borderPaint.setColor(Color.parseColor("#10b683"));
		borderPaint.setStyle(Paint.Style.STROKE);
		borderPaint.setStrokeCap(Paint.Cap.ROUND);
		borderPaint.setStrokeWidth(15);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		x = getWidth() / 2;
		y = getHeight() / 2;

		int outerRadius = Math.min(x, y) / 2;
		int innerRadius = (int)(outerRadius / 2.5);

		int points = 5;

		float angle = (float) (Math.PI * 2) / (points * 2);

		int workingRadius = outerRadius;
		starPath.reset();
		
	    starPath.moveTo(workingRadius, 0);
	    listOfPoints.add(new PointF(workingRadius, 0));

		for (int i = 1; i < points * 2; i++) {
			workingRadius = (workingRadius == outerRadius) ? innerRadius : outerRadius;

			float xPt = (float) (workingRadius * Math.cos(angle * i));
			float yPt = (float) (workingRadius * Math.sin(angle * i));
			starPath.lineTo(xPt, yPt);
			
			listOfPoints.add(new PointF(xPt, yPt));
		}
		starPath.close();

	    canvas.translate(x, y);
	    
	    //	drawing star
		canvas.rotate(starStartAngle);
        canvas.drawPath(starPath, starPaint);
        
        //	assigning points
        if(!drawn){
        	drawn = true;
        	assignPointsAndBorderPaths(listOfPoints);
        }
        
        if(inte != toTalPointsIs.size()){        	
        	canvas.drawPath(borderPath, borderPaint);
        	borderPath.moveTo(toTalPointsIs.get(inte).x, toTalPointsIs.get(inte).y);
        	
        	if(inte + 1 < toTalPointsIs.size()){
        		borderPath.lineTo(toTalPointsIs.get(inte+1).x, toTalPointsIs.get(inte+1).y);
        		invalidate();
        	}
        	
        	inte++;
        	
        	//	to add delay
        	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}        	
        }
        
//      will draw without animation  
//        canvas.drawPath(borderPath, borderPaint);

		super.onDraw(canvas);
	}

	public void drawBorderUptoThis(int rangeToCover) {
		this.rangeToCover = rangeToCover;
	}
	
	public void assignPointsAndBorderPaths(List<PointF> listOfPoints) {
		
		if(rangeToCover <= 10){
			if(rangeToCover <= 5){
				pointsToCover.add(listOfPoints.get(9));
				
				for (int i = 0; i < 1; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
			else{
				pointsToCover.add(listOfPoints.get(9));
				
				for (int i = 0; i < 2; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
		}
		else if(rangeToCover <= 20){
			if(rangeToCover <= 15){
				pointsToCover.add(listOfPoints.get(9));
				for (int i = 0; i < 3; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
			else{
				pointsToCover.add(listOfPoints.get(9));
				for (int i = 0; i < 4; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
		}
		else if(rangeToCover <= 30){
			if(rangeToCover <= 25){
				pointsToCover.add(listOfPoints.get(9));
				for (int i = 0; i < 5; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}	
			else{
				pointsToCover.add(listOfPoints.get(9));
				for (int i = 0; i < 6; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
		}
		else if(rangeToCover <= 40){
			if(rangeToCover <= 35){
				pointsToCover.add(listOfPoints.get(9));
				for (int i = 0; i < 7; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
			else{
				pointsToCover.add(listOfPoints.get(9));
				for (int i = 0; i < 8; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
		}
		else if(rangeToCover <= 50){
			if(rangeToCover <= 45){
				pointsToCover.add(listOfPoints.get(9));
				for (int i = 0; i < 9; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
			else{
				pointsToCover.add(listOfPoints.get(9));
				
				for (int i = 0; i < 10; i++) {
					pointsToCover.add(listOfPoints.get(i));
				}
				
				assignBorderPath(pointsToCover);
			}
		}	
	}

	//	assigning border path
	private void assignBorderPath(List<PointF> pointsToCover) {
		
		for (int i = 0; i < pointsToCover.size() - 1; i++) {
			
//	      will draw without animation
//			borderPath.moveTo(pointsToCover.get(i).x,pointsToCover.get(i).y);		
			
			toTalPointsIs.add(new PointF(pointsToCover.get(i).x,pointsToCover.get(i).y));
			
			x1 = pointsToCover.get(i).x;
			x2 = pointsToCover.get(i + 1).x;
			
			y1 = pointsToCover.get(i).y;
			y2 = pointsToCover.get(i + 1).y;
			
			for (int multiFactor = 1; multiFactor <= 5; multiFactor++) {
				
				//	http://www.dummies.com/how-to/content/how-to-divide-a-line-segment-into-multiple-parts.html
				
//		      will draw without animation
//				borderPath.lineTo(x1 + ((multiFactor * (x2 - x1)) / 5), y1 + ((multiFactor * (y2 - y1)) / 5));
				
				toTalPointsIs.add(new PointF(x1 + ((multiFactor * (x2 - x1)) / 5), y1 + ((multiFactor * (y2 - y1)) / 5)));
				
				if(actualRangeCoverd == rangeToCover){
					break;
				}				
				actualRangeCoverd++;			
			}
		}		
	}
}
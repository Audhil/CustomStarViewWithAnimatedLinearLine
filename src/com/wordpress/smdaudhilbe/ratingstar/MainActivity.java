package com.wordpress.smdaudhilbe.ratingstar;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	private RatingStarView ratingStartView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ratingStartView = (RatingStarView)findViewById(R.id.ratingStartView);
		ratingStartView.drawBorderUptoThis(35);
	}
}
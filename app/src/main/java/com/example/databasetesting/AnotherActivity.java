package com.example.databasetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

	private TextView mPointsTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another);

		mPointsTextView = findViewById(R.id.pointsTextView);
		mPointsTextView.setText("" + Config.getPoints(getApplicationContext()));
	}
}

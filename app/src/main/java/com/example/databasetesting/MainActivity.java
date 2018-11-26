package com.example.databasetesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

	private Button mOpenButton, mSendButton;
	private EditText mUserIdEditText, mCountEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mUserIdEditText = findViewById(R.id.userIdEditText);
		mCountEditText = findViewById(R.id.countEditText);
		mSendButton = findViewById(R.id.sendButton);
		mOpenButton = findViewById(R.id.openButton);
		mSendButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Element element = Config.getElements().get(0);

				new DatabaseQuery(getApplicationContext()).insert(element.getId(), element.getName(),
						Integer.parseInt(mCountEditText.getText().toString()),
						Integer.parseInt(mUserIdEditText.getText().toString()));

			}
		});
		mOpenButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, AnotherActivity.class));
			}
		});
	}
}

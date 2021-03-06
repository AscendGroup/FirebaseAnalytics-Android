package com.example.analytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
	private static final String USER_PROPERTY = "favorite_food";
	private FirebaseAnalytics mFirebaseAnalytics;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView) findViewById(R.id.textview);

		mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
		mFirebaseAnalytics.setUserProperty("favorite_food", "Pizza");
		mTextView.setText(String.format("UserProperty: %s", USER_PROPERTY));
	}

	public void sendPredefineEvent(View view) {
		Bundle bundle = new Bundle();
		bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "12345");
		bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Nougat");
		bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Image");
		mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
		mTextView.setText(R.string.sent_predefine);
	}

	public void sendCustomEvent(View view) {
		Bundle params = new Bundle();
		params.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Image");
		params.putString("image_name", "android.png");
		params.putString("full_text", "Android 7.0 Nougat");
		mFirebaseAnalytics.logEvent("share_image", params);
		mTextView.setText(R.string.sent_custom);
	}
}
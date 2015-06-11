package com.wh.demo.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.wh.demo.MainActivity;
import com.wh.demo.R;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
@ContentView(R.layout.activity_animation)
public class ActivityAnimation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

	}

	@OnClick(R.id.button1)
	public void open1(View view) {
		// Request the next activity transition (here starting a new one).
		startActivity(new Intent(ActivityAnimation.this, MainActivity.class));
		// Supply a custom animation. This one will just fade the new
		// activity on top. Note that we need to also supply an animation
		// (here just doing nothing for the same amount of time) for the
		// old activity to prevent it from going away too soon.
		overridePendingTransition(R.anim.fade, R.anim.hold);

	}

	@OnClick(R.id.button2)
	public void open2(View view) {
		// Request the next activity transition (here starting a new one).
		startActivity(new Intent(ActivityAnimation.this, MainActivity.class));
		// This is a more complicated animation, involving transformations
		// on both this (exit) and the new (enter) activity. Note how for
		// the duration of the animation we force the exiting activity
		// to be Z-ordered on top (even though it really isn't) to achieve
		// the effect we want.
		overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
	}

	@OnClick(R.id.button3)
	public void open3(View view) {
		// Create a more complicated animation, involving transformations
		// on both this (exit) and the new (enter) activity. Note how for
		// the duration of the animation we force the exiting activity
		// to be Z-ordered on top (even though it really isn't) to achieve
		// the effect we want.
		ActivityOptions opts = ActivityOptions.makeCustomAnimation(
				ActivityAnimation.this, R.anim.zoom_enter, R.anim.zoom_enter);
		// Request the activity be started, using the custom animation options.
		startActivity(new Intent(ActivityAnimation.this, MainActivity.class),
				opts.toBundle());
	}
}

package com.wh.demo.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.wh.demo.R;

@ContentView(R.layout.activity_action_bar)
public class MactionBar extends Activity {

	private View mCustomView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

		setCustomActionBar();

	}

	/**
	 * 自定义的actionBar
	 */
	private void setCustomActionBar() {

		mCustomView = getLayoutInflater().inflate(
				R.layout.actionbar_custom_view, null);

		final ActionBar bar = getActionBar();

		bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		bar.setCustomView(mCustomView, new ActionBar.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}
}

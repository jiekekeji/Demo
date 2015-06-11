package com.wh.demo.app;

import android.app.Activity;
import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.wh.demo.R;

@ContentView(R.layout.dialog_one)
public class Dialog1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

	}

}

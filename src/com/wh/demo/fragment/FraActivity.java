package com.wh.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.wh.demo.R;

/**
 * 容纳了其他的fragment
 * 
 * @author tanjieke
 *
 */
@ContentView(R.layout.activity_fra)
public class FraActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		ViewUtils.inject(this);
	}
}

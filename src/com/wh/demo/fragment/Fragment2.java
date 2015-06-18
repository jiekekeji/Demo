package com.wh.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.wh.demo.R;

/***
 * fragment第一种方式
 * 
 * @author tanjieke
 *
 */
public class Fragment2 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_002, null);
		ViewUtils.inject(this, view);
		return view;
	}

	@OnClick(R.id.button1)
	public void open(View view) {
		Toast.makeText(getActivity(), "我是第二个fragment上的按钮", Toast.LENGTH_SHORT)
				.show();
	}
}

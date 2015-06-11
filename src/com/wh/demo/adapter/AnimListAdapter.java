package com.wh.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AnimListAdapter extends BaseAdapter {

	private List<String> list;

	private Context ct;

	public AnimListAdapter(Context ct) {

		list = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			list.add("条目" + i);
		}

		this.ct = ct;

	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(ct);
		textView.setText(list.get(position));
		return textView;
	}
}

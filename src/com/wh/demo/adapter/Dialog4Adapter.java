package com.wh.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Dialog4Adapter extends BaseAdapter {

	private List<String> list;

	private Context ct;

	public Dialog4Adapter(Context ct, List<String> list) {
		this.ct = ct;
		this.list = list;
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

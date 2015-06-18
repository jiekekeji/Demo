package com.wh.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MulAdapter extends BaseAdapter {

	private Context ct;

	public MulAdapter(Context ct) {
		this.ct = ct;
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Object getItem(int position) {
		return new Object();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		switch (position) {
		case 0:
			convertView = new Button(ct);
			break;
		case 1:
			convertView = new TextView(ct);
			break;
		case 2:
			convertView = new Button(ct);
			break;

		default:
			break;
		}

		return convertView;

	}

	public final class ViewHolder {
		public TextView title;
	}

}

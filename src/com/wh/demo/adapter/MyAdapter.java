package com.wh.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wh.demo.R;

public class MyAdapter extends BaseAdapter {

	LayoutInflater inflater;

	public static final String[] MEGS = { "list", "list", "list", "list",
			"list", "list", "list", "list" };

	public MyAdapter(Context ct) {
		inflater = LayoutInflater.from(ct);
	}

	@Override
	public int getCount() {
		return MEGS.length;
	}

	@Override
	public Object getItem(int position) {
		return MEGS[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_lv_ch, null);

			holder.title = (TextView) convertView.findViewById(R.id.tv1);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.title.setText(MEGS[position] + position);

		return convertView;

	}

	public final class ViewHolder {
		public TextView title;
	}

}

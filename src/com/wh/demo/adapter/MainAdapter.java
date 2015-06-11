package com.wh.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wh.demo.R;
import com.wh.demo.bean.AcInfo;

public class MainAdapter extends BaseAdapter {

	private List<AcInfo> acInfos;

	private LayoutInflater inflater;

	public MainAdapter(List<AcInfo> acInfos, Context ct) {
		this.acInfos = acInfos;
		this.inflater = LayoutInflater.from(ct);
	}

	@Override
	public int getCount() {
		return acInfos.size();
	}

	@Override
	public Object getItem(int position) {
		return acInfos.get(position);
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
			convertView = inflater.inflate(R.layout.item_main_lv, null);

			holder.acName = (TextView) convertView.findViewById(R.id.acName);
			holder.acDec = (TextView) convertView.findViewById(R.id.acDec);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		AcInfo info = acInfos.get(position);

		holder.acName.setText(info.getCls().toString());
		holder.acDec.setText(info.getAcDec());

		return convertView;
	}

	public final class ViewHolder {
		public TextView acName;
		public TextView acDec;
	}

}

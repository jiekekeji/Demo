package com.wh.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.demo.R;
import com.wh.demo.bean.HorizontalLvMo;

public class HorizontalLvAdapter extends BaseAdapter {

	List<HorizontalLvMo> mos;
	private LayoutInflater mInflater;

	public HorizontalLvAdapter(List<HorizontalLvMo> mos, Context mContext) {
		this.mos = mos;
		this.mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mos.size();
	}

	@Override
	public Object getItem(int position) {
		return mos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_horizontal_lv, null);

			holder.mImage = (ImageView) convertView
					.findViewById(R.id.img_list_item);
			holder.mTitle = (TextView) convertView
					.findViewById(R.id.text_list_item);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		HorizontalLvMo mo = mos.get(position);
		holder.mTitle.setText(mo.getDec());
		holder.mImage.setImageResource(mo.getDra());

		return convertView;
	}

	private static class ViewHolder {
		private TextView mTitle;
		private ImageView mImage;
	}

}

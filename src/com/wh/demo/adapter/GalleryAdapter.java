package com.wh.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.wh.demo.R;

public class GalleryAdapter extends BaseAdapter {

	private Integer[] mImageIds;

	LayoutInflater inflater;

	public GalleryAdapter(Context ct, Integer[] mImageIds) {
		this.inflater = LayoutInflater.from(ct);
		this.mImageIds = mImageIds;
	}

	@Override
	public int getCount() {
		return mImageIds.length;
	}

	@Override
	public Object getItem(int position) {
		return mImageIds[position];
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
			convertView = inflater.inflate(R.layout.item_gallery_iv, null);

			holder.iv = (ImageView) convertView.findViewById(R.id.gallery_iv);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.iv.setImageResource(mImageIds[position]);

		return convertView;

	}

	public static class ViewHolder {
		ImageView iv;
	}
}

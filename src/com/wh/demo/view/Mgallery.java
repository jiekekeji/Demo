package com.wh.demo.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery.LayoutParams;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.wh.demo.R;
import com.wh.demo.adapter.GalleryAdapter;

@ContentView(R.layout.activity_gallery)
public class Mgallery extends Activity implements ViewFactory {

	@ViewInject(R.id.gallery)
	private Gallery gallery;

	@ViewInject(R.id.switcher)
	private ImageSwitcher mSwitcher;

	@ViewInject(R.id.gallery1)
	private Gallery gallery1;

	private final Integer[] mImageIds = { R.drawable.gallery_photo_1,
			R.drawable.gallery_photo_2, R.drawable.gallery_photo_3,
			R.drawable.gallery_photo_4, R.drawable.gallery_photo_5,
			R.drawable.gallery_photo_6, R.drawable.gallery_photo_7,
			R.drawable.gallery_photo_8 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

		gallery.setAdapter(new GalleryAdapter(this, mImageIds));
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				LogUtils.i("被点击的图片为" + position);

			}
		});

		mSwitcher.setFactory(this);
		mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));

		gallery1.setAdapter(new GalleryAdapter(this, mImageIds));
		gallery1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				mSwitcher.setImageResource(mImageIds[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}

	@Override
	public View makeView() {
		ImageView i = new ImageView(this);
		i.setBackgroundColor(0xFF000000);
		i.setScaleType(ImageView.ScaleType.FIT_CENTER);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		return i;
	}

}

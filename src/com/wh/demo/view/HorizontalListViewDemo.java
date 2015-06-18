package com.wh.demo.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.wh.demo.R;
import com.wh.demo.adapter.HorizontalLvAdapter;
import com.wh.demo.bean.HorizontalLvMo;
import com.wh.demo.custome.view.HorizontalListView;

/**
 * 横向滚动的listview
 * 
 * @author hujiushou
 * 
 */
@ContentView(R.layout.activity_horizontal_lv)
public class HorizontalListViewDemo extends Activity {

	@ViewInject(R.id.horizon_listview)
	HorizontalListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		initListView();
	}

	private void initListView() {
		List<HorizontalLvMo> mos = new ArrayList<HorizontalLvMo>();

		mos.add(new HorizontalLvMo(R.drawable.gallery_photo_1, "第一张"));
		mos.add(new HorizontalLvMo(R.drawable.gallery_photo_2, "第二张"));
		mos.add(new HorizontalLvMo(R.drawable.gallery_photo_3, "第三张"));
		mos.add(new HorizontalLvMo(R.drawable.gallery_photo_4, "第四张"));
		mos.add(new HorizontalLvMo(R.drawable.gallery_photo_5, "第五张"));
		mos.add(new HorizontalLvMo(R.drawable.gallery_photo_6, "第六张"));
		mos.add(new HorizontalLvMo(R.drawable.gallery_photo_7, "第七张"));

		listView.setAdapter(new HorizontalLvAdapter(mos, this));

	}
}

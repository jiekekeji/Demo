package com.wh.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.wh.demo.adapter.MainAdapter;
import com.wh.demo.app.ActivityAnimation;
import com.wh.demo.app.CustomDialog;
import com.wh.demo.app.MactionBar;
import com.wh.demo.bean.AcInfo;
import com.wh.demo.download.DownLoader;
import com.wh.demo.view.ListAnim;
import com.wh.demo.view.Mgallery;

@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {

	private List<AcInfo> acInfos;

	@ViewInject(R.id.listview)
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

		initData();

	}

	private void initData() {
		acInfos = new ArrayList<AcInfo>();

		acInfos.add(new AcInfo("自定义ActionBar", MactionBar.class));
		acInfos.add(new AcInfo("动画方式切换activity", ActivityAnimation.class));
		acInfos.add(new AcInfo("自定义对话框", CustomDialog.class));
		acInfos.add(new AcInfo("以动画的方式展示item", ListAnim.class));
		acInfos.add(new AcInfo("gallery的使用", Mgallery.class));
		acInfos.add(new AcInfo("DownLoader.jar多线程下载", DownLoader.class));

		listview.setAdapter(new MainAdapter(acInfos, this));
	}

	@OnItemClick(R.id.listview)
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		startActivity(new Intent(this, acInfos.get(position).getCls()));
	}

}

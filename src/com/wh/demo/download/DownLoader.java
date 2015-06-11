package com.wh.demo.download;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.wh.demo.R;
import com.wh.demo.utils.SPUtils;

@ContentView(R.layout.activity_downloader)
public class DownLoader extends Activity {

	private static final String[] URLS = {
			"http://c.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=6330f0db39c79f3d9becec62dbc8a674/a8ec8a13632762d05d0e119ba2ec08fa513dc6e6.jpg",
			"http://dlsw.baidu.com/sw-search-sp/soft/7b/33461/freeime.1406862029.exe",
			"http://dlsw.baidu.com/sw-search-sp/soft/46/16696/jpwb2015.2.2.10.1423557071.exe" };

	/** 处理下载进度 **/
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			switch (msg.what) {
			case 0:
				int status = (Integer) msg.obj;
				if (DownUtils.isDownloading(status)) {

					if (msg.arg2 < 0) {
						tv1_1.setText("0%");
						tv1_2.setText("0M/0M");
					} else {
						bar1.setIndeterminate(false);
						bar1.setMax(msg.arg2);
						bar1.setProgress(msg.arg1);
						tv1_1.setText(DownUtils.getNotiPercent(msg.arg1,
								msg.arg2));
						tv1_2.setText(DownUtils.getAppSize(msg.arg1) + "/"
								+ DownUtils.getAppSize(msg.arg2));
					}

				} else {

					if (status == DownloadManager.STATUS_FAILED) {
						Log.i("TAG", "下载失败");
					} else if (status == DownloadManager.STATUS_SUCCESSFUL) {
						Log.i("TAG", "下载成功");
					} else {
						Log.i("TAG", "已下载");
					}
				}
				break;
			}
		}
	};

	/** 文件下载完成的广播接收者 **/
	BroadcastReceiver receiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			long reference = intent.getLongExtra(
					DownloadManager.EXTRA_DOWNLOAD_ID, -1);

			DownUtils.openDownload(DownLoader.this,
					SPUtils.get(DownLoader.this, String.valueOf(reference), "")
							.toString());
		}
	};

	/** 标记每次下载 **/
	private long id1, id2, id3;

	/** 下载实例 **/
	private DownloadManager downloadManager;

	@ViewInject(R.id.main_dl_pb1)
	ProgressBar bar1;

	@ViewInject(R.id.main_dl_pb2)
	ProgressBar bar2;

	@ViewInject(R.id.main_dl_pb3)
	ProgressBar bar3;

	@ViewInject(R.id.tv1_1)
	TextView tv1_1;

	@ViewInject(R.id.tv1_2)
	TextView tv1_2;

	private DownloadManagerPro downloadManagerPro;

	private DownloadChangeObserver downloadObserver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

		// 注册下载完成的广播
		registerReceiver(receiver, new IntentFilter(
				DownloadManager.ACTION_DOWNLOAD_COMPLETE));

		downloadManager = (DownloadManager) this
				.getSystemService(Context.DOWNLOAD_SERVICE);

		downloadManagerPro = new DownloadManagerPro(downloadManager);

		downloadObserver = new DownloadChangeObserver();

	}

	/*************** 开始下载 ***************/
	@OnClick(R.id.main_dl_start_btn1)
	public void start1(View view) {
		id1 = DownUtils.startDownLoad(URLS[0], downloadManager, this);
		updateView();
	}

	@OnClick(R.id.main_dl_start_btn2)
	public void start2(View view) {

	}

	@OnClick(R.id.main_dl_start_btn3)
	public void start3(View view) {

	}

	/********** 取消下载 ******************/
	@OnClick(R.id.main_dl_cancel_btn1)
	public void stop1(View view) {
		downloadManager.remove(id1);
	}

	@OnClick(R.id.main_dl_cancel_btn2)
	public void stop2(View view) {
		downloadManager.remove(id2);
	}

	@OnClick(R.id.main_dl_cancel_btn3)
	public void stop3(View view) {
		downloadManager.remove(id3);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}

	public void updateView() {
		int[] bytesAndStatus = downloadManagerPro.getBytesAndStatus(id1);
		handler.sendMessage(handler.obtainMessage(0, bytesAndStatus[0],
				bytesAndStatus[1], bytesAndStatus[2]));
	}

	@Override
	protected void onResume() {
		super.onResume();
		/** observer download change **/
		getContentResolver().registerContentObserver(
				DownloadManagerPro.CONTENT_URI, true, downloadObserver);
	}

	@Override
	protected void onPause() {
		super.onPause();
		getContentResolver().unregisterContentObserver(downloadObserver);
	}

	/** 文件下载的观察者 **/
	class DownloadChangeObserver extends ContentObserver {

		public DownloadChangeObserver() {
			super(handler);
		}

		@Override
		public void onChange(boolean selfChange) {
			updateView();
		}
	}
}

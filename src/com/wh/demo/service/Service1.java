package com.wh.demo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.lidroid.xutils.util.LogUtils;

public class Service1 extends IntentService {

	private static final String TAG = Service1.class.getName();

	// 必须实现
	public Service1() {
		super("Service1");
	}

	/**
	 * 异步执行
	 */
	@Override
	protected void onHandleIntent(Intent intent) {

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogUtils.i("当前线程+" + Thread.currentThread().getName());
		Log.i(TAG, "onHandleIntent");

	}

}

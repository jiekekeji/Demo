package com.wh.demo.cast;

import com.lidroid.xutils.util.LogUtils;
import com.wh.demo.service.Service1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 接收屏幕状态改变的广播
 * 
 * @author tanjieke
 *
 */
public class ScreenBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		LogUtils.i("接收到广播");
		context.startService(new Intent(context, Service1.class));
	}

}

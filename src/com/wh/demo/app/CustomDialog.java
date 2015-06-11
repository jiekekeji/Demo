package com.wh.demo.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.wh.demo.R;

@ContentView(R.layout.activity_custom_dialog)
public class CustomDialog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

	}

	@OnClick(R.id.button1)
	public void open1(View view) {
		startActivity(new Intent(this, Dialog1.class));
	}

	@OnClick(R.id.button2)
	public void open2(View view) {

		final Dialog dialog = new Dialog(this);

		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_two);

		dialog.findViewById(R.id.btn001).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						Toast.makeText(CustomDialog.this, "确定",
								Toast.LENGTH_SHORT).show();

						if (dialog.isShowing()) {
							dialog.dismiss();
						}
					}
				});
		dialog.show();

	}

	@OnClick(R.id.button3)
	public void open3(View view) {
		
		LogUtils.i("button3被点击");
		final Dialog dialog = new Dialog(this);

		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_three);

		dialog.show();
	}

}

package com.wh.demo.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.wh.demo.R;
import com.wh.demo.adapter.Dialog4Adapter;

@ContentView(R.layout.activity_custom_dialog)
public class CustomDialog extends Activity implements OnClickListener {

	private List<String> list;
	private EditText et1;
	private EditText et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);

		// 添加对话框数据
		list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("条目" + i);
		}

	}

	/**
	 * activity dialog样式
	 * 
	 * @param view
	 */
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

		WindowManager.LayoutParams layoutParams = dialog.getWindow()
				.getAttributes();
		layoutParams.width = LayoutParams.MATCH_PARENT;
		layoutParams.height = LayoutParams.WRAP_CONTENT;
		dialog.getWindow().setAttributes(layoutParams);
	}

	@OnClick(R.id.button3)
	public void open3(View view) {

		LogUtils.i("button3被点击");
		final Dialog dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_three);

		dialog.show();
	}

	@OnClick(R.id.button4)
	public void open4(View view) {
		final Dialog dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		View dialogView = getLayoutInflater().inflate(R.layout.dialog_four,
				null);

		ListView listView = (ListView) dialogView.findViewById(R.id.listview);
		listView.setAdapter(new Dialog4Adapter(this, list));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				LogUtils.i("点击了" + list.get(position));
			}
		});

		dialog.setContentView(dialogView);

		dialog.show();
	}

	@OnClick(R.id.button5)
	public void open5(View view) {

		final Dialog dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		View dialogView = getLayoutInflater().inflate(R.layout.dialog_five,
				null);

		et1 = (EditText) dialogView.findViewById(R.id.et1);
		et2 = (EditText) dialogView.findViewById(R.id.et2);

		((Button) dialogView.findViewById(R.id.btn1)).setOnClickListener(this);
		((Button) dialogView.findViewById(R.id.btn2)).setOnClickListener(this);

		dialog.setContentView(dialogView);

		// 设置点击Dialog外部任意区域关闭Dialog
		dialog.setCanceledOnTouchOutside(true);
		dialog.show();

		// 设置大小
		WindowManager.LayoutParams layoutParams = dialog.getWindow()
				.getAttributes();
		layoutParams.width = LayoutParams.MATCH_PARENT;
		layoutParams.height = LayoutParams.WRAP_CONTENT;
		dialog.getWindow().setAttributes(layoutParams);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn1:
			LogUtils.i("点击了确认" + "密码：" + et2.getText().toString() + "用户名："
					+ et1.getText().toString());
			break;
		case R.id.btn2:
			LogUtils.i("点击了取消");
			break;

		default:
			break;
		}
	}

}

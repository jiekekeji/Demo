package com.wh.demo.encrypt;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.wh.demo.R;

/**
 * AES加密解密
 * 
 * @author tanjieke
 *
 */
@ContentView(R.layout.activity_aes)
public class AESActivity extends Activity {

	@ViewInject(R.id.content)
	EditText contentEt;

	@ViewInject(R.id.yiyue)
	EditText yiyueEt;

	@ViewInject(R.id.enContent)
	EditText enContentEt;

	@ViewInject(R.id.md1)
	EditText md1;

	@ViewInject(R.id.md2)
	EditText md2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}

	/**
	 * 加密
	 * 
	 * @param view
	 */
	@OnClick(R.id.btn1)
	public void enContent(View view) {
		String content = contentEt.getText().toString();
		String miyue = yiyueEt.getText().toString();

		if (TextUtils.isEmpty(content) || TextUtils.isEmpty(miyue)) {
			Toast.makeText(this, "请认真输入", Toast.LENGTH_SHORT).show();
			return;
		}

		try {
			enContentEt
					.setText(AESUtils.encrypt(miyue, MD5Utils.toMD5(content)));
			contentEt.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnClick(R.id.btn2)
	public void deContent(View view) {
		String enContent = enContentEt.getText().toString();
		String miyue = yiyueEt.getText().toString();

		if (TextUtils.isEmpty(enContent) || TextUtils.isEmpty(miyue)) {
			Toast.makeText(this, "请认真输入", Toast.LENGTH_SHORT).show();
			return;
		}

		try {
			contentEt.setText(AESUtils.decrypt(miyue, enContent));
			enContentEt.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnClick(R.id.md5)
	public void toMd5(View view) {
		String md1Content = md1.getText().toString();

		if (TextUtils.isEmpty(md1Content)) {
			Toast.makeText(this, "请认真输入", Toast.LENGTH_SHORT).show();
			return;
		}

		try {
			md2.setText(MD5Utils.toMD5(md1Content));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

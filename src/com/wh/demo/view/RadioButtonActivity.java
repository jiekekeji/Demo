package com.wh.demo.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.wh.demo.R;

@SuppressLint("ResourceAsColor")
public class RadioButtonActivity extends Activity implements
		OnCheckedChangeListener {

	RadioButton rbtn001, rbtn002;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_button);

		rbtn001 = (RadioButton) findViewById(R.id.gp_001_rb_001);
		rbtn001.setChecked(true);
		rbtn001.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
				getResources().getDrawable(R.drawable.ic_tui_type_focus));

		rbtn002 = (RadioButton) findViewById(R.id.gp_001_rb_002);
		rbtn002.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
				getResources().getDrawable(R.drawable.ic_tui_type_normal));

		((RadioGroup) findViewById(R.id.gp_001))
				.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.gp_001_rb_001:
			rbtn001.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
					getResources().getDrawable(R.drawable.ic_tui_type_focus));

			rbtn002.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
					getResources().getDrawable(R.drawable.ic_tui_type_normal));
			break;

		case R.id.gp_001_rb_002:
			rbtn002.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
					getResources().getDrawable(R.drawable.ic_tui_type_focus));

			rbtn001.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
					getResources().getDrawable(R.drawable.ic_tui_type_normal));
			break;

		default:
			break;
		}
	}

}

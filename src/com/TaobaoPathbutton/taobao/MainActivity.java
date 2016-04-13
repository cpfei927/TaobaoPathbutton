package com.TaobaoPathbutton.taobao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ComposerLayout clayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		setListener();
	}

	public void initView() {
		// 引用控件
		clayout = (ComposerLayout) findViewById(R.id.testTT);
		clayout.init(
				new int[] { R.drawable.composer_camera, R.drawable.composer_music, R.drawable.composer_place,
						R.drawable.composer_sleep, R.drawable.composer_thought, R.drawable.composer_with },
				R.drawable.composer_button, R.drawable.composer_icn_plus, ComposerLayout.RIGHTCENTER, 180, 300);
	}

	public void setListener() {
		// 点击事件监听，100+0对应composer_camera，100+1对应composer_music……如此类推你有机个按钮就加几个按钮都行。
		OnClickListener clickit = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (v.getId() == 100 + 0) {
					Toast.makeText(MainActivity.this, "打开相机...", Toast.LENGTH_SHORT).show();
				} else if (v.getId() == 100 + 1) {
					Toast.makeText(MainActivity.this, "打开音乐...", Toast.LENGTH_SHORT).show();
				} else if (v.getId() == 100 + 2) {
					Toast.makeText(MainActivity.this, "打开地理位置...", Toast.LENGTH_SHORT).show();
				} else if (v.getId() == 100 + 3) {
					Toast.makeText(MainActivity.this, "打开睡觉模式...", Toast.LENGTH_SHORT).show();
				} else if (v.getId() == 100 + 4) {
					Toast.makeText(MainActivity.this, "打开对话模式...", Toast.LENGTH_SHORT).show();
				} else if (v.getId() == 100 + 5) {
					Toast.makeText(MainActivity.this, "关于我..", Toast.LENGTH_SHORT).show();
				}
			}
		};
		clayout.setButtonsOnClickListener(clickit);

		// 下面几个句测试下父控件,实际开发是可以去掉
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.rlparent);
		rl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "父控件可以被点击!!!", Toast.LENGTH_SHORT).show();
			}
		});

	}
}

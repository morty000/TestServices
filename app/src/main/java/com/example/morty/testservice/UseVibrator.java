package com.example.morty.testservice;
/***/
	import android.os.Bundle;
	import android.os.Vibrator;
	import android.app.Activity;
	import android.view.View;
	import android.content.Context;
	import android.widget.Button;
/**���ʵ���ֻ�������ʾVibrator*/
	public class UseVibrator extends Activity{
			/***/
		private Button vibrator_1_Button;
		private Button vibrator_2_Button;
		private Button vibrator_3_Button;
		private Vibrator vibrator;
			/***/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.use_vibrator);
			vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
			getWidget();
			registerWidget();
		}
		
		public void getWidget(){
			vibrator_1_Button = (Button) findViewById(R.id.button_vibrator_1);
			vibrator_2_Button = (Button) findViewById(R.id.button_vibrator_2);
			vibrator_3_Button = (Button) findViewById(R.id.button_vibrator_3);
		}
		
		public void registerWidget(){
			vibrator_1_Button.setOnClickListener(vibrator_1);
			vibrator_2_Button.setOnClickListener(vibrator_2);
			vibrator_3_Button.setOnClickListener(vibrator_3);
		}
			/**��һ��*/
		public Button.OnClickListener vibrator_1 = new Button.OnClickListener(){
			public void onClick(View view){
					/**long���������������ĺ���*/
					/**��һ��������ʾ�ȴ�100�����ʼ��*/
					/**�ڶ���������ʾ��100�����ֹͣ��*/
				vibrator.vibrate(new long[]{100,100}, 0);
			}
		};
			/**������*/
		public Button.OnClickListener vibrator_2 = new Button.OnClickListener(){
			public void onClick(View view){
				vibrator.vibrate(new long[]{1000,3000,1000,3000}, 0);
			}
		};
			/**������*/
		public Button.OnClickListener vibrator_3 = new Button.OnClickListener(){
			public void onClick(View view){
				vibrator.vibrate(new long[]{1000,1000,1000,2000,1000,300}, 0);
			}
		};
	}

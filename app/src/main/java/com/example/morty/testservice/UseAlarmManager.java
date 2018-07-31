package com.example.morty.testservice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.app.AlarmManager;

import java.util.Calendar;

public class UseAlarmManager extends Activity {
		/**��������*/
	private Button startAlarm;
	private Button shutdownAlarm;
	private AlarmManager alarm;
	
		/**����Activity*/
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usealarmmanager);
		getWidget();
	}
	public void getWidget(){
		startAlarm = (Button)findViewById(R.id.startAlarm);
		shutdownAlarm = (Button)findViewById(R.id.shutDowntAlarm);
		alarm = (AlarmManager)getSystemService(ALARM_SERVICE);// ��ȡAlarmManager
	}

		/**��������*/
	public Button.OnClickListener startAlarms = new Button.OnClickListener(){
		public void onClick(View view){
				// ����10����������
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());// ����calendar��ʱ��
			calendar.add(Calendar.SECOND, 10);
			
			alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), null);
		}
	};

}

package com.example.morty.testservice;

	import android.content.Intent;
    import android.os.Build;
    import android.os.Bundle;
	import android.app.Activity;
	import android.app.Notification;
	import android.app.NotificationManager;
	import android.app.PendingIntent;
	import android.net.Uri;
	import android.media.RingtoneManager;
    import android.support.annotation.RequiresApi;
    import android.widget.Button;
	import android.view.View;

/**ʹ��notification*/
	public class UseNotification extends Activity {
			/**�������*/
		private Button textButton;
		private Button soundButton;// ����֪ͨ
		private Button vibrateButton;// ��֪ͨ
		private Button ledButton;// led֪ͨ
		private Button offButton;// �ر�֪ͨ
		NotificationManager notificationManager;
			/**����Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.notification);
			getComment();
			registerComment();
		}
			/**��ȡ����*/
		public void getComment(){
				/**��ȡNotification����*/
			notificationManager = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
			textButton = (Button)findViewById(R.id.notificationMessage);
			soundButton =(Button)findViewById(R.id.notificationSound);
			vibrateButton = (Button)findViewById(R.id.notificationVibrate);
			ledButton = (Button)findViewById(R.id.notificationLED);
			offButton = (Button)findViewById(R.id.offnotification);
		}
			/**ע�����*/
		public void registerComment(){
			textButton.setOnClickListener(notificationMessage);
			soundButton.setOnClickListener(notificationSound);
			vibrateButton.setOnClickListener(notificationVibrate);
			ledButton.setOnClickListener(notificationLed);
			offButton.setOnClickListener(notificationOff);
		}
		public Button.OnClickListener notificationMessage = new Button.OnClickListener(){
			@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View view){
//				Notification notification = new Notification();// ����Notification����
//				notification.icon = R.drawable.icon;
//				notification.tickerText = "This is text notication";// ����֪ͨ��Ϣ
//					/**����֪ͨ���Intent�������ӵ��������ڵ�ǰҳ��*/
				PendingIntent intent = PendingIntent
					.getActivity(UseNotification.this,
							0, new Intent(UseNotification.this,UseNotification.class)
							, 0);
					/**����֪ͨ��Ϣ*/
//				notification.setLatestEventInfo(UseNotification.this
//						,"Notification","Content of Notification Demo",intent);
				Notification notification = new Notification.Builder(UseNotification.this)
						.setContentTitle("Notification")
						.setContentText("This is text notication")
						.setContentIntent(intent)
						.setSmallIcon(R.drawable.icon)
						.build();
					/**ִ��֪ͨ*/
				notificationManager.notify(0, notification);
			}
		};
		public Button.OnClickListener notificationSound = new Button.OnClickListener(){
			public void onClick(View view){
					/**����֪ͨ����*/
				Notification notification = new Notification();
					/**��ȡϵͳ��ǰ����*/
				String ringName = RingtoneManager.getActualDefaultRingtoneUri(
						UseNotification.this, RingtoneManager.TYPE_RINGTONE)
						.toString();
					/**����ϵͳ��ǰ����Ϊ��֪ͨ������*/
				notification.sound = Uri.parse(ringName);
					/**ִ��֪ͨ*/
				notificationManager.notify(0,notification);
			}
		};
			/**��֪ͨ*/
		public Button.OnClickListener notificationVibrate = new Button.OnClickListener(){
			public void onClick(View view){
				Notification notification = new Notification();// ����Notification����
				notification.vibrate = new long[] {0, 100, 200, 300};// ����֪ͨ��ģʽ
				notificationManager.notify(0,notification);// ִ��֪ͨ
			}
		};
			/**LED֪ͨ*/
		public Button.OnClickListener notificationLed = new Button.OnClickListener(){
			public void onClick(View view){
				Notification notification = new Notification();// ����Notification����
				notification.ledOnMS = 300;// ����led��ʼ�����ʱ��
				notification.ledOffMS = 1000;// ���ùر�ʱ������ʱ��
				notificationManager.notify(0,notification);// ִ��֪ͨ
			}
		};
			/**�ر�֪ͨ*/
		public Button.OnClickListener notificationOff = new Button.OnClickListener(){
			public void onClick(View view){
				notificationManager.cancel(0);// �ر�֪ͨ
			}
		};
	}

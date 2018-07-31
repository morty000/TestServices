package com.example.morty.testservice;
/**�����*/
	import android.view.View;
	import android.os.Bundle;
	import android.app.Activity;
	import android.content.Intent;
	import android.widget.Button;
/**ʹ��Broadcast,����һ�����͹㲥����*/
	public class UseBroadcast extends Activity{
			/**��������*/
		private Button sendBroadcast;
			/**����Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.broadcast);// ʹ�ò����ļ�
			getView();
			sendBroadcast.setOnClickListener(sendBroadcastClick);// ����¼�����
		}
		public void getView(){
			sendBroadcast = (Button)findViewById(R.id.sendBroadcast);
		}
			/**�����¼�����*/
		public Button.OnClickListener sendBroadcastClick = new Button.OnClickListener(){
			public void onClick(View view){
				Intent intent = new Intent();// ������ͼ
				intent.putExtra("CONTENT",  "This is a Braodcast demo");// ���ù㲥������
				intent.setAction("lovefang.stadyService");// ���ù㲥��Action
				sendBroadcast(intent);
			}
		};
		
	}

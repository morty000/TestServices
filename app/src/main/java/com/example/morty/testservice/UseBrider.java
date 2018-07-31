package com.example.morty.testservice;
/**�����*/
	import android.app.Activity;
	import android.content.ComponentName;
	import android.content.Context;
	import android.content.Intent;
	import android.content.ServiceConnection;
	import android.os.Bundle;
	import android.os.IBinder;
	import android.util.Log;

/**ͨ��bindService��unBindSerivce�ķ�ʽ�����ͽ�������*/
	public class UseBrider extends Activity {
			/**��������*/
		CountService countService;
	
		@Override
		public void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(new UseBriderFace(this));
		    Intent intent = new Intent(UseBrider.this,CountService.class);
		    	/**����Activity��ʼ����*/
		    bindService(intent, conn, Context.BIND_AUTO_CREATE);
		    
		}
		private ServiceConnection conn = new ServiceConnection(){
				/**��ȡ�������ʱ�Ĳ���*/ 
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				countService = ((CountService.ServiceBinder)service).getService();
				
			}
				/**�޷���ȡ���������ʱ�Ĳ���*/
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				countService =null;
			}
			
			
		};
		protected void onDestroy(){
			super.onDestroy();
			this.unbindService(conn);
			Log.v("MainStadyServics", "out");
		}
	}

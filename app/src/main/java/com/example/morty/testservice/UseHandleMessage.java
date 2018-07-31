package com.example.morty.testservice;
/***/
	import android.os.Bundle;
	import android.os.Handler;
	import android.os.Message;
	import android.app.Activity;
	import android.util.Log;
	import android.widget.Toast;
	import android.widget.ProgressBar;

/**ʹ��Handle��Message*/
	public class UseHandleMessage extends Activity{
			/**�������*/
		protected final static int PROGRESS_END = -1;
		private ProgressBar progressbar;// ������
		protected static int progress;
		
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.use_handleandmessage);
			progressbar = (ProgressBar)findViewById(R.id.bar);
			startProgressBar();
		}
			/**����Handle*/
		protected Handler handler = new Handler(){
			public void handleMessage(Message msg){
				switch (msg.what){
					case PROGRESS_END:
						Toast.makeText(UseHandleMessage.this, "loading finished"
								, Toast.LENGTH_LONG).show();
						break;
					default:
						progressbar.setProgress(msg.what);
				}
			};
		};
			/**�����߳�*/
		private void startProgressBar(){
			new Thread(){
				public void run(){
					while(progress <100){
						try{
							Thread.sleep(100);
							countProgress();
							progress ++;
							Log.v("UseHandleMessage","Count"+progress);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					endProgress();
				}
			}.start();
		}
			/***/
		private void countProgress(){
				/**��ȡMessage����*/
			Message msg = Message.obtain();
				/**���û��Զ������Ϣcode��װ��Message������*/
			msg.what = progress;
				/**������Ϣ*/
			handler.sendMessage(msg);
		}
			/***/
		private void endProgress(){
			Message msg = Message.obtain();
			msg.what = PROGRESS_END;
			handler.sendMessage(msg);
		}
	}

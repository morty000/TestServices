package com.example.morty.testservice;
/**�����*/
	import android.app.Service;// �������
	import android.os.IBinder;
	import android.os.Binder;
	import android.content.Intent;
	import android.util.Log;
/**�����ķ���*/
	public class CountService extends Service{
			/**��������*/
		boolean threadDisable ;
		int count;
		
		public IBinder onBind(Intent intent){
			return null;
		}
		public void onCreate(){
			super.onCreate();
				/**����һ���̣߳�ÿ���������һ�����ڿ���̨����Log���*/
			new Thread(new Runnable(){
				public void run(){
					while(!threadDisable){
						try{
							Thread.sleep(1000);
						}catch(InterruptedException e){
							
						}
						count++;
						Log.v("CountService","Count is"+getConunt());
					}
				}
			}).start();
		}
		public void onDestroy(){
			super.onDestroy();
				/**����ֹͣʱ����ֹ��������*/
			this.threadDisable = true;
		}
		public int getConunt(){
			return count;
		}
		class ServiceBinder extends Binder{
			public CountService getService(){
				return CountService.this;
			}
		}
	}

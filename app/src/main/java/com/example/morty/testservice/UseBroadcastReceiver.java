package com.example.morty.testservice;
/***/
	import android.content.BroadcastReceiver;
	import android.content.Context;
	import android.content.Intent;
	import android.util.Log;
/**����һ�����չ㲥����*/
	public class UseBroadcastReceiver extends BroadcastReceiver{
		public void onReceive(Context context, Intent intent){
			Log.v("UseBroadcastReceiver", "I get a message");
		}
	}

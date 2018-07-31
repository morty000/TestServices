package com.example.morty.testservice;
/***/
	import android.os.Bundle;
	import android.os.AsyncTask;
	import android.view.View;
	import android.widget.Button;
	import android.widget.TextView;
	import android.app.Activity;
	import android.app.ProgressDialog;
/***/
	public class UseAsyncTask extends Activity{
			/**��������*/
		private Button button;
		private TextView text;
			/**����Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.use_async);
			getWidget();
			button.setOnClickListener(asnyc);
		}
			/**�������*/
		private void getWidget(){
			button = (Button) findViewById(R.id.button_async);
			text = (TextView) findViewById(R.id.text_async);
		}
			/**��������*/
		public Button.OnClickListener asnyc = new Button.OnClickListener(){
			
			public void onClick(View view){
					/**��ȡLoadTast����*/
				LoadTast loadtast = new LoadTast();
					/**ִ���첽task*/
				loadtast.execute();
			}
		};
			/**�̳���AsyncTast��LoadTast*/
		public class LoadTast extends AsyncTask<Void, Integer, String>{
			
			private ProgressDialog progressDialog;
			
			protected String doInBackground(Void... params) {
					/**ģ��һ�����ٵĽ���*/
				int sum = 1;
				while(sum <= 100 ){
					try{
						Thread.sleep(100);
						publishProgress(sum);
						sum ++;
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				return "Loading Fibished..";
			}
			
			public void onPreExecute(){
					/**����һ���Ի�����ʾ*/
				progressDialog = ProgressDialog.show(UseAsyncTask.this,
						"AsyncTask Demo", "Loading....", true);
			}
			
			public void onProgressUpdate(Integer... values){
					/**����publishProgress���ݹ�����ֵ���и�ʽ������ʾ��TextView���*/
				text.setText(values[0] +"%");
			}
			public void onPostExecute(String result){
					/**���ضԻ���*/
				progressDialog.dismiss();
					/**����onInBackground���ص�result���õ�TextView���*/
				text.setText(result);
			}
			
		};
	}

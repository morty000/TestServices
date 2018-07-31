package com.example.morty.testservice;
/**�����*/
	import android.os.Bundle;
	import android.app.Activity;
	import android.net.Uri;
	import android.view.View;
	import android.content.Intent;
	import android.widget.Button;
	import android.widget.EditText;
/**��β���绰*/
	public class UseActionCall extends Activity{
			/**��������*/
		private Button call_Button;
		private EditText etext_callnumber;
			/**����Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.use_action_call);
			getWidget();
			call_Button.setOnClickListener(call_Phone);
		}
		public void getWidget(){
			call_Button = (Button) findViewById(R.id.button_call);
			etext_callnumber = (EditText) findViewById(R.id.etext_action_call);
		}
			/**��ȡ�ֻ�״̬��ҪȨ��android.premission,CALL_PHONE*/
		private Button.OnClickListener call_Phone= new Button.OnClickListener(){
			public void onClick(View view){
				String phoneNum = etext_callnumber.getText().toString();
				Uri uri = Uri.parse("tel:"+phoneNum);// ���绰�������ΪUri
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_CALL);// ��intent��Action��Ϊcall
				intent.setData(uri);// ��Uri������intent����
				startActivity(intent);// ��ʼͨ��
			}
		};
		
	}

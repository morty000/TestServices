package com.example.morty.testservice;
/**�����*/
	import android.os.Bundle;
	import android.app.Activity;
	import android.app.Service;
	import android.view.View;
	import android.widget.Button;
	import android.widget.TextView;
	import android.content.ContentResolver;//This class provides applications access to the content model.
	import android.telephony.TelephonyManager;
	import android.util.Log;
/**��ȡ�ֻ���״̬*/
	public class UsePhoneState extends Activity{
			/**��������*/
		private ContentResolver cr;
		private Button getStateButton;// ������ȡ�û����ֻ�״̬
			/**����Activity*/
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.usephonestate);
			
			cr = getContentResolver();
			Log.v("UsePhonestate","cr = getContentResolver()");
			Log.v("UsePhonestate","setContentView");
			getStateButton = (Button) findViewById(R.id.button_getphonestate);
			Log.v("UsePhonestate","getStateButton");
			getStateButton.setOnClickListener(getState);
			Log.v("UsePhonestate","getStateButton.setOnClickListener");
		}
		private Button.OnClickListener getState = new Button.OnClickListener(){
			public void onClick(View view){
					/**���TelephonyManager����*/
				TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Service.TELEPHONY_SERVICE);
					/**��ȡ�������缶��*/
				String teleCode = telephonyManager.getNetworkCountryIso();
					/**��ȡ�������繫˾����*/
				String teleComCode = telephonyManager.getNetworkOperator();
					/**��ȡ�������繫˾����*/
				String teleComName = telephonyManager.getNetworkOperatorName();
					/**��ȡ�ж�ͨ������*/
				int TypeCode = telephonyManager.getPhoneType();
				
				String type = "";
				
				switch(TypeCode){
					case TelephonyManager.PHONE_TYPE_NONE:
						type = "PHONE_TYPE_NONE";
						break;
					case TelephonyManager.PHONE_TYPE_GSM:
						type = "PHONE_TYPE_GSM";
						break;
					case TelephonyManager.PHONE_TYPE_CDMA:
						type = "PHONE_TYPE_CDMA";
						break;
				}
					/**��ȡ��������*/
				int netTypeCode = telephonyManager.getNetworkType();
				String netType = "NETWORK_TYPE_UNKNOW";
				switch(netTypeCode){
					case TelephonyManager.NETWORK_TYPE_1xRTT:
						netType = "NETWORK_TYPE_1xRTT";
						break;
					case TelephonyManager.NETWORK_TYPE_CDMA:
						netType = "NETWORK_TYPE_CDMA";
						break;
					case TelephonyManager.NETWORK_TYPE_EDGE:
						netType = "NETWORK_TYPE_EDGE";
						break;
					case TelephonyManager.NETWORK_TYPE_EVDO_0:
						netType = "NETWORK_TYPE_EVDO_0";
						break;
					case TelephonyManager.NETWORK_TYPE_EVDO_A:
						netType = "NETWORK_TYPE_EVDO_A";
						break;
					case TelephonyManager.NETWORK_TYPE_GPRS:
						netType = "NETWORK_TYPE_GPRS";
						break;
					case TelephonyManager.NETWORK_TYPE_HSDPA:
						netType = "NETWORK_TYPE_HSDPA";
						break;
					case TelephonyManager.NETWORK_TYPE_HSPA:
						netType = "NETWORK_TYPE_HSPA";
						break;
					case TelephonyManager.NETWORK_TYPE_HSUPA:
						netType = "NETWORK_TYPE_HSUPA";
						break;
					case TelephonyManager.NETWORK_TYPE_IDEN:
						netType = "NETWORK_TYPE_IDEN";
						break;
					case TelephonyManager.NETWORK_TYPE_UMTS:
						netType = "NETWORK_TYPE_UMTS";
						break;
					default:
						break;
				}
				
					/**��ȡ����״̬*/
				boolean roamStatusCode = telephonyManager.isNetworkRoaming();
				String roamStatus = "NOT ROAMINF";
				if(roamStatusCode){
					roamStatus = "ROAMING";
				}
				
					/**��ȡ�ֻ�Ψһ��ʶ*/
				String imei = telephonyManager.getDeviceId();
					/**��ȡ�ֻ�IMEI SV*/
				String imeiSV = telephonyManager.getDeviceSoftwareVersion();
					/**��ȡ�ֻ�IMSI*/
				String imsi = telephonyManager.getSubscriberId();
				
					/**��������*/
				String statusCode = android.provider.Settings.System.getString(cr,
						android.provider.Settings.System.BLUETOOTH_ON);
				String bulettothStatus = "";
				if(statusCode.equals("1")){
					bulettothStatus = "ENABLE";
				}else{
					bulettothStatus = "DISABLE";
				}
				
					/**����ģʽ�Ƿ��*/
				statusCode = android.provider.Settings.System.getString(cr,
						android.provider.Settings.System.AIRPLANE_MODE_ON);
				
				String AirplaneStatus = "";
				if(statusCode.equals("1")){
					AirplaneStatus = "ENABLE";
				}else{
					AirplaneStatus = "DISABLE";
				}
				
					/**��������ģʽ�Ƿ��*/
				statusCode = android.provider.Settings.System.getString(cr,
						android.provider.Settings.System.DATA_ROAMING);
				String dataRoamStatus = "";
				if(statusCode.equals("1")){
					dataRoamStatus = "ENABLE";
				}else{
					dataRoamStatus = "DISABLE";
				}
				TextView txt = (TextView) findViewById(R.id.text_showphonestate);
				StringBuilder sb = new StringBuilder();
				sb.append("teleCode: "+teleCode+"\n");
				sb.append("teleComCode: "+teleComCode+"\n");
				sb.append("teleComName: "+teleComName+"\n");
				sb.append("type: "+type+"\n");
				sb.append("netType: "+netType+"\n");
				sb.append("roamStatus: "+roamStatus+"\n");
				sb.append("imei: "+imei+"\n");
				sb.append("imeiSV: "+imeiSV+"\n");
				sb.append("imsi: "+imsi+"\n");
				sb.append("bulettothStatus: "+bulettothStatus+"\n");
				sb.append("AirplaneStatus: "+AirplaneStatus+"\n");
				sb.append("dataRoamStatus: "+dataRoamStatus+"\n");
				
				txt.setText(sb.toString());
			}
		};
	}

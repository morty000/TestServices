package com.example.morty.testservice;
/**�����*/
	import android.view.View;
	import android.content.Context;
	import android.graphics.Canvas;
	import android.graphics.Color;
	import android.graphics.Paint;
	
	
	public class UseBriderFace extends View{
			/**��������*/
		public UseBriderFace(Context context){
			super(context);
		}
		public void onDraw(Canvas canvas){
			canvas.drawColor(Color.WHITE);//����ɫ����
				/**��������*/
			Paint textPaint = new Paint();
			textPaint.setColor(Color.RED);
			textPaint.setTextSize(30);
			canvas.drawText("ʹ�ð󶨷���", 10, 30, textPaint);
			textPaint.setColor(Color.GREEN);
			textPaint.setTextSize(18);
			canvas.drawText("ʹ�ð󶨷�������Activity�رպ�", 20, 60, textPaint);
			canvas.drawText("�󶨵ķ���Ҳ��ر�", 5, 80, textPaint);

			textPaint.setColor(Color.BLUE);
			textPaint.setTextSize(40);
			canvas.drawText("nothing",1,1,textPaint);
			
		}
	}

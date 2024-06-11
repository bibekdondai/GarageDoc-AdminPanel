
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		dashboard
	 *	@date 		Wednesday 05th of June 2024 09:02:46 PM
	 *	@title 		Admin Panel
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */


	package com.example.garagedoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class mark_as_read_notification__activity extends Activity {

	
	private View _bg__mark_as_read_notification__ek2;
	private TextView home_ek9;
	private TextView account_ek1;
	private TextView notification_ek15;
	private TextView book_appointment_ek1;
	private ImageView home_ek10;
	private ImageView plus_math_ek1;
	private ImageView notification_ek16;
	private ImageView notification_ek17;
	private ImageView male_user_ek1;
	private View rectangle_5_ek1;
	private View rectangle_7_ek1;
	private TextView _25__discount_on_oil_change__ek1;
	private View rectangle_6_ek1;
	private TextView your_vehiche_is_on_bayarea__ek1;
	private TextView notification_ek18;
	private ImageView notification_ek19;
	private TextView your_vehicle_is_ready_to_pickup__ek1;
	private TextView home_ek11;
	private TextView notification_ek20;
	private TextView call_ek7;
	private TextView setting_ek7;
	private ImageView vector_ek36;
	private ImageView vector_ek37;
	private ImageView vector_ek38;
	private ImageView vector_ek39;
	private ImageView vector_ek40;
	private TextView home_ek12;
	private TextView notification_ek21;
	private TextView call_ek8;
	private TextView setting_ek8;
	private ImageView vector_ek41;
	private ImageView vector_ek42;
	private ImageView vector_ek43;
	private ImageView vector_ek44;
	private ImageView vector_ek45;
	private TextView home_ek13;
	private TextView notification_ek22;
	private TextView call_ek9;
	private TextView setting_ek9;
	private ImageView vector_ek1;
	private ImageView vector_ek20;
	private ImageView vector_ek4;
	private ImageView vector_ek49;
	private ImageView vector_ek50;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mark_as_read_notification_);

		
		_bg__mark_as_read_notification__ek2 = (View) findViewById(R.id._bg__mark_as_read_notification__ek2);
		home_ek9 = (TextView) findViewById(R.id.home_ek9);
		account_ek1 = (TextView) findViewById(R.id.account_ek1);
		notification_ek15 = (TextView) findViewById(R.id.notification_ek15);
		book_appointment_ek1 = (TextView) findViewById(R.id.book_appointment_ek1);
		home_ek10 = (ImageView) findViewById(R.id.home_ek10);
		plus_math_ek1 = (ImageView) findViewById(R.id.plus_math_ek1);
		notification_ek16 = (ImageView) findViewById(R.id.notification_ek16);
		notification_ek17 = (ImageView) findViewById(R.id.notification_ek17);
		male_user_ek1 = (ImageView) findViewById(R.id.male_user_ek1);
		rectangle_5_ek1 = (View) findViewById(R.id.rectangle_5_ek1);
		rectangle_7_ek1 = (View) findViewById(R.id.rectangle_7_ek1);
		_25__discount_on_oil_change__ek1 = (TextView) findViewById(R.id._25__discount_on_oil_change__ek1);
		rectangle_6_ek1 = (View) findViewById(R.id.rectangle_6_ek1);
		your_vehiche_is_on_bayarea__ek1 = (TextView) findViewById(R.id.your_vehiche_is_on_bayarea__ek1);
//		notification_ek20 = (TextView) findViewById(R.id.notification_ek20);
//		notification_ek20 = (ImageView) findViewById(R.id.notification_ek20);
		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		your_vehicle_is_ready_to_pickup__ek1 = (TextView) findViewById(R.id.your_vehicle_is_ready_to_pickup__ek1);
		vector_ek4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Open the setting activity
				Intent settingIntent = new Intent(mark_as_read_notification__activity.this, setting_activity.class);
				startActivity(settingIntent);
			}
		});

//		vector_ek20.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// Open the notification activity
//				Intent notificationIntent = new Intent(mark_as_read_notification__activity.this, notification_activity.class);
//				startActivity(notificationIntent);
//			}
//		});
		vector_ek1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// Open the notification activity
				Intent notificationIntent = new Intent(mark_as_read_notification__activity.this, dashboard_activity.class);
				startActivity(notificationIntent);

			}
		});




		
		//custom code goes here
	
	}
}
	
	
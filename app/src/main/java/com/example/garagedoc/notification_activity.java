
	 
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
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;

public class notification_activity extends Activity {

	
	private View _bg__notification_ek8;
	private TextView home_ek6;
	private TextView account;
	private TextView notification_ek9;
	private TextView book_appointment;
	private ImageView home_ek7;
	private ImageView plus_math;
	private ImageView notification_ek10;
	private ImageView notification_ek11;
	private ImageView male_user;
	private View rectangle_5;
	private View rectangle_7;
	private TextView _25__discount_on_oil_change_;
	private View rectangle_6;
	private TextView your_vehiche_is_on_bayarea_;
	private TextView notification_ek12;
	private ImageView notification_ek13;
	private TextView _mark_all_as_read;
	private TextView your_vehicle_is_ready_to_pickup_;
	private TextView home_ek8;
	private TextView notification_ek14;
	private TextView call_ek6;
	private TextView setting_ek6;
	private ImageView vector_ek20;
	private ImageView vector_ek1;
	private ImageView vector_ek33;
	private ImageView vector_ek4;
	private ImageView vector_ek35;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);

		


		rectangle_5 = (View) findViewById(R.id.rectangle_5);
		rectangle_7 = (View) findViewById(R.id.rectangle_7);
		_25__discount_on_oil_change_ = (TextView) findViewById(R.id._25__discount_on_oil_change_);
		rectangle_6 = (View) findViewById(R.id.rectangle_6);
		your_vehiche_is_on_bayarea_ = (TextView) findViewById(R.id.your_vehiche_is_on_bayarea_);

		vector_ek20= (ImageView) findViewById(R.id.vector_ek20);
		_mark_all_as_read = (TextView) findViewById(R.id._mark_all_as_read);
		your_vehicle_is_ready_to_pickup_ = (TextView) findViewById(R.id.your_vehicle_is_ready_to_pickup_);

		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);

		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);













//		_mark_all_as_read.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent markAsReadIntent = new Intent(notification_activity.this, mark_as_read_notification__activity.class);
//				startActivity(markAsReadIntent);
//			}
//		});
		vector_ek4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Open the setting activity
				Intent settingIntent = new Intent(notification_activity.this, setting_activity.class);
				startActivity(settingIntent);
			}
		});

		vector_ek20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Open the notification activity
				Intent notificationIntent = new Intent(notification_activity.this, notification_activity.class);
				startActivity(notificationIntent);
			}
		});
		vector_ek1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// Open the notification activity
				Intent notificationIntent = new Intent(notification_activity.this, dashboard_activity.class);
				startActivity(notificationIntent);

			}
		});

		
		
		//custom code goes here
	
	}
}
	
	
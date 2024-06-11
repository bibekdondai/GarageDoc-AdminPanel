
	 
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
import android.content.Intent;
import android.widget.ImageView;

public class dashboard_activity extends Activity {


	private View rectangle_1;
	private TextView _logout;
	private TextView garage_doc;
	private View rectangle_3;
	private TextView add_vehicles;
	private TextView s_n;
	private TextView token_time;
	private TextView bike_no;
	private TextView details;
	private TextView s_n_ek1;
	private TextView token_time_ek1;
	private TextView status;
	private ImageView vector;
	private TextView home;
	private TextView notification;
	private TextView call;
	private TextView setting;
	private ImageView vector_ek1;
	private ImageView vector_ek20;
	private ImageView vector_ek3;
	private ImageView vector_ek4;
	private ImageView _vector_ek5;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);



		rectangle_1 = (View) findViewById(R.id.rectangle_1);
		_logout = (TextView) findViewById(R.id._logout);
		garage_doc = (TextView) findViewById(R.id.garage_doc);

		s_n = (TextView) findViewById(R.id.s_n);
		token_time = (TextView) findViewById(R.id.token_time);
		bike_no = (TextView) findViewById(R.id.bike_no);
		details = (TextView) findViewById(R.id.details);
		s_n_ek1 = (TextView) findViewById(R.id.s_n_ek1);
		token_time_ek1 = (TextView) findViewById(R.id.token_time_ek1);
		status = (TextView) findViewById(R.id.status);
		_logout= (TextView) findViewById(R.id._logout);


		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);

		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);


		// Set click listeners
		if (home != null) {
			home.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// Handle click event for home
					Intent homeIntent = new Intent(dashboard_activity.this, login_activity.class);
					startActivity(homeIntent);
				}
			});
		}





		if (setting != null) {
			setting.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// Handle click event for setting
					// Add your code here
				}
			});
		}
		vector_ek4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Open the setting activity
				Intent settingIntent = new Intent(dashboard_activity.this, setting_activity.class);
				startActivity(settingIntent);
			}
		});

		vector_ek20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Open the notification activity
				Intent notificationIntent = new Intent(dashboard_activity.this, notification_activity.class);
				startActivity(notificationIntent);
			}
		});
		vector_ek1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// Open the notification activity
				Intent notificationIntent = new Intent(dashboard_activity.this, dashboard_activity.class);
				startActivity(notificationIntent);

			}
		});
		_logout.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// Open the notification activity
				Intent notificationIntent = new Intent(dashboard_activity.this, login_activity.class);
				startActivity(notificationIntent);

			}
		});





		// Add any additional code specific to your activity here
	}
}



	
	
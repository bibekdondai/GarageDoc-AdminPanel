
	 
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

public class status_of_vehicles_activity extends Activity {

	
	private View _bg__status_of_vehicles_ek2;
	private View rectangle_1_ek2;
	private TextView _10_59;
	private ImageView wi_fi;
	private ImageView empty_battery;
	private ImageView signal;
	private TextView garage_doc_ek2;
	private TextView ca;
	private View rectangle_75;
	private View rectangle_76;
	private TextView pending;
	private View rectangle_77;
	private View rectangle_78;
	private TextView process;
	private TextView delivered;
	private View rectangle_79;
	private TextView cancelled;
	private TextView home_ek1;
	private TextView notification_ek1;
	private TextView call_ek1;
	private TextView setting_ek1;
	private ImageView vector_ek1;
	private ImageView vector_ek20;
	private ImageView vector_ek8;
	private ImageView vector_ek4;
	private ImageView _vector_ek10;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.status_of_vehicles);

		
		_bg__status_of_vehicles_ek2 = (View) findViewById(R.id._bg__status_of_vehicles_ek2);
		rectangle_1_ek2 = (View) findViewById(R.id.rectangle_1_ek2);

		garage_doc_ek2 = (TextView) findViewById(R.id.garage_doc_ek2);
		ca = (TextView) findViewById(R.id.ca);
		rectangle_75 = (View) findViewById(R.id.rectangle_75);
		rectangle_76 = (View) findViewById(R.id.rectangle_76);
		pending = (TextView) findViewById(R.id.pending);
		rectangle_77 = (View) findViewById(R.id.rectangle_77);
		rectangle_78 = (View) findViewById(R.id.rectangle_78);
		process = (TextView) findViewById(R.id.process);
		delivered = (TextView) findViewById(R.id.delivered);
		rectangle_79 = (View) findViewById(R.id.rectangle_79);
		cancelled = (TextView) findViewById(R.id.cancelled);

		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);

		
		vector_ek4.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	
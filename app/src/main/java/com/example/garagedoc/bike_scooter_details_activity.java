
	 
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

public class bike_scooter_details_activity extends Activity {

	
	private View _bg__bike_scooter_details_ek2;
	private View rectangle_1_ek4;
	private TextView garage_doc_ek4;
	private View rectangle_93_ek1;
	private TextView bike_details;
	private TextView bike_model_;
	private TextView number_plate_;
	private TextView choose_bike_color_;
	private View rectangle_97;
	private View rectangle_98;
	private View rectangle_100;
	private View rectangle_99;
	private TextView black;
	private TextView blue;
	private TextView red;
	private TextView orange;
	private View line_21;
	private View line_22;
	private TextView home_ek3;
	private TextView notification_ek3;
	private TextView call_ek3;
	private TextView setting_ek3;
	private ImageView vector_ek16;
	private ImageView vector_ek17;
	private ImageView vector_ek18;
	private ImageView vector_ek19;
	private ImageView vector_ek20;
	private TextView home_ek4;
	private TextView notification_ek4;
	private TextView call_ek4;
	private TextView setting_ek4;
	private ImageView vector_ek21;
	private ImageView vector_ek22;
	private ImageView vector_ek23;
	private ImageView vector_ek24;
	private ImageView vector_ek25;
	private TextView home_ek5;
	private TextView notification_ek5;
	private TextView call_ek5;
	private TextView setting_ek5;
	private ImageView vector_ek1;
	private ImageView vector_ek4;
	private ImageView vector_ek28;
	private ImageView vector_ek29;
	private ImageView _vector_ek30;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.bike_scooter_details);

		
		_bg__bike_scooter_details_ek2 = (View) findViewById(R.id._bg__bike_scooter_details_ek2);
		rectangle_1_ek4 = (View) findViewById(R.id.rectangle_1_ek4);
		garage_doc_ek4 = (TextView) findViewById(R.id.garage_doc_ek4);
		rectangle_93_ek1 = (View) findViewById(R.id.rectangle_93_ek1);
		bike_details = (TextView) findViewById(R.id.bike_details);
		bike_model_ = (TextView) findViewById(R.id.bike_model_);
		number_plate_ = (TextView) findViewById(R.id.number_plate_);
		choose_bike_color_ = (TextView) findViewById(R.id.choose_bike_color_);
		rectangle_97 = (View) findViewById(R.id.rectangle_97);
		rectangle_98 = (View) findViewById(R.id.rectangle_98);
		rectangle_100 = (View) findViewById(R.id.rectangle_100);
		rectangle_99 = (View) findViewById(R.id.rectangle_99);
		black = (TextView) findViewById(R.id.black);
		blue = (TextView) findViewById(R.id.blue);
		red = (TextView) findViewById(R.id.red);
		orange = (TextView) findViewById(R.id.orange);
		line_21 = (View) findViewById(R.id.line_21);
		line_22 = (View) findViewById(R.id.line_22);

		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);

		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);
		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);


	
		
		_vector_ek30.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	
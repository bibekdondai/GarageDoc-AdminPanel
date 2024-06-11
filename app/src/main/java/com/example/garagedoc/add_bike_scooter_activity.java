
	 
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

public class add_bike_scooter_activity extends Activity {


	private View _bg__add_bike_scooter_ek2;
	private TextView ca_ek1;
	private View rectangle_1_ek3;
	private TextView garage_doc_ek3;
	private View rectangle_93;
	private View rectangle_94;
	private View rectangle_95;
	private View rectangle_96;
	private TextView yamaha_alpha;
	private TextView yamaha_fascino;
	private TextView yamaha_mt_15;
	private TextView yamaha_fzs;
	private ImageView back_arrow;
	private TextView home_ek2;
	private TextView notification_ek2;
	private TextView call_ek2;
	private TextView setting_ek2;
	private ImageView vector_ek11;
	private ImageView vector_ek12;
	private ImageView vector_ek13;
	private ImageView vector_ek14;
	private ImageView vector_ek20;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_bike_scooter);

		
		_bg__add_bike_scooter_ek2 = (View) findViewById(R.id._bg__add_bike_scooter_ek2);

		rectangle_1_ek3 = (View) findViewById(R.id.rectangle_1_ek3);
		garage_doc_ek3 = (TextView) findViewById(R.id.garage_doc_ek3);
		rectangle_93 = (View) findViewById(R.id.rectangle_93);
		rectangle_94 = (View) findViewById(R.id.rectangle_94);
		rectangle_95 = (View) findViewById(R.id.rectangle_95);
		rectangle_96 = (View) findViewById(R.id.rectangle_96);
		yamaha_alpha = (TextView) findViewById(R.id.yamaha_alpha);
		yamaha_fascino = (TextView) findViewById(R.id.yamaha_fascino);
		yamaha_mt_15 = (TextView) findViewById(R.id.yamaha_mt_15);
		yamaha_fzs = (TextView) findViewById(R.id.yamaha_fzs);
		back_arrow = (ImageView) findViewById(R.id.back_arrow);


		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);


		
		vector_ek20.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), notification_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		//custom code goes here
	
	}
}
	
	
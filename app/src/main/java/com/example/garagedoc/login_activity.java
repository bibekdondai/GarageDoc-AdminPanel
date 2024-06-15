
	 
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
	import android.widget.ImageView;
	import android.widget.TextView;

public class login_activity extends Activity {

	
	private View _bg__login_ek2;
	private ImageView ellipse_1;
	private TextView garage_doc_ek1;
	private ImageView black_and_white_modern_typographic_simple_virus_apparel_logo__1__1;
	private View rectangle_1_ek1;
	private TextView username;
	private View rectangle_2;
	private TextView password;
	private View rectangle_2_ek1;
	private TextView submit;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		

		ellipse_1 = (ImageView) findViewById(R.id.ellipse_1);
		garage_doc_ek1 = (TextView) findViewById(R.id.garage_doc_ek1);
		black_and_white_modern_typographic_simple_virus_apparel_logo__1__1 = (ImageView) findViewById(R.id.black_and_white_modern_typographic_simple_virus_apparel_logo__1__1);
		rectangle_1_ek1 = (View) findViewById(R.id.rectangle_1_ek1);
		username = (TextView) findViewById(R.id.username);
		rectangle_2 = (View) findViewById(R.id.rectangle_2);
		password = (TextView) findViewById(R.id.password);
		rectangle_2_ek1 = (View) findViewById(R.id.rectangle_2_ek1);
		submit = (TextView) findViewById(R.id.submit);




		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					// Start the dashboard_activity
					Intent intent = new Intent(login_activity.this, dashboard_activity.class);
					startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		

	
	}
}
	



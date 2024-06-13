package com.example.garagedoc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class details_to_be_filled_activity extends Activity {

	private View _bg__details_to_be_filled_ek2;
	private TextView ca_ek2;
	private TextView vehicle_details_;
	private TextView vehicle_number_;
	private TextView text;
	private TextView text_ek1;
	private TextView text_ek2;
	private TextView text_ek3;
	private TextView text_ek4;
	private TextView text_ek6;
	private TextView text_ek7;
	private TextView text_ek9;
	private TextView text_ek10;
	private TextView text_ek12;
	private TextView hhhh;
	private TextView text_ek13;
	private TextView text_ek14;
	private TextView text_ek15;
	private TextView text_ek16;
	private TextView text_ek17;
	private TextView text_ek18;
	private TextView text_ek20;
	private TextView text_ek21;
	private TextView text_ek23;
	private TextView text_ek24;
	private TextView text_ek26;
	private TextView hhhh_ek1;
	private TextView text_ek27;
	private View rectangle_80;
	private View line_20;
	private View rectangle_80_ek1;
	private View rectangle_76_ek1;
	private View rectangle_81;
	private View rectangle_82;
	private TextView cancelled_ek1;
	private TextView pending_ek1; // Declaration corrected
	private TextView process_ek1;
	private TextView delivered_ek1;
	private TextView changes_to_be_made_from_showroom_side;
	private View rectangle_60;
	private TextView pay;
	private TextView home_ek14;
	private TextView notification_ek23;
	private TextView call_ek10;
	private TextView setting_ek10;
	private ImageView vector_ek1;
	private ImageView vector_ek20;
	private ImageView vector_ek53;
	private ImageView vector_ek4;
	private ImageView vector_ek55;
	private ImageView vector_ek56;
	private View rectangle_92;
	private ImageView image_1;
	private TextView add_part_name___services;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_to_be_filled);

		// Initialize your views
		_bg__details_to_be_filled_ek2 = findViewById(R.id._bg__details_to_be_filled_ek2);


		// Example of handling a button click (Cancel)
		Button btnCancel = findViewById(R.id.btn_cancel);
		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action when Cancel button is clicked
				Toast.makeText(details_to_be_filled_activity.this, "Cancel button clicked", Toast.LENGTH_SHORT).show();
			}
		});

		// Example of handling another button click (Accept)
		Button btnAccept = findViewById(R.id.btn_accept);
		btnAccept.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action when Accept button is clicked
				Toast.makeText(details_to_be_filled_activity.this, "Accept button clicked", Toast.LENGTH_SHORT).show();
			}
		});

		// Other initialization or custom logic can go here
	}
}

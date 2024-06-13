package com.example.garagedoc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class dashboard_activity extends Activity {

	private View rectangle_1;
	private TextView _logout;
	private TextView garage_doc;
	private ImageView vector_ek1, vector_ek4, vector_ek20;
	private TableLayout upperTable, lowerTable;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		rectangle_1 = findViewById(R.id.rectangle_1);
		_logout = findViewById(R.id._logout);
		garage_doc = findViewById(R.id.garage_doc);
		vector_ek1 = findViewById(R.id.vector_ek1);
		vector_ek4 = findViewById(R.id.vector_ek4);
		vector_ek20 = findViewById(R.id.vector_ek20);
		upperTable = findViewById(R.id.upper_table);
		lowerTable = findViewById(R.id.lower_table);

		// Set click listeners
		vector_ek4.setOnClickListener(v -> {
			Intent settingIntent = new Intent(dashboard_activity.this, setting_activity.class);
			startActivity(settingIntent);
		});

		vector_ek20.setOnClickListener(v -> {
			Intent notificationIntent = new Intent(dashboard_activity.this, notification_activity.class);
			startActivity(notificationIntent);
		});

		vector_ek1.setOnClickListener(v -> {
			Intent dashboardIntent = new Intent(dashboard_activity.this, dashboard_activity.class);
			startActivity(dashboardIntent);
		});

		_logout.setOnClickListener(v -> {
			Intent logoutIntent = new Intent(dashboard_activity.this, login_activity.class);
			startActivity(logoutIntent);
		});

		// Fetch and display data from Firebase
		fetchAndDisplayData();
	}

	private void fetchAndDisplayData() {
		DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("your_database_path");

		databaseReference.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				int sn = 1;
				for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
					String tokenTime = snapshot.child("token_time").getValue(String.class);
					String bikeNo = snapshot.child("bike_no").getValue(String.class);
					String remarks = snapshot.child("remarks").getValue(String.class);
					String status = snapshot.child("status").getValue(String.class);

					addUpperTableRow(sn, tokenTime, bikeNo, remarks);
					addLowerTableRow(sn, tokenTime, status);

					sn++;
				}
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				// Handle possible errors.
			}
		});
	}

	private void addUpperTableRow(int sn, String tokenTime, String bikeNo, String remarks) {
		TableRow row = new TableRow(this);
		row.addView(createTextView(String.valueOf(sn)));
		row.addView(createTextView(tokenTime));
		row.addView(createTextView(bikeNo));
		row.addView(createTextView(remarks));
		upperTable.addView(row);
	}

	private void addLowerTableRow(int sn, String tokenTime, String status) {
		TableRow row = new TableRow(this);
		row.addView(createTextView(String.valueOf(sn)));
		row.addView(createTextView(tokenTime));
		row.addView(createTextView(status));
		lowerTable.addView(row);
	}

	private TextView createTextView(String text) {
		TextView textView = new TextView(this);
		textView.setText(text);
		textView.setPadding(8, 8, 8, 8);
		return textView;
	}
	public void openDetailsPage(View view) {
		Intent intent = new Intent(this, details_to_be_filled_activity.class);
		startActivity(intent);
	}
}

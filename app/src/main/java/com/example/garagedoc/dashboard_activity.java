package com.example.garagedoc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

		// Fetch and display data from Firestore
		if (isNetworkAvailable()) {
			fetchAndDisplayData();
		} else {
			Toast.makeText(this, "No internet connection. Please try again later.", Toast.LENGTH_LONG).show();
		}
	}

	private void fetchAndDisplayData() {
		FirebaseFirestore db = FirebaseFirestore.getInstance();
		CollectionReference collectionReference = db.collection("bike_details");

		collectionReference.get().addOnCompleteListener(task -> {
			if (task.isSuccessful()) {
				QuerySnapshot querySnapshot = task.getResult();
				if (querySnapshot != null) {
					// Clear the existing rows in the tables
					upperTable.removeViews(1, upperTable.getChildCount() - 1);
					lowerTable.removeViews(1, lowerTable.getChildCount() - 1);

					int sn = 1;
					for (QueryDocumentSnapshot document : querySnapshot) {
						String tokenTime = document.getString("token_for_bike");
						String bikeNo = document.getString("number_plate");
						String remarks = document.getString("remarks");
						String status = document.getString("status");

						addUpperTableRow(sn, tokenTime, bikeNo, remarks);
						addLowerTableRow(sn, tokenTime, bikeNo, status);

						sn++;
					}
				}
			} else {
				// Handle possible errors.
				Toast.makeText(dashboard_activity.this, "Failed to load data.", Toast.LENGTH_SHORT).show();
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

	private void addLowerTableRow(int sn, String tokenTime, String bikeNo, String status) {
		TableRow row = new TableRow(this);
		row.addView(createTextView(String.valueOf(sn)));
		row.addView(createTextView(tokenTime));
		row.addView(createTextView(bikeNo));
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

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}

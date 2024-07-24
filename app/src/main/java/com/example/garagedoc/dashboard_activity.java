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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class dashboard_activity extends Activity {

	private View rectangle_1;
	private TextView _logout;
	private ImageView vector_ek1, vector_ek4, vector_ek20;
	private TableLayout upperTable, lowerTable;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		_logout = findViewById(R.id._logout);
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
			// Optional: Handle click on vector_ek1 if needed
		});

		_logout.setOnClickListener(v -> {
			Intent logoutIntent = new Intent(dashboard_activity.this, login_activity.class);
			startActivity(logoutIntent);
		});

		// Fetch and display data from Realtime Database
		if (isNetworkAvailable()) {
			fetchAndDisplayData();
		} else {
			Toast.makeText(this, "No internet connection. Please try again later.", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onBackPressed() {
		// Handle back press to avoid logging out or unintended navigation
		super.onBackPressed(); // Finish the current activity and go back to the previous activity
	}

	private void addHeaderRow(TableLayout table, String col1, String col2, String col3, String col4, String col5) {
		TableRow headerRow = new TableRow(this);
		headerRow.addView(createTextView(col1));
		headerRow.addView(createTextView(col2));
		headerRow.addView(createTextView(col3));
		headerRow.addView(createTextView(col4));
		headerRow.addView(createTextView(col5));
		table.addView(headerRow);
	}

	private void fetchAndDisplayData() {
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("users");

		ref.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				// Clear existing rows in the tables before adding new data
				upperTable.removeAllViews();
				lowerTable.removeAllViews();

				// Create header rows
				addHeaderRow(upperTable, "S.N", "User", "Token Time", "Bike No.", "Remarks");
				addHeaderRow(lowerTable, "S.N", "User", "Token Time", "Bike No.", "Status");

				int sn = 1;
				for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
					String userId = userSnapshot.getKey();
					DataSnapshot bikesSnapshot = userSnapshot.child("bikes");

					for (DataSnapshot bikeSnapshot : bikesSnapshot.getChildren()) {
						String plateNumber = bikeSnapshot.getKey();
						DataSnapshot servicesSnapshot = bikeSnapshot.child("services");

						for (DataSnapshot serviceSnapshot : servicesSnapshot.getChildren()) {
							String tokenTime = serviceSnapshot.getKey();
							Object value = serviceSnapshot.getValue();

							if (value instanceof Map) {
								Map<String, Object> serviceData = (Map<String, Object>) value;

								// Extract individual data points
								String bikeNo = plateNumber; // Set bikeNo to plateNumber from database
								String remarks = "N/A"; // Set remarks to "N/A"
								String status = (String) serviceData.get("status");

								// Add rows to tables
								addUpperTableRow(sn, userId, tokenTime, bikeNo, remarks);
								addLowerTableRow(sn, userId, tokenTime, bikeNo, status);
								sn++;
							} else {
								// Handle unexpected data format
								Toast.makeText(dashboard_activity.this, "Unexpected data format in serviceSnapshot", Toast.LENGTH_SHORT).show();
							}
						}
					}
				}
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				Toast.makeText(dashboard_activity.this, "Failed to load data.", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void addUpperTableRow(int sn, String userId, String tokenTime, String bikeNo, String remarks) {
		TableRow row = new TableRow(this);
		row.addView(createTextView(String.valueOf(sn)));
		row.addView(createTextView(userId));
		row.addView(createTextView(tokenTime));
		row.addView(createTextView(bikeNo));
		row.addView(createTextView(remarks));
		row.setOnClickListener(v -> openDetailsPage(userId, tokenTime, bikeNo, remarks));
		upperTable.addView(row);
	}

	private void addLowerTableRow(int sn, String userId, String tokenTime, String bikeNo, String status) {
		TableRow row = new TableRow(this);
		row.addView(createTextView(String.valueOf(sn)));
		row.addView(createTextView(userId));
		row.addView(createTextView(tokenTime));
		row.addView(createTextView(bikeNo));
		row.addView(createTextView(status));
		row.setOnClickListener(v -> openDetailsPage(userId, tokenTime, bikeNo, "N/A"));
		lowerTable.addView(row);
	}

	private TextView createTextView(String text) {
		TextView textView = new TextView(this);
		textView.setText(text);
		textView.setPadding(8, 8, 8, 8);
		return textView;
	}

	private void openDetailsPage(String userId, String tokenTime, String bikeNo, String remarks) {
		getBikeModel(bikeNo, new BikeModelCallback() {
			@Override
			public void onBikeModelRetrieved(String bikeModel) {
				Intent intent = new Intent(dashboard_activity.this, details_to_be_filled_activity.class);
				intent.putExtra("TOKEN_TIME", tokenTime);
				intent.putExtra("BIKE_NUMBER", bikeNo);
				intent.putExtra("BIKE_MODEL", bikeModel);
				intent.putExtra("REMARKS", remarks);
				intent.putExtra("USER_EMAIL_UID", userId); // Pass UID
				startActivity(intent);
			}
		});
	}


	public void getBikeModel(String bikeNumber, BikeModelCallback callback) {
		// Reference to the specific path
		DatabaseReference bikeRef = FirebaseDatabase.getInstance().getReference("users").child("kushal@gmail,com")
				.child("bikes").child(bikeNumber);

		bikeRef.child("model").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				String bikeModel = dataSnapshot.getValue(String.class);
				if (bikeModel != null) {
					callback.onBikeModelRetrieved(bikeModel);
				} else {
					callback.onBikeModelRetrieved("Unknown Model");
				}
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				callback.onBikeModelRetrieved("Error fetching model");
			}
		});
	}

	public interface BikeModelCallback {
		void onBikeModelRetrieved(String bikeModel);
	}




	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}

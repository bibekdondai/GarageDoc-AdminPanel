package com.example.garagedoc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class details_to_be_filled_activity extends AppCompatActivity {

	private TableLayout lowerTable;
	private TextView txtModel, txtVehicleNo;
	private DatabaseReference databaseRef;
	private String tokenTime, bikeNumber, userEmailUid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_to_be_filled);

		// Initialize Firebase database reference
		databaseRef = FirebaseDatabase.getInstance().getReference();

		// Get data from Intent
		tokenTime = getIntent().getStringExtra("TOKEN_TIME");
		bikeNumber = getIntent().getStringExtra("BIKE_NUMBER");
		userEmailUid = getIntent().getStringExtra("USER_EMAIL_UID"); // Get UID


		// Initialize views
		lowerTable = findViewById(R.id.lower_table);
		txtModel = findViewById(R.id.txt_model);
		txtVehicleNo = findViewById(R.id.txt_vehicleno);
		txtModel = findViewById(R.id.txt_model);

		// Set the model and vehicle number TextViews
		txtVehicleNo.setText(bikeNumber);


		// Fetch and display data
		fetchData();
	}


	private void fetchData() {
		// Reference to the specific path using the userEmailUid

		DatabaseReference bikeRef = databaseRef.child("users").child(userEmailUid)
				.child("bikes").child(bikeNumber).child("bikeModel");

		bikeRef.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				String modelName = dataSnapshot.getValue(String.class);
				txtModel.setText(modelName != null ? modelName : "Model not found");
			}


			@Override
			public void onCancelled(DatabaseError databaseError) {
				Toast.makeText(details_to_be_filled_activity.this, "Failed to load model name.", Toast.LENGTH_SHORT).show();
			}

		});
		DatabaseReference servicesRef = databaseRef.child("users").child(userEmailUid)
				.child("bikes").child(bikeNumber).child("services").child(tokenTime);
		// Reference to the specific path for services


		servicesRef.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				// Clear existing rows in the TableLayout
				lowerTable.removeAllViews();

				// Add header row
				TableRow headerRow = new TableRow(details_to_be_filled_activity.this);
				addTextView(headerRow, "Part Name");
				addTextView(headerRow, "Price");
				addTextView(headerRow, "Remarks");
				addTextView(headerRow, "Action");
				lowerTable.addView(headerRow);

				// Variables to calculate total amount
				int totalAmount = 0;

				// Iterate over child nodes (parts)
				for (DataSnapshot partSnapshot : dataSnapshot.getChildren()) {
					String key = partSnapshot.getKey();
					if (!key.equals("token_time") && !key.equals("token_date")) {
						// Create a new row for each part
						TableRow row = new TableRow(details_to_be_filled_activity.this);
						String partName = partSnapshot.child("part").getValue(String.class);
						String partPriceStr = partSnapshot.child("price").getValue(String.class);

						int partPrice = 0;
						if (partPriceStr != null) {
							try {
								partPrice = Integer.parseInt(partPriceStr);
							} catch (NumberFormatException e) {
								// Handle parse error
							}
						}

						totalAmount += partPrice;

						addTextView(row, partName);
						addTextView(row, partPriceStr);
						addTextView(row, "N/A"); // Remarks column
						addActionButtons(row);

						lowerTable.addView(row);
					}
				}

				// Add total amount row
				TableRow totalRow = new TableRow(details_to_be_filled_activity.this);
				addTextView(totalRow, "Total Amount");
				// Add empty cells for price and remarks
				addTextView(totalRow, String.valueOf(totalAmount));
				addTextView(totalRow, "");
				lowerTable.addView(totalRow);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				Toast.makeText(details_to_be_filled_activity.this, "Failed to load data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void addTextView(TableRow row, String text) {
		TextView textView = new TextView(this);
		textView.setText(text);
		textView.setPadding(8, 8, 8, 8);
		row.addView(textView);
	}

	private void addActionButtons(TableRow row) {
		// Example: Adding a button to each row
		Button actionButton = new Button(this);
		actionButton.setText("Action");
		actionButton.setOnClickListener(v -> {
			// Handle button click
			Toast.makeText(this, "Action button clicked for part", Toast.LENGTH_SHORT).show();
		});
		row.addView(actionButton);
	}
}

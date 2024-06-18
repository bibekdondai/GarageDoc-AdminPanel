package com.example.garagedoc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class inventory_details_activity extends Activity {

    private Spinner spBikeModels;
    private TableLayout tableLayout;
    private FirebaseFirestore db;
    private List<String> bikeModelNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_details);

        db = FirebaseFirestore.getInstance();

        spBikeModels = findViewById(R.id.boxtxt_1_1); // Assuming spinner id is same as in add activity
        tableLayout = findViewById(R.id.lower_table);

        fetchBikeModels();

        spBikeModels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedModel = bikeModelNames.get(position);
                fetchBikeParts(selectedModel);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void fetchBikeModels() {
        db.collection("bikeModels")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        bikeModelNames.clear();
                        for (DocumentSnapshot document : task.getResult()) {
                            String modelName = document.getId();
                            bikeModelNames.add(modelName);
                        }
                        setupBikeModelSpinner();
                    }
                });
    }

    private void setupBikeModelSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeModelNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBikeModels.setAdapter(adapter);
    }

    private void fetchBikeParts(String model) {
        db.collection("bikeModels")
                .document(model)
                .collection("bikeParts")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        displayBikeParts(task.getResult());
                    }
                });
    }

    private void displayBikeParts(QuerySnapshot querySnapshot) {
        tableLayout.removeAllViews(); // Clear previous data

        TableRow headerRow = new TableRow(this);
        String[] headers = {"S.N", "Part Name", "Price", "Quantity"};
        for (String header : headers) {
            TextView headerText = new TextView(this);
            headerText.setText(header);
            headerText.setPadding(8, 8, 8, 8);
            headerRow.addView(headerText);
        }
        tableLayout.addView(headerRow);

        int serialNumber = 1;
        for (DocumentSnapshot document : querySnapshot.getDocuments()) {
            TableRow row = new TableRow(this);

            TextView serialText = new TextView(this);
            serialText.setText(String.valueOf(serialNumber++));
            serialText.setPadding(8, 8, 8, 8);
            row.addView(serialText);

            TextView partNameText = new TextView(this);
            partNameText.setText(document.getId());
            partNameText.setPadding(8, 8, 8, 8);
            row.addView(partNameText);

            TextView priceText = new TextView(this);
            priceText.setText(document.getDouble("price") != null ? document.getDouble("price").toString() : "N/A");
            priceText.setPadding(8, 8, 8, 8);
            row.addView(priceText);

            TextView quantityText = new TextView(this);
            quantityText.setText(document.getLong("quantity") != null ? document.getLong("quantity").toString() : "N/A");
            quantityText.setPadding(8, 8, 8, 8);
            row.addView(quantityText);

            tableLayout.addView(row);
        }
    }
}

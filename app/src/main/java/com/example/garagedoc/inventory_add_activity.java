package com.example.garagedoc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.garagedoc.models.BikePart;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inventory_add_activity extends Activity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private EditText edittxt1, edittxt2, edittxt3, edittxt4, edittxt5, edittxt6, edittxt7;
    private Spinner sp1, sp2, sp3, sp4;
    private FirebaseFirestore db;

    private List<String> bikeModelNames = new ArrayList<>();
    private List<String> bikePartNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_add);

        db = FirebaseFirestore.getInstance();

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);

        edittxt1 = findViewById(R.id.boxtxt_1);
        edittxt2 = findViewById(R.id.boxtxt_2);
        edittxt3 = findViewById(R.id.boxtxt_2_2);
        edittxt4 = findViewById(R.id.boxtxt_2_3);
        edittxt5 = findViewById(R.id.boxtxt_2_4);
        edittxt6 = findViewById(R.id.boxtxt_2_6);
        edittxt7 = findViewById(R.id.boxtxt_2_7);

        sp1 = findViewById(R.id.boxtxt_1_1);
        sp2 = findViewById(R.id.boxtxt_1_2);
        sp3 = findViewById(R.id.boxtxt_1_3);
        sp4 = findViewById(R.id.boxtxt_2_5);

        fetchBikeModels(); // Fetch bike models for spinner

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBikeModel(edittxt1.getText().toString(), edittxt2.getText().toString());
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteBikeModel(sp1.getSelectedItem().toString());
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBikePart(sp2.getSelectedItem().toString(), edittxt3.getText().toString(), edittxt4.getText().toString(), edittxt5.getText().toString());
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBikePart(sp3.getSelectedItem().toString(), sp4.getSelectedItem().toString(), edittxt6.getText().toString(), edittxt7.getText().toString());
            }
        });
    }

    private void fetchBikeModels() {
        db.collection("bikeModels")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            bikeModelNames.clear(); // Clear previous data
                            for (DocumentSnapshot document : task.getResult()) {
                                String modelName = document.getId();
                                bikeModelNames.add(modelName);
                            }
                            setupSpinners();
                        } else {
                            Toast.makeText(inventory_add_activity.this, "Failed to fetch bike models", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void setupSpinners() {
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeModelNames);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeModelNames);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bikeModelNames);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                fetchBikeParts(bikeModelNames.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });
    }

    private void fetchBikeParts(String model) {
        db.collection("bikeModels")
                .document(model)
                .collection("bikeParts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            bikePartNames.clear(); // Clear previous data
                            for (DocumentSnapshot document : task.getResult()) {
                                String partName = document.getId();
                                bikePartNames.add(partName);
                            }
                            ArrayAdapter<String> adapter4 = new ArrayAdapter<>(inventory_add_activity.this, android.R.layout.simple_spinner_item, bikePartNames);
                            adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sp4.setAdapter(adapter4);
                        } else {
                            Toast.makeText(inventory_add_activity.this, "Failed to fetch bike parts", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void addBikeModel(String model, String price) {
        if (model.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> bikeModel = new HashMap<>();
        bikeModel.put("modelName", model);
        bikeModel.put("price", price);

        db.collection("bikeModels")
                .document(model)
                .set(bikeModel)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Bike model added", Toast.LENGTH_SHORT).show();
                    edittxt1.setText("");
                    edittxt2.setText("");
                    fetchBikeModels(); // Refresh spinners after adding new model
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Error adding bike model", Toast.LENGTH_SHORT).show());
    }

    private void deleteBikeModel(String model) {
        if (model.isEmpty()) {
            Toast.makeText(this, "Please select a model to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        db.collection("bikeModels")
                .document(model)
                .delete()
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Bike model deleted", Toast.LENGTH_SHORT).show();
                    fetchBikeModels(); // Refresh spinners after deleting a model
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Error deleting bike model", Toast.LENGTH_SHORT).show());
    }

    private void addBikePart(String model, String part, String priceString, String quantityString) {
        if (model.isEmpty() || part.isEmpty() || priceString.isEmpty() || quantityString.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double price;
        int quantity;

        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            quantity = Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid quantity format", Toast.LENGTH_SHORT).show();
            return;
        }

        BikePart bikePart = new BikePart(part, price, quantity);

        db.collection("bikeModels")
                .document(model)
                .collection("bikeParts")
                .document(part)  // Use part name as the document ID
                .set(bikePart)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Bike part added", Toast.LENGTH_SHORT).show();
                    edittxt3.setText("");
                    edittxt4.setText("");
                    edittxt5.setText("");
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Error adding bike part", Toast.LENGTH_SHORT).show());
    }

    private void updateBikePart(String model, String partName, String priceString, String additionalQuantityString) {
        if (model.isEmpty() || partName.isEmpty() || additionalQuantityString.isEmpty()) {
            Toast.makeText(this, "Please fill out all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Long additionalQuantity;

        try {
            additionalQuantity = Long.parseLong(additionalQuantityString);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid quantity format", Toast.LENGTH_SHORT).show();
            return;
        }

        final Long finalAdditionalQuantity = additionalQuantity; // Declare a final variable

        db.collection("bikeModels")
                .document(model)
                .collection("bikeParts")
                .document(partName)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Get the current quantity from the document
                        Long currentQuantity = 0L;
                        if (documentSnapshot.contains("quantity")) {
                            try {
                                currentQuantity = documentSnapshot.getLong("quantity");
                            } catch (Exception e) {
                                Toast.makeText(this, "Error: 'quantity' is not a number", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }

                        // Add the new quantity to the existing quantity
                        Long newQuantity = currentQuantity + finalAdditionalQuantity;

                        // Create a map to hold the fields that need to be updated
                        Map<String, Object> updates = new HashMap<>();
                        updates.put("quantity", newQuantity);

                        // If the price is provided, update it
                        if (!priceString.isEmpty()) {
                            try {
                                Long price = Long.parseLong(priceString);
                                updates.put("price", price);
                            } catch (NumberFormatException e) {
                                Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }

                        // Update the document with the new quantity and price (if provided)
                        db.collection("bikeModels")
                                .document(model)
                                .collection("bikeParts")
                                .document(partName)
                                .update(updates)
                                .addOnSuccessListener(aVoid -> {
                                    Toast.makeText(this, "Bike part updated", Toast.LENGTH_SHORT).show();
                                    edittxt6.setText(""); // Clear the quantity input field
                                    edittxt7.setText(""); // Clear the price input field
                                })
                                .addOnFailureListener(e -> Toast.makeText(this, "Error updating bike part", Toast.LENGTH_SHORT).show());
                    } else {
                        Toast.makeText(this, "Part does not exist", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Error fetching bike part", Toast.LENGTH_SHORT).show());
    }



}

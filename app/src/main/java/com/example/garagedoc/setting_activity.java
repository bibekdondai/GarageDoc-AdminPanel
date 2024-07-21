//package com.example.garagedoc;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//public class SettingActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.setting);
//
//        // Add any additional initialization or logic here
//    }
//
//    inventory_add_btn.setOnClickListener(v -> {
//        Intent inventoryaddIntent = new Intent(inventory_add_activity.this, setting_activity.class);
//        startActivity(inventoryaddIntent);
//    });
//
//
//    public void onInventoryDetailsClicked(View view) {
//        // Navigate to the Inventory Details page
//        Intent intent = new Intent(this, InventoryDetailsActivity.class);
//        startActivity(intent);
//    }
//}

package com.example.garagedoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);  // Ensure this layout file exists

        // Find the buttons by their IDs
        Button inventoryAddButton = findViewById(R.id.inventory_add_btn);
        Button inventoryDetailsButton = findViewById(R.id.inventory_details_btn);

        // Set click listeners for buttons
        inventoryAddButton.setOnClickListener(v -> {
            Intent inventoryAddIntent = new Intent(setting_activity.this, inventory_add_activity.class);
            startActivity(inventoryAddIntent);
        });

        inventoryDetailsButton.setOnClickListener(v -> {
            Intent inventoryDetailsIntent = new Intent(setting_activity.this, inventory_details_activity.class);
            startActivity(inventoryDetailsIntent);
        });
    }
}

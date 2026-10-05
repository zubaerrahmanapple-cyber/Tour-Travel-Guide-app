
package com.zubu.zerobite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    EditText searchInput;
    Button btnPlaces, btnHotels, btnRestaurants, btnTransport, btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        searchInput = findViewById(R.id.searchInput);
        btnPlaces = findViewById(R.id.btnPlaces);
        btnHotels = findViewById(R.id.btnHotels);
        btnRestaurants = findViewById(R.id.btnRestaurants);
        btnTransport = findViewById(R.id.btnTransport);
        btnBooking = findViewById(R.id.btnBooking);

        btnPlaces.setOnClickListener(v ->
                showMessage("Explore Places"));

        btnHotels.setOnClickListener(v ->
                showMessage("Hotels"));

        btnRestaurants.setOnClickListener(v ->
                showMessage("Restaurants"));

        btnTransport.setOnClickListener(v ->
                showMessage("Transport"));

        btnBooking.setOnClickListener(v ->
                showMessage("My Bookings"));

        searchInput.setOnEditorActionListener((v, actionId, event) -> {
            String query = searchInput.getText().toString().trim();

            if (query.isEmpty()) {
                searchInput.setError("Enter a place or hotel name");
            } else {
                Toast.makeText(this,
                        "Searching for: " + query,
                        Toast.LENGTH_SHORT).show();
            }

            return true;
        });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

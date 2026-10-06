package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    EditText searchInput;
    Button btnPlaces, btnHotels, btnRestaurants, btnTransport, btnBooking;
    TextView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find Views
        searchInput = findViewById(R.id.searchInput);
        btnPlaces = findViewById(R.id.btnPlaces);
        btnHotels = findViewById(R.id.btnHotels);
        btnRestaurants = findViewById(R.id.btnRestaurants);
        btnTransport = findViewById(R.id.btnTransport);
        btnBooking = findViewById(R.id.btnBooking);
        menuButton = findViewById(R.id.menuButton);


        // =========================
        // NAVBAR MENU
        // =========================

        menuButton.setOnClickListener(v -> {

            android.widget.PopupMenu popupMenu =
                    new android.widget.PopupMenu(
                            DashboardActivity.this,
                            menuButton
                    );

            popupMenu.getMenu().add("Home");
            popupMenu.getMenu().add("Places");
            popupMenu.getMenu().add("Hotels");
            popupMenu.getMenu().add("Restaurants");
            popupMenu.getMenu().add("Transport");
            popupMenu.getMenu().add("My Bookings");
            popupMenu.getMenu().add("Profile");

            popupMenu.setOnMenuItemClickListener(item -> {

                String selected = item.getTitle().toString();

                // Places
                if (selected.equals("Places")) {

                    Intent intent = new Intent(
                            DashboardActivity.this,
                            PlacesActivity.class
                    );

                    startActivity(intent);

                }

                // Home
                else if (selected.equals("Home")) {

                    Toast.makeText(
                            DashboardActivity.this,
                            "You are already on Home",
                            Toast.LENGTH_SHORT
                    ).show();

                }

                // Other menu items
                else {

                    Toast.makeText(
                            DashboardActivity.this,
                            selected + " selected",
                            Toast.LENGTH_SHORT
                    ).show();
                }

                return true;
            });

            popupMenu.show();
        });


        // =========================
        // EXPLORE PLACES BUTTON
        // =========================

        btnPlaces.setOnClickListener(v -> {

            Intent intent = new Intent(
                    DashboardActivity.this,
                    PlacesActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // HOTELS
        // =========================

        btnHotels.setOnClickListener(v -> {

            showMessage("Hotels");
        });


        // =========================
        // RESTAURANTS
        // =========================

        btnRestaurants.setOnClickListener(v -> {

            showMessage("Restaurants");
        });


        // =========================
        // TRANSPORT
        // =========================

        btnTransport.setOnClickListener(v -> {

            showMessage("Transport");
        });


        // =========================
        // MY BOOKINGS
        // =========================

        btnBooking.setOnClickListener(v -> {

            showMessage("My Bookings");
        });


        // =========================
        // SEARCH
        // =========================

        searchInput.setOnEditorActionListener((v, actionId, event) -> {

            String query =
                    searchInput.getText().toString().trim();

            if (query.isEmpty()) {

                searchInput.setError(
                        "Enter a place or hotel name"
                );

            } else {

                Toast.makeText(
                        DashboardActivity.this,
                        "Searching for: " + query,
                        Toast.LENGTH_SHORT
                ).show();
            }

            return true;
        });
    }


    // =========================
    // MESSAGE
    // =========================

    private void showMessage(String message) {

        Toast.makeText(
                DashboardActivity.this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }
}
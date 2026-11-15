
package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    EditText searchInput;

    Button btnPlaces, btnHotels, btnRestaurants,
            btnTransport, btnBooking, btnDashboardSearch;

    TextView menuButton;

    ViewFlipper imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // IMAGE SLIDER
        imageSlider = findViewById(R.id.dashboardImageSlider);

        imageSlider.setAutoStart(true);
        imageSlider.setFlipInterval(3000);
        imageSlider.startFlipping();

        // FIND VIEWS
        searchInput = findViewById(R.id.searchInput);

        btnPlaces = findViewById(R.id.btnPlaces);
        btnHotels = findViewById(R.id.btnHotels);
        btnRestaurants = findViewById(R.id.btnRestaurants);
        btnTransport = findViewById(R.id.btnTransport);
        btnBooking = findViewById(R.id.btnBooking);
        btnDashboardSearch = findViewById(R.id.btnDashboardSearch);

        menuButton = findViewById(R.id.menuButton);

        // NAVBAR MENU
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

                switch (selected) {

                    case "Home":
                        showMessage("You are already on Home");
                        break;

                    case "Places":
                        openPlaces();
                        break;

                    case "Hotels":
                        openHotels();
                        break;

                    case "Restaurants":
                        showMessage("Restaurants page will be added soon!");
                        break;

                    case "Transport":
                        showMessage("Transport page will be added soon!");
                        break;

                    case "My Bookings":
                        showMessage("Booking page will be added soon!");
                        break;

                    case "Profile":
                        showMessage("Profile page will be added soon!");
                        break;
                }

                return true;
            });

            popupMenu.show();
        });

        // CATEGORY BUTTONS
        btnPlaces.setOnClickListener(v -> openPlaces());

        btnHotels.setOnClickListener(v -> openHotels());

        btnRestaurants.setOnClickListener(v ->
                showMessage("Restaurants page will be added soon!"));

        btnTransport.setOnClickListener(v ->
                showMessage("Transport page will be added soon!"));

        btnBooking.setOnClickListener(v ->
                showMessage("Booking page will be added soon!"));

        // SEARCH BUTTON CLICK
        btnDashboardSearch.setOnClickListener(v -> {

            String query = searchInput.getText()
                    .toString()
                    .trim()
                    .toLowerCase();

            if (query.isEmpty()) {
                searchInput.setError("Enter something to search");
            } else {
                performSearch(query);
            }
        });

        // KEYBOARD SEARCH
        searchInput.setOnEditorActionListener((v, actionId, event) -> {

            boolean searchPressed =
                    actionId == EditorInfo.IME_ACTION_SEARCH ||
                            actionId == EditorInfo.IME_ACTION_DONE ||
                            (event != null &&
                                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER &&
                                    event.getAction() == KeyEvent.ACTION_DOWN);

            if (searchPressed) {

                String query = searchInput.getText()
                        .toString()
                        .trim()
                        .toLowerCase();

                if (query.isEmpty()) {
                    searchInput.setError("Enter something to search");
                } else {
                    performSearch(query);
                }

                return true;
            }

            return false;
        });
    }

    // SEARCH FUNCTION
    private void performSearch(String query) {

        // HOTELS
        if (query.contains("hotel") ||
                query.contains("sayeman") ||
                query.contains("long beach") ||
                query.contains("megh roddur") ||
                query.contains("resort") ||
                query.contains("stay")) {

            openHotels();
        }

        // PLACES
        else if (query.contains("place") ||
                query.contains("destination") ||
                query.contains("cox") ||
                query.contains("sajek") ||
                query.contains("himchari") ||
                query.contains("inani") ||
                query.contains("saint martin")) {

            openPlaces();
        }

        // RESTAURANTS
        else if (query.contains("restaurant") ||
                query.contains("food") ||
                query.contains("cafe") ||
                query.contains("dining")) {

            showMessage("Restaurants page will be added soon!");
        }

        // TRANSPORT
        else if (query.contains("transport") ||
                query.contains("bus") ||
                query.contains("train") ||
                query.contains("flight") ||
                query.contains("car")) {

            showMessage("Transport page will be added soon!");
        }

        // BOOKINGS
        else if (query.contains("booking") ||
                query.contains("reservation")) {

            showMessage("Booking page will be added soon!");
        }

        // NO RESULT
        else {

            showMessage("No result found for: " + query);
        }
    }

    // OPEN PLACES
    private void openPlaces() {

        Intent intent = new Intent(
                DashboardActivity.this,
                PlacesActivity.class
        );

        startActivity(intent);
    }

    // OPEN HOTELS
    private void openHotels() {

        Intent intent = new Intent(
                DashboardActivity.this,
                HotelsActivity.class
        );

        startActivity(intent);
    }

    // MESSAGE
    private void showMessage(String message) {

        Toast.makeText(
                DashboardActivity.this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (imageSlider != null) {
            imageSlider.stopFlipping();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (imageSlider != null) {
            imageSlider.startFlipping();
        }
    }
}

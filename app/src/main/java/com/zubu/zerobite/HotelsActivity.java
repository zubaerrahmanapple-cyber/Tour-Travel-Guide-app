
package com.zubu.zerobite;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HotelsActivity extends AppCompatActivity {

    private CardView sayemanCard, longBeachCard, meghRoddurCard;

    private Button btnSayemanDetails;
    private Button btnLongBeachDetails;
    private Button btnMeghRoddurDetails;

    private TextView allPlacesFilter;
    private TextView coxBazarFilter;
    private TextView sajekFilter;
    private TextView sylhetFilter;
    private TextView exploreAll;

    private EditText hotelSearchInput;

    private String selectedDestination = "all";

    private final int selectedColor = Color.parseColor("#123B5D");
    private final int unselectedColor = Color.WHITE;
    private final int selectedTextColor = Color.WHITE;
    private final int unselectedTextColor = Color.parseColor("#123B5D");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        // HOTEL CARDS
        sayemanCard = findViewById(R.id.sayemanCard);
        longBeachCard = findViewById(R.id.longBeachCard);
        meghRoddurCard = findViewById(R.id.meghRoddurCard);

        // DETAILS BUTTONS
        btnSayemanDetails = findViewById(R.id.btnSayemanDetails);
        btnLongBeachDetails = findViewById(R.id.btnLongBeachDetails);
        btnMeghRoddurDetails = findViewById(R.id.btnMeghRoddurDetails);

        // DESTINATION FILTERS
        allPlacesFilter = findViewById(R.id.allPlacesFilter);
        coxBazarFilter = findViewById(R.id.coxBazarFilter);
        sajekFilter = findViewById(R.id.sajekFilter);
        sylhetFilter = findViewById(R.id.sylhetFilter);

        // SEARCH
        hotelSearchInput = findViewById(R.id.hotelSearchInput);

        // EXPLORE ALL
        exploreAll = findViewById(R.id.exploreAll);

        // DEFAULT FILTER
        showAllHotels();

        // HOTEL DETAILS CLICK
        sayemanCard.setOnClickListener(v ->
                openHotelDetails("Sayeman Beach Resort"));

        btnSayemanDetails.setOnClickListener(v ->
                openHotelDetails("Sayeman Beach Resort"));

        longBeachCard.setOnClickListener(v ->
                openHotelDetails("Long Beach Hotel"));

        btnLongBeachDetails.setOnClickListener(v ->
                openHotelDetails("Long Beach Hotel"));

        meghRoddurCard.setOnClickListener(v ->
                openHotelDetails("Megh Roddur Hill Resort"));

        btnMeghRoddurDetails.setOnClickListener(v ->
                openHotelDetails("Megh Roddur Hill Resort"));

        // DESTINATION FILTER CLICK
        allPlacesFilter.setOnClickListener(v -> {
            selectedDestination = "all";
            showAllHotels();
        });

        coxBazarFilter.setOnClickListener(v -> {
            selectedDestination = "cox";
            showFilteredHotels();
            updateFilterStyle(coxBazarFilter);
        });

        sajekFilter.setOnClickListener(v -> {
            selectedDestination = "sajek";
            showFilteredHotels();
            updateFilterStyle(sajekFilter);
        });

        sylhetFilter.setOnClickListener(v -> {
            selectedDestination = "sylhet";
            showFilteredHotels();
            updateFilterStyle(sylhetFilter);

            Toast.makeText(
                    HotelsActivity.this,
                    "Sylhet hotels will be added soon!",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // EXPLORE ALL
        exploreAll.setOnClickListener(v -> {
            selectedDestination = "all";
            showAllHotels();
        });

        // SEARCH FUNCTIONALITY
        hotelSearchInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {

                showFilteredHotels();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    // UPDATE FILTER COLORS
    private void updateFilterStyle(TextView selectedFilter) {

        TextView[] filters = {
                allPlacesFilter,
                coxBazarFilter,
                sajekFilter,
                sylhetFilter
        };

        for (TextView filter : filters) {

            if (filter == selectedFilter) {
                filter.setBackgroundColor(selectedColor);
                filter.setTextColor(selectedTextColor);
            } else {
                filter.setBackgroundColor(unselectedColor);
                filter.setTextColor(unselectedTextColor);
            }
        }
    }

    // SHOW ALL HOTELS
    private void showAllHotels() {

        updateFilterStyle(allPlacesFilter);
        showFilteredHotels();
    }

    // FILTER HOTELS USING DESTINATION AND SEARCH
    private void showFilteredHotels() {

        String searchText = hotelSearchInput.getText()
                .toString()
                .trim()
                .toLowerCase();

        // SAYEMAN BEACH RESORT
        boolean showSayeman =
                (selectedDestination.equals("all")
                        || selectedDestination.equals("cox"))
                        && "sayeman beach resort".contains(searchText);

        // LONG BEACH HOTEL
        boolean showLongBeach =
                (selectedDestination.equals("all")
                        || selectedDestination.equals("cox"))
                        && "long beach hotel".contains(searchText);

        // MEGH RODDUR HILL RESORT
        boolean showMeghRoddur =
                (selectedDestination.equals("all")
                        || selectedDestination.equals("sajek"))
                        && "megh roddur hill resort".contains(searchText);

        sayemanCard.setVisibility(
                showSayeman ? View.VISIBLE : View.GONE);

        longBeachCard.setVisibility(
                showLongBeach ? View.VISIBLE : View.GONE);

        meghRoddurCard.setVisibility(
                showMeghRoddur ? View.VISIBLE : View.GONE);
    }

    // OPEN HOTEL DETAILS
    private void openHotelDetails(String hotelName) {

        Intent intent = new Intent(
                HotelsActivity.this,
                HotelDetailsActivity.class
        );

        intent.putExtra("hotel_name", hotelName);
        startActivity(intent);
    }
}

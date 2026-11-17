package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        TextView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        findViewById(R.id.restaurantCard1).setOnClickListener(v ->
                openRestaurantList("Cox's Bazar"));

        findViewById(R.id.restaurantCard2).setOnClickListener(v ->
                openRestaurantList("Sajek Valley"));

        findViewById(R.id.restaurantCard3).setOnClickListener(v ->
                openRestaurantList("Sylhet"));

        findViewById(R.id.restaurantCard4).setOnClickListener(v ->
                openRestaurantList("Bandarban"));

        findViewById(R.id.restaurantCard5).setOnClickListener(v ->
                openRestaurantList("Sundarbans"));
    }

    private void openRestaurantList(String destination) {
        Intent intent = new Intent(RestaurantsActivity.this,
                RestaurantListActivity.class);

        intent.putExtra("destination", destination);
        startActivity(intent);
    }
}
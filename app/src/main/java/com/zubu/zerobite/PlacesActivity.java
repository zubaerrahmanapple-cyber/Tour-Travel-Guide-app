
package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PlacesActivity extends AppCompatActivity {

    CardView coxBazarCard, sajekCard, sylhetCard,
            bandarbanCard, sundarbanCard;

    TextView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        // FIND VIEWS
        backButton = findViewById(R.id.backButton);

        coxBazarCard = findViewById(R.id.coxBazarCard);
        sajekCard = findViewById(R.id.sajekCard);
        sylhetCard = findViewById(R.id.sylhetCard);
        bandarbanCard = findViewById(R.id.bandarbanCard);
        sundarbanCard = findViewById(R.id.sundarbanCard);

        // BACK BUTTON
        backButton.setOnClickListener(v -> finish());

        // COX'S BAZAR
        coxBazarCard.setOnClickListener(v ->
                openDestination("Cox's Bazar"));

        // SAJEK VALLEY
        sajekCard.setOnClickListener(v ->
                openDestination("Sajek Valley"));

        // SYLHET
        sylhetCard.setOnClickListener(v ->
                openDestination("Sylhet"));

        // BANDARBAN
        bandarbanCard.setOnClickListener(v ->
                openDestination("Bandarban"));

        // SUNDARBANS
        sundarbanCard.setOnClickListener(v ->
                openDestination("Sundarbans"));
    }

    // OPEN DESTINATION DETAILS
    private void openDestination(String destination) {

        Intent intent = new Intent(
                PlacesActivity.this,
                PlaceDetailsActivity.class
        );

        intent.putExtra("destination", destination);

        startActivity(intent);
    }
}

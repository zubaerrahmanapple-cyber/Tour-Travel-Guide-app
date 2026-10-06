package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PlacesActivity extends AppCompatActivity {

    CardView coxBazarCard;
    TextView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_places);

        // Back Button
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> {
            finish();
        });

        // Cox's Bazar Card
        coxBazarCard = findViewById(R.id.coxBazarCard);

        coxBazarCard.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PlacesActivity.this,
                    PlaceDetailsActivity.class
            );

            startActivity(intent);
        });
    }
}
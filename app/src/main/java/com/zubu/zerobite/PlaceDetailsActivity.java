
package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PlaceDetailsActivity extends AppCompatActivity {

    TextView backButton, destinationTitle;

    View coxSection, sajekSection, sylhetSection;
    View bandarbanSection, sundarbansSection;

    CardView laboniCard, himchariCard, inaniCard;
    CardView marineDriveCard, sugandhaCard;

    CardView konglakCard, ruiluiCard;
    CardView sajekHelipadCard, meghpunjiCard;

    CardView jaflongCard, ratargulCard;
    CardView bisanakandiCard, lalakhalCard;

    CardView nilgiriCard, nilachalCard;
    CardView bogaLakeCard, nafakhumCard;

    CardView karamjalCard, harbariaCard;
    CardView katkaCard, hironPointCard;

    String destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        backButton = findViewById(R.id.backButton);
        destinationTitle = findViewById(R.id.destinationTitle);

        coxSection = findViewById(R.id.coxSection);
        sajekSection = findViewById(R.id.sajekSection);
        sylhetSection = findViewById(R.id.sylhetSection);
        bandarbanSection = findViewById(R.id.bandarbanSection);
        sundarbansSection = findViewById(R.id.sundarbansSection);

        destination = getIntent().getStringExtra("destination");

        if (destination == null) {
            destination = "Cox's Bazar";
        }

        backButton.setOnClickListener(v -> finish());

        hideAllSections();

        if (destination.equalsIgnoreCase("Sajek Valley")) {

            destinationTitle.setText("Explore Sajek Valley");
            sajekSection.setVisibility(View.VISIBLE);

            konglakCard = findViewById(R.id.konglakCard);
            ruiluiCard = findViewById(R.id.ruiluiCard);
            sajekHelipadCard = findViewById(R.id.sajekHelipadCard);
            meghpunjiCard = findViewById(R.id.meghpunjiCard);

            konglakCard.setOnClickListener(v -> openSpot("Konglak Hill"));
            ruiluiCard.setOnClickListener(v -> openSpot("Ruilui Para"));
            sajekHelipadCard.setOnClickListener(v -> openSpot("Sajek Helipad"));
            meghpunjiCard.setOnClickListener(v -> openSpot("Meghpunji"));

        } else if (destination.equalsIgnoreCase("Sylhet")) {

            destinationTitle.setText("Explore Sylhet");
            sylhetSection.setVisibility(View.VISIBLE);

            jaflongCard = findViewById(R.id.jaflongCard);
            ratargulCard = findViewById(R.id.ratargulCard);
            bisanakandiCard = findViewById(R.id.bisanakandiCard);
            lalakhalCard = findViewById(R.id.lalakhalCard);

            jaflongCard.setOnClickListener(v -> openSpot("Jaflong"));
            ratargulCard.setOnClickListener(v -> openSpot("Ratargul Swamp Forest"));
            bisanakandiCard.setOnClickListener(v -> openSpot("Bisanakandi"));
            lalakhalCard.setOnClickListener(v -> openSpot("Lalakhal"));

        } else if (destination.equalsIgnoreCase("Bandarban")) {

            destinationTitle.setText("Explore Bandarban");
            bandarbanSection.setVisibility(View.VISIBLE);

            nilgiriCard = findViewById(R.id.nilgiriCard);
            nilachalCard = findViewById(R.id.nilachalCard);
            bogaLakeCard = findViewById(R.id.bogaLakeCard);
            nafakhumCard = findViewById(R.id.nafakhumCard);

            nilgiriCard.setOnClickListener(v -> openSpot("Nilgiri"));
            nilachalCard.setOnClickListener(v -> openSpot("Nilachal"));
            bogaLakeCard.setOnClickListener(v -> openSpot("Boga Lake"));
            nafakhumCard.setOnClickListener(v -> openSpot("Nafakhum"));

        } else if (destination.equalsIgnoreCase("Sundarbans")) {

            destinationTitle.setText("Explore Sundarbans");
            sundarbansSection.setVisibility(View.VISIBLE);

            karamjalCard = findViewById(R.id.karamjalCard);
            harbariaCard = findViewById(R.id.harbariaCard);
            katkaCard = findViewById(R.id.katkaCard);
            hironPointCard = findViewById(R.id.hironPointCard);

            karamjalCard.setOnClickListener(v -> openSpot("Karamjal"));
            harbariaCard.setOnClickListener(v -> openSpot("Harbaria"));
            katkaCard.setOnClickListener(v -> openSpot("Katka"));
            hironPointCard.setOnClickListener(v -> openSpot("Hiron Point"));

        } else {

            destinationTitle.setText("Explore Cox's Bazar");
            coxSection.setVisibility(View.VISIBLE);

            laboniCard = findViewById(R.id.laboniCard);
            himchariCard = findViewById(R.id.himchariCard);
            inaniCard = findViewById(R.id.inaniCard);
            marineDriveCard = findViewById(R.id.marineDriveCard);
            sugandhaCard = findViewById(R.id.sugandhaCard);

            laboniCard.setOnClickListener(v -> openSpot("Laboni Beach"));
            himchariCard.setOnClickListener(v -> openSpot("Himchari"));
            inaniCard.setOnClickListener(v -> openSpot("Inani Beach"));
            marineDriveCard.setOnClickListener(v -> openSpot("Marine Drive"));
            sugandhaCard.setOnClickListener(v -> openSpot("Sugandha Beach"));
        }
    }

    private void hideAllSections() {

        coxSection.setVisibility(View.GONE);
        sajekSection.setVisibility(View.GONE);
        sylhetSection.setVisibility(View.GONE);
        bandarbanSection.setVisibility(View.GONE);
        sundarbansSection.setVisibility(View.GONE);
    }

    private void openSpot(String spotName) {

        Intent intent = new Intent(
                PlaceDetailsActivity.this,
                SpotDetailsActivity.class
        );

        intent.putExtra("spot_name", spotName);
        intent.putExtra("destination", destination);

        startActivity(intent);
    }
}

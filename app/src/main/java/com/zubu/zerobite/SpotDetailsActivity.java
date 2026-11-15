
package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpotDetailsActivity extends AppCompatActivity {

    TextView spotName, spotCategory, spotLocation;
    TextView spotDescription, spotBestTime, spotTravelTips;

    ImageView spotMainImage;
    ImageView galleryImage1, galleryImage2, galleryImage3;
    ImageView galleryImage4, galleryImage5, galleryImage6;

    View backButton, viewAllPhotos;
    Button bookNowButton;

    String selectedSpot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details);

        spotName = findViewById(R.id.spotName);
        spotCategory = findViewById(R.id.spotCategory);
        spotLocation = findViewById(R.id.spotLocation);
        spotDescription = findViewById(R.id.spotDescription);
        spotBestTime = findViewById(R.id.spotBestTime);
        spotTravelTips = findViewById(R.id.spotTravelTips);

        spotMainImage = findViewById(R.id.spotMainImage);

        galleryImage1 = findViewById(R.id.galleryImage1);
        galleryImage2 = findViewById(R.id.galleryImage2);
        galleryImage3 = findViewById(R.id.galleryImage3);
        galleryImage4 = findViewById(R.id.galleryImage4);
        galleryImage5 = findViewById(R.id.galleryImage5);
        galleryImage6 = findViewById(R.id.galleryImage6);

        backButton = findViewById(R.id.backButton);
        viewAllPhotos = findViewById(R.id.viewAllPhotos);
        bookNowButton = findViewById(R.id.bookNowButton);

        selectedSpot = getIntent().getStringExtra("spot_name");

        if (selectedSpot == null || selectedSpot.trim().isEmpty()) {
            selectedSpot = "Laboni Beach";
        }

        loadSpotDetails(selectedSpot);

        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        }

        if (viewAllPhotos != null) {
            viewAllPhotos.setOnClickListener(v -> {
                Intent intent = new Intent(
                        SpotDetailsActivity.this,
                        AllPhotosActivity.class
                );
                intent.putExtra("spot_name", selectedSpot);
                startActivity(intent);
            });
        }

        if (bookNowButton != null) {
            bookNowButton.setOnClickListener(v ->
                    Toast.makeText(
                            SpotDetailsActivity.this,
                            "Booking feature coming soon!",
                            Toast.LENGTH_SHORT
                    ).show()
            );
        }
    }

    private void loadSpotDetails(String spot) {

        int mainImage = R.drawable.laboni;

        String category = "Beach";
        String location = "Cox's Bazar, Bangladesh";

        String description =
                "Enjoy the beautiful scenery and peaceful atmosphere.";

        String bestTime = "Morning and late afternoon";

        String travelTips =
                "Carry water, keep the area clean and follow safety instructions.";

        // COX'S BAZAR

        if (spot.equalsIgnoreCase("Himchari")) {

            mainImage = R.drawable.himchari;
            category = "Hill and Waterfall";

            description =
                    "Himchari is known for its green hills, waterfall and beautiful sea views.";

            bestTime = "Morning and winter season";

            travelTips =
                    "Wear comfortable shoes and be careful on slippery paths.";

        } else if (spot.equalsIgnoreCase("Inani Beach")) {

            mainImage = R.drawable.inani;
            category = "Rocky Beach";

            description =
                    "Inani Beach is famous for its rocky shoreline, clear water and natural beauty.";

            bestTime = "Early morning and sunset";

            travelTips =
                    "Wear suitable footwear around the rocks and avoid rough water.";

        } else if (spot.equalsIgnoreCase("Marine Drive")) {

            mainImage = R.drawable.marine;
            category = "Scenic Coastal Road";

            description =
                    "Marine Drive offers beautiful views of the sea along the coastal road.";

            bestTime = "Afternoon";

            travelTips =
                    "Follow traffic rules and stop only in safe places.";

        } else if (spot.equalsIgnoreCase("Sugandha Beach")) {

            mainImage = R.drawable.sugandha;
            category = "Sea Beach";

            description =
                    "Sugandha Beach is a popular place to enjoy the sea and sunset.";

            bestTime = "Late afternoon and sunset";

            travelTips =
                    "Keep your belongings safe and follow beach safety instructions.";

        }

        // SAJEK VALLEY

        else if (spot.equalsIgnoreCase("Konglak Hill")) {

            mainImage = R.drawable.konglak;
            category = "Hill Viewpoint";
            location = "Sajek Valley, Rangamati, Bangladesh";

            description =
                    "Konglak Hill is a popular viewpoint offering beautiful mountain scenery and cloud-covered landscapes.";

            bestTime = "Early morning";

            travelTips =
                    "Wear comfortable shoes and follow local guidance on hill trails.";

        } else if (spot.equalsIgnoreCase("Ruilui Para")) {

            mainImage = R.drawable.ruilui;
            category = "Hill Village";
            location = "Sajek Valley, Rangamati, Bangladesh";

            description =
                    "Ruilui Para is a scenic hill village known for its mountain surroundings and local culture.";

            bestTime = "Morning and afternoon";

            travelTips =
                    "Respect local customs and keep the village clean.";

        } else if (spot.equalsIgnoreCase("Sajek Helipad")) {

            mainImage = R.drawable.sajek_helipad;
            category = "Scenic Viewpoint";
            location = "Sajek Valley, Rangamati, Bangladesh";

            description =
                    "The Sajek Helipad area is a popular spot for panoramic views of the surrounding hills.";

            bestTime = "Early morning or sunset";

            travelTips =
                    "Follow local rules and avoid restricted areas.";

        } else if (spot.equalsIgnoreCase("Meghpunji")) {

            mainImage = R.drawable.meghpunji;
            category = "Resort and Hill View";
            location = "Sajek Valley, Rangamati, Bangladesh";

            description =
                    "Meghpunji offers a relaxing hill setting with scenic views of the surrounding landscape.";

            bestTime = "Morning and late afternoon";

            travelTips =
                    "Check accommodation arrangements before visiting.";

        }

        // SYLHET

        else if (spot.equalsIgnoreCase("Jaflong")) {

            mainImage = R.drawable.jaflong;
            category = "Hill and River Destination";
            location = "Jaflong, Gowainghat, Sylhet, Bangladesh";

            description =
                    "Jaflong is famous for its beautiful river, stone collections, green hills and views of the Meghalaya mountains.";

            bestTime = "Winter and early morning";

            travelTips =
                    "Check river conditions before visiting and avoid unsafe water areas.";

        } else if (spot.equalsIgnoreCase("Ratargul Swamp Forest")) {

            mainImage = R.drawable.ratargul;
            category = "Freshwater Swamp Forest";
            location = "Gowainghat, Sylhet, Bangladesh";

            description =
                    "Ratargul is a beautiful freshwater swamp forest where trees stand in water during the rainy season.";

            bestTime = "Monsoon season";

            travelTips =
                    "Wear a life jacket during boat rides and follow local safety instructions.";

        } else if (spot.equalsIgnoreCase("Bisanakandi")) {

            mainImage = R.drawable.bisanakandi;
            category = "River and Mountain Destination";
            location = "Gowainghat, Sylhet, Bangladesh";

            description =
                    "Bisanakandi is known for its crystal-clear water, stone beds, flowing streams and surrounding mountains.";

            bestTime = "Monsoon and early morning";

            travelTips =
                    "Check weather and river conditions before travelling.";

        } else if (spot.equalsIgnoreCase("Lalakhal")) {

            mainImage = R.drawable.lalakhal;
            category = "Blue River Destination";
            location = "Jaintiapur, Sylhet, Bangladesh";

            description =
                    "Lalakhal is famous for its beautiful blue-green river water and scenic boat journeys.";

            bestTime = "Winter and sunny days";

            travelTips =
                    "Choose a safe boat and follow local boating instructions.";

        }

        // BANDARBAN

        else if (spot.equalsIgnoreCase("Nilgiri")) {

            mainImage = R.drawable.nilgiri;
            category = "Mountain Viewpoint";
            location = "Thanchi, Bandarban, Bangladesh";

            description =
                    "Nilgiri is a beautiful mountain destination famous for its breathtaking hill views and clouds.";

            bestTime = "Early morning";

            travelTips =
                    "Check road conditions and follow local travel restrictions.";

        } else if (spot.equalsIgnoreCase("Nilachal")) {

            mainImage = R.drawable.nilachal;
            category = "Hill Viewpoint";
            location = "Bandarban Sadar, Bangladesh";

            description =
                    "Nilachal offers panoramic views of the green hills and beautiful landscapes of Bandarban.";

            bestTime = "Sunrise and sunset";

            travelTips =
                    "Carry a camera and be careful near viewpoint edges.";

        } else if (spot.equalsIgnoreCase("Boga Lake")) {

            mainImage = R.drawable.boga_lake;
            category = "Mountain Lake";
            location = "Ruma, Bandarban, Bangladesh";

            description =
                    "Boga Lake is a beautiful natural lake surrounded by high green mountains.";

            bestTime = "Winter season";

            travelTips =
                    "Plan your journey with local guides and check trekking conditions.";

        } else if (spot.equalsIgnoreCase("Nafakhum")) {

            mainImage = R.drawable.nafakhum;
            category = "Waterfall";
            location = "Thanchi, Bandarban, Bangladesh";

            description =
                    "Nafakhum is a spectacular waterfall surrounded by the natural beauty of the Bandarban hills.";

            bestTime = "After checking seasonal river conditions";

            travelTips =
                    "Use an experienced local guide and avoid dangerous currents.";

        }

        // SUNDARBANS

        else if (spot.equalsIgnoreCase("Karamjal")) {

            mainImage = R.drawable.karamjal;
            category = "Wildlife and Forest Destination";
            location = "Sundarbans, Bangladesh";

            description =
                    "Karamjal is a popular eco-tourism destination known for its mangrove forest and wildlife facilities.";

            bestTime = "Winter season";

            travelTips =
                    "Follow forest authority rules and never disturb wildlife.";

        } else if (spot.equalsIgnoreCase("Harbaria")) {

            mainImage = R.drawable.harbaria;
            category = "Mangrove Forest";
            location = "Sundarbans, Bangladesh";

            description =
                    "Harbaria is known for its beautiful mangrove forest, wooden walking trails and natural surroundings.";

            bestTime = "Winter season";

            travelTips =
                    "Stay on designated trails and follow forest security instructions.";

        } else if (spot.equalsIgnoreCase("Katka")) {

            mainImage = R.drawable.katka;
            category = "Wildlife and Beach Destination";
            location = "Sundarbans, Bangladesh";

            description =
                    "Katka is a scenic Sundarbans destination famous for its forest, wildlife and coastal landscape.";

            bestTime = "Winter season";

            travelTips =
                    "Travel with an authorized tour operator and maintain a safe distance from wildlife.";

        } else if (spot.equalsIgnoreCase("Hiron Point")) {

            mainImage = R.drawable.hiron_point;
            category = "Wildlife Sanctuary";
            location = "Sundarbans, Bangladesh";

            description =
                    "Hiron Point is a beautiful wildlife area in the Sundarbans, surrounded by mangrove forest and waterways.";

            bestTime = "Winter season";

            travelTips =
                    "Follow forest department instructions and avoid disturbing wildlife.";
        }

        // SET DETAILS

        spotName.setText(spot);
        spotCategory.setText(category);
        spotLocation.setText(location);
        spotDescription.setText(description);
        spotBestTime.setText(bestTime);
        spotTravelTips.setText(travelTips);

        // SET MAIN IMAGE

        spotMainImage.setImageResource(mainImage);

        // SAME IMAGE IN SIX GALLERY POSITIONS

        galleryImage1.setImageResource(mainImage);
        galleryImage2.setImageResource(mainImage);
        galleryImage3.setImageResource(mainImage);
        galleryImage4.setImageResource(mainImage);
        galleryImage5.setImageResource(mainImage);
        galleryImage6.setImageResource(mainImage);
    }
}

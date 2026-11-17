
package com.zubu.zerobite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantListActivity extends AppCompatActivity {

    TextView backButton, listEyebrow, listTitle, listSubtitle, restaurantCount;

    TextView[] names = new TextView[3];
    TextView[] types = new TextView[3];
    TextView[] ratings = new TextView[3];
    TextView[] locations = new TextView[3];

    ImageView[] images = new ImageView[3];
    View[] cards = new View[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        backButton = findViewById(R.id.backButton);
        listEyebrow = findViewById(R.id.listEyebrow);
        listTitle = findViewById(R.id.listTitle);
        listSubtitle = findViewById(R.id.listSubtitle);
        restaurantCount = findViewById(R.id.restaurantCount);

        names[0] = findViewById(R.id.restaurantName1);
        names[1] = findViewById(R.id.restaurantName2);
        names[2] = findViewById(R.id.restaurantName3);

        types[0] = findViewById(R.id.restaurantType1);
        types[1] = findViewById(R.id.restaurantType2);
        types[2] = findViewById(R.id.restaurantType3);

        ratings[0] = findViewById(R.id.restaurantRating1);
        ratings[1] = findViewById(R.id.restaurantRating2);
        ratings[2] = findViewById(R.id.restaurantRating3);

        locations[0] = findViewById(R.id.restaurantLocation1);
        locations[1] = findViewById(R.id.restaurantLocation2);
        locations[2] = findViewById(R.id.restaurantLocation3);

        images[0] = findViewById(R.id.restaurantImage1);
        images[1] = findViewById(R.id.restaurantImage2);
        images[2] = findViewById(R.id.restaurantImage3);

        cards[0] = findViewById(R.id.restaurantItem1);
        cards[1] = findViewById(R.id.restaurantItem2);
        cards[2] = findViewById(R.id.restaurantItem3);

        backButton.setOnClickListener(v -> finish());

        String receivedDestination = getIntent().getStringExtra("destination");

        final String destination = receivedDestination == null
                ? "Cox's Bazar"
                : receivedDestination;

        loadRestaurants(destination);

        for (int i = 0; i < 3; i++) {
            final int position = i;

            cards[i].setOnClickListener(v -> {
                String restaurantName = names[position].getText().toString();

                Intent intent = new Intent(
                        RestaurantListActivity.this,
                        RestaurantDetailsActivity.class
                );

                intent.putExtra("restaurantName", restaurantName);
                intent.putExtra("destination", destination);

                startActivity(intent);
            });
        }
    }

    private void loadRestaurants(String destination) {

        listEyebrow.setText("EXPLORE LOCAL DINING");
        listTitle.setText(destination);
        listSubtitle.setText("Discover food and restaurants in " + destination);

        String[][] data;
        int[] restaurantImages;

        switch (destination) {

            case "Sajek Valley":

                data = new String[][]{
                        {"Runhmui Restaurant", "Local Bengali Food", "Sajek Valley"},
                        {"Montana Restaurant", "Restaurant", "Sajek Valley"},
                        {"Kashbon Restaurant", "Local Food", "Sajek Valley"}
                };

                restaurantImages = new int[]{
                        R.drawable.runhmui_restaurant_exterior,
                        R.drawable.montana_restaurant_exterior,
                        R.drawable.kashbon_restaurant_exterior
                };

                break;

            case "Sylhet":

                data = new String[][]{
                        {"Panshi Restaurant", "Bengali & Traditional Food", "Zindabazar, Sylhet"},
                        {"Pach Bhai Restaurant", "Bengali Food", "Sylhet"}
                };

                restaurantImages = new int[]{
                        R.drawable.panshi_restaurant_exterior,
                        R.drawable.pach_bhai_restaurant_exterior
                };

                break;


            case "Bandarban":

                data = new String[][]{
                        {"Re Khyaing", "Local Traditional Food", "Bandarban"}
                };

                restaurantImages = new int[]{
                        R.drawable.re_khyaing_restaurant_exterior,
                        R.drawable.nilachal,
                        R.drawable.boga_lake
                };

                break;



            case "Sundarbans":

                data = new String[][]{
                        {"Tour Boat Meal Arrangement", "Meals arranged through tour operators", "Sundarbans Tour"},
                        {"Local Food Arrangement", "Local meals during the tour", "Sundarbans"}
                };

                restaurantImages = new int[]{
                        R.drawable.sundarban_boat_meal,
                        R.drawable.sundarban_local_food
                };

                break;


            default:

                data = new String[][]{
                        {"Palongki Restaurant", "Seafood & Bengali", "Kolatoli, Cox's Bazar"},
                        {"Salt Bistro & Cafe", "Cafe & International Food", "Kolatoli, Cox's Bazar"},
                        {"Mermaid Cafe", "Seafood & Beachside Cafe", "Cox's Bazar"}
                };

                restaurantImages = new int[]{
                        R.drawable.palongki_restaurant_exterior,
                        R.drawable.salt_bistro_exterior,
                        R.drawable.mermaid_cafe_exterior
                };

                break;
        }

        restaurantCount.setText(data.length + " PLACES TO EXPLORE");

        for (int i = 0; i < 3; i++) {

            if (i < data.length) {

                cards[i].setVisibility(View.VISIBLE);

                names[i].setText(data[i][0]);
                types[i].setText(data[i][1]);
                locations[i].setText(data[i][2]);

                images[i].setImageResource(restaurantImages[i]);

                ratings[i].setText("Explore");

            } else {

                cards[i].setVisibility(View.GONE);
            }
        }
    }
}


package com.zubu.zerobite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantDetailsActivity extends AppCompatActivity {

    TextView backButton;
    TextView restaurantName, restaurantType, restaurantRating;
    TextView restaurantLocation, restaurantDescription;

    TextView[] foodNames = new TextView[4];
    TextView[] foodDescriptions = new TextView[4];
    TextView[] foodPrices = new TextView[4];

    ImageView restaurantImage;
    ImageView[] foodImages = new ImageView[4];

    View foodItem4;
    Button bookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        backButton = findViewById(R.id.backButton);
        restaurantImage = findViewById(R.id.restaurantMainImage);

        restaurantName = findViewById(R.id.restaurantDetailName);
        restaurantType = findViewById(R.id.restaurantDetailType);
        restaurantRating = findViewById(R.id.restaurantDetailRating);
        restaurantLocation = findViewById(R.id.restaurantDetailLocation);
        restaurantDescription = findViewById(R.id.restaurantDetailDescription);

        foodNames[0] = findViewById(R.id.foodName1);
        foodNames[1] = findViewById(R.id.foodName2);
        foodNames[2] = findViewById(R.id.foodName3);
        foodNames[3] = findViewById(R.id.foodName4);

        foodDescriptions[0] = findViewById(R.id.foodDescription1);
        foodDescriptions[1] = findViewById(R.id.foodDescription2);
        foodDescriptions[2] = findViewById(R.id.foodDescription3);
        foodDescriptions[3] = findViewById(R.id.foodDescription4);

        foodPrices[0] = findViewById(R.id.foodPrice1);
        foodPrices[1] = findViewById(R.id.foodPrice2);
        foodPrices[2] = findViewById(R.id.foodPrice3);
        foodPrices[3] = findViewById(R.id.foodPrice4);

        foodImages[0] = findViewById(R.id.foodImage1);
        foodImages[1] = findViewById(R.id.foodImage2);
        foodImages[2] = findViewById(R.id.foodImage3);
        foodImages[3] = findViewById(R.id.foodImage4);

        foodItem4 = (View) foodNames[3].getParent().getParent();

        bookButton = findViewById(R.id.restaurantBookButton);

        backButton.setOnClickListener(v -> finish());

        String name = getIntent().getStringExtra("restaurantName");

        if (name == null) {
            name = "Palongki Restaurant";
        }

        loadRestaurantDetails(name);

        bookButton.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "Table booking will be available soon!",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }

    private void loadRestaurantDetails(String name) {

        restaurantName.setText(name);
        restaurantRating.setText("Rating information to be verified");

        // COX'S BAZAR - PALONGKI
        if (name.equals("Palongki Restaurant")) {

            restaurantType.setText("Seafood • Bengali Cuisine");
            restaurantLocation.setText("Kolatoli, Cox's Bazar");
            restaurantDescription.setText(
                    "Explore seafood and Bengali cuisine at Palongki Restaurant."
            );

            restaurantImage.setImageResource(R.drawable.palongki_restaurant_exterior);
            foodItem4.setVisibility(View.VISIBLE);

            setFood(
                    new String[]{"Seafood Platter", "Grilled Fish", "Chicken Biryani", "Orange Juice"},
                    new String[]{"Seafood selection", "Grilled fish preparation", "Traditional rice dish", "Fresh orange juice"},
                    new int[]{
                            R.drawable.seafood_platter,
                            R.drawable.grilled_fish,
                            R.drawable.chicken_biryani,
                            R.drawable.palongki_orange_juice
                    }
            );
        }

        // COX'S BAZAR - SALT BISTRO
        else if (name.equals("Salt Bistro & Cafe")) {

            restaurantType.setText("Cafe • International Cuisine");
            restaurantLocation.setText("Cox's Bazar");
            restaurantDescription.setText(
                    "Explore cafe-style dining and international food options."
            );

            restaurantImage.setImageResource(R.drawable.salt_bistro_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Burger", "Creamy Pasta", "Cappuccino & Cake"},
                    new String[]{"Burger with delicious toppings", "Creamy pasta preparation", "Coffee served with cake"},
                    new int[]{
                            R.drawable.salt_burger,
                            R.drawable.salt_creamy_pasta,
                            R.drawable.salt_cappuccino_cake
                    }
            );
        }

        // COX'S BAZAR - MERMAID CAFE
        else if (name.equals("Mermaid Cafe")) {

            restaurantType.setText("Seafood • Beachside Cafe");
            restaurantLocation.setText("Cox's Bazar");
            restaurantDescription.setText(
                    "Explore a beachside cafe dining experience."
            );

            restaurantImage.setImageResource(R.drawable.mermaid_cafe_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Seafood Platter", "Shrimp Fried Rice", "Coconut Drink"},
                    new String[]{"Seafood selection", "Rice prepared with shrimp", "Refreshing coconut drink"},
                    new int[]{
                            R.drawable.mermaid_seafood_platter,
                            R.drawable.mermaid_shrimp_rice,
                            R.drawable.mermaid_coconut_drink
                    }
            );
        }

        // SAJEK - RUNHMUI RESTAURANT
        else if (name.equals("Runhmui Restaurant")) {

            restaurantType.setText("Local Bengali Food");
            restaurantLocation.setText("Sajek Valley");
            restaurantDescription.setText(
                    "Explore traditional Bengali-style meals in the beautiful Sajek Valley."
            );

            restaurantImage.setImageResource(R.drawable.runhmui_restaurant_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Chicken Curry", "Rice & Dal", "Vegetable Bhaji"},
                    new String[]{"Traditional chicken curry", "Steamed rice served with dal", "Freshly prepared vegetable bhaji"},
                    new int[]{
                            R.drawable.runhmui_chicken_curry,
                            R.drawable.runhmui_rice_dal,
                            R.drawable.runhmui_vegetable_bhaji
                    }
            );
        }

        // SAJEK - MONTANA RESTAURANT
        else if (name.equals("Montana Restaurant")) {

            restaurantType.setText("Restaurant • Local & Popular Food");
            restaurantLocation.setText("Sajek Valley");
            restaurantDescription.setText(
                    "Enjoy a selection of popular meals during your Sajek Valley trip."
            );

            restaurantImage.setImageResource(R.drawable.montana_restaurant_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Chicken BBQ", "Fried Rice", "Noodles"},
                    new String[]{"Grilled chicken barbecue", "Flavorful fried rice", "Prepared noodle dish"},
                    new int[]{
                            R.drawable.montana_chicken_bbq,
                            R.drawable.montana_fried_rice,
                            R.drawable.montana_noodles
                    }
            );
        }

        // SAJEK - KASHBON RESTAURANT
        else if (name.equals("Kashbon Restaurant")) {

            restaurantType.setText("Local Food • Traditional Cuisine");
            restaurantLocation.setText("Sajek Valley");
            restaurantDescription.setText(
                    "Explore traditional-style food and refreshments in Sajek."
            );

            restaurantImage.setImageResource(R.drawable.kashbon_restaurant_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Bamboo Chicken", "Traditional Khichuri", "Tea"},
                    new String[]{"Chicken prepared in bamboo style", "Traditional rice and lentil dish", "Warm refreshing tea"},
                    new int[]{
                            R.drawable.kashbon_bamboo_chicken,
                            R.drawable.kashbon_khichuri,
                            R.drawable.kashbon_tea
                    }
            );
        }

        // SYLHET - PANSHI RESTAURANT
        else if (name.equals("Panshi Restaurant")) {

            restaurantType.setText("Bengali • Traditional Cuisine");
            restaurantLocation.setText("Zindabazar, Sylhet");
            restaurantDescription.setText(
                    "Explore traditional Bengali meals and popular local food at Panshi Restaurant in Sylhet."
            );

            restaurantImage.setImageResource(R.drawable.panshi_restaurant_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Beef Curry", "Plain Rice", "Hilsa Fish"},
                    new String[]{"Traditional beef curry", "Steamed white rice", "Fresh Hilsa fish preparation"},
                    new int[]{
                            R.drawable.panshi_beef_curry,
                            R.drawable.panshi_plain_rice,
                            R.drawable.panshi_hilsa_fish
                    }
            );
        }

        // SYLHET - PACH BHAI RESTAURANT
        else if (name.equals("Pach Bhai Restaurant")) {

            restaurantType.setText("Bengali • Local Food");
            restaurantLocation.setText("Sylhet");
            restaurantDescription.setText(
                    "Explore Bengali food and traditional dishes at Pach Bhai Restaurant in Sylhet."
            );

            restaurantImage.setImageResource(R.drawable.pach_bhai_restaurant_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Chicken Curry", "Vegetable Bhaji", "Fried Rice"},
                    new String[]{"Traditional chicken curry", "Mixed vegetable dish", "Tasty fried rice"},
                    new int[]{
                            R.drawable.pach_bhai_chicken_curry,
                            R.drawable.pach_bhai_vegetable_bhaji,
                            R.drawable.pach_bhai_fried_rice
                    }
            );
        }

        // BANDARBAN - RE KHYAING
        else if (name.equals("Re Khyaing")) {

            restaurantType.setText("Local Traditional Food");
            restaurantLocation.setText("Bandarban");
            restaurantDescription.setText(
                    "Explore traditional-style local food during your Bandarban trip."
            );

            restaurantImage.setImageResource(R.drawable.re_khyaing_restaurant_exterior);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Chicken Curry", "Plain Rice", "Vegetable Bhaji"},
                    new String[]{
                            "Traditional chicken curry",
                            "Steamed white rice",
                            "Fresh vegetable bhaji"
                    },
                    new int[]{
                            R.drawable.re_khyaing_chicken_curry,
                            R.drawable.re_khyaing_plain_rice,
                            R.drawable.re_khyaing_vegetable_bhaji
                    }
            );
        }

        // SUNDARBANS - TOUR BOAT MEAL ARRANGEMENT
        else if (name.equals("Tour Boat Meal Arrangement")) {

            restaurantType.setText("Boat Dining • Traditional Bengali Food");
            restaurantLocation.setText("Sundarbans River Tour");

            restaurantDescription.setText(
                    "Experience a unique dining arrangement during your " +
                            "Sundarbans boat journey. Enjoy traditional Bengali meals " +
                            "surrounded by the beautiful mangrove forest and river scenery."
            );

            restaurantImage.setImageResource(R.drawable.sundarban_boat_meal);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{
                            "Rice & Fish Curry",
                            "Dal & Vegetable",
                            "Traditional Fish Fry"
                    },
                    new String[]{
                            "Steamed rice served with traditional Bengali fish curry",
                            "Freshly prepared lentils and seasonal vegetables",
                            "Traditional Bengali-style fried fish"
                    },
                    new int[]{
                            R.drawable.sundarban_local_food,
                            R.drawable.sundarban_local_food,
                            R.drawable.sundarban_local_food
                    }
            );
        }

        // SUNDARBANS - LOCAL FOOD ARRANGEMENT
        else if (name.equals("Local Food Arrangement")) {

            restaurantType.setText("Traditional Bengali • Local Cuisine");
            restaurantLocation.setText("Sundarbans Tour Area");

            restaurantDescription.setText(
                    "Discover traditional Bengali food during your Sundarbans " +
                            "tour. Enjoy rice, fresh fish curry, dal and locally prepared " +
                            "vegetable dishes as part of your travel experience."
            );

            restaurantImage.setImageResource(R.drawable.sundarban_local_food);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{
                            "Bengali Fish Curry & Rice",
                            "Traditional Dal",
                            "Seasonal Vegetable Bhaji"
                    },
                    new String[]{
                            "Traditional fish curry served with steamed rice",
                            "Freshly cooked Bengali-style lentil soup",
                            "Locally prepared seasonal vegetable dish"
                    },
                    new int[]{
                            R.drawable.sundarban_local_food,
                            R.drawable.sundarban_local_food,
                            R.drawable.sundarban_local_food
                    }
            );
        }

        // OTHER DESTINATIONS
        else {

            restaurantType.setText("Local Restaurant");
            restaurantLocation.setText("See restaurant location");
            restaurantDescription.setText(
                    "Restaurant information and menu details will be updated."
            );

            restaurantImage.setImageResource(R.drawable.cox);
            foodItem4.setVisibility(View.GONE);

            setFood(
                    new String[]{"Popular Food Item 1", "Popular Food Item 2", "Popular Food Item 3"},
                    new String[]{"Menu information to be updated", "Menu information to be updated", "Menu information to be updated"},
                    new int[]{R.drawable.cox, R.drawable.cox, R.drawable.cox}
            );
        }
    }

    private void setFood(String[] names, String[] descriptions, int[] images) {

        for (int i = 0; i < 4; i++) {

            if (i < names.length) {

                foodNames[i].setText(names[i]);
                foodDescriptions[i].setText(descriptions[i]);
                foodPrices[i].setText("Price: Check with restaurant");
                foodImages[i].setImageResource(images[i]);

            }
        }
    }
}

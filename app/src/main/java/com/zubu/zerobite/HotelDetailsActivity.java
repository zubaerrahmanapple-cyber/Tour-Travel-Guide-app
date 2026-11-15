
package com.zubu.zerobite;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HotelDetailsActivity extends AppCompatActivity {

    private TextView hotelName, hotelLocation, hotelDescription;
    private TextView roomPrice, hotelAmenities;
    private TextView backButton;

    private ImageView hotelMainImage;

    private Button btnViewPhotos, btnBookNow;

    private String selectedHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        hotelName = findViewById(R.id.hotelName);
        hotelLocation = findViewById(R.id.hotelLocation);
        hotelDescription = findViewById(R.id.hotelDescription);
        roomPrice = findViewById(R.id.roomPrice);
        hotelAmenities = findViewById(R.id.hotelAmenities);

        hotelMainImage = findViewById(R.id.hotelMainImage);

        backButton = findViewById(R.id.backButton);
        btnViewPhotos = findViewById(R.id.btnViewPhotos);
        btnBookNow = findViewById(R.id.btnBookNow);

        selectedHotel = getIntent().getStringExtra("hotel_name");

        if (selectedHotel == null) {
            selectedHotel = "Sayeman Beach Resort";
        }

        // Back Button
        backButton.setOnClickListener(v -> finish());

        // HOTEL INFORMATION

        if (selectedHotel.equals("Megh Roddur Hill Resort")) {

            // MEGH RODDUR HILL RESORT

            hotelName.setText("Megh Roddur Hill Resort");

            hotelLocation.setText(
                    "Sajek Valley, Rangamati"
            );

            hotelDescription.setText(
                    "Enjoy the beautiful hills and peaceful natural " +
                            "environment of Sajek Valley at Megh Roddur Hill Resort. " +
                            "Experience a relaxing stay surrounded by scenic landscapes."
            );

            roomPrice.setText(
                    "Room rent: Contact resort for current rates"
            );

            hotelAmenities.setText(
                    "• Hill View\n" +
                            "• Comfortable Rooms\n" +
                            "• Restaurant Facilities\n" +
                            "• Room Service\n" +
                            "• Scenic Environment"
            );

            hotelMainImage.setImageResource(
                    R.drawable.megh_roddur1
            );

        } else if (selectedHotel.equals("Long Beach Hotel")) {

            // LONG BEACH HOTEL

            hotelName.setText("Long Beach Hotel");

            hotelLocation.setText(
                    "Kolatoli Road, Cox's Bazar"
            );

            hotelDescription.setText(
                    "Long Beach Hotel offers a comfortable stay " +
                            "in Cox's Bazar with modern accommodation, " +
                            "dining facilities and a relaxing environment."
            );

            roomPrice.setText(
                    "Room rent: Contact hotel for current rates"
            );

            hotelAmenities.setText(
                    "• Swimming Pool\n" +
                            "• Free Wi-Fi\n" +
                            "• Restaurant\n" +
                            "• Fitness Centre\n" +
                            "• Room Service"
            );

            hotelMainImage.setImageResource(
                    R.drawable.long_beach1
            );

        } else {

            // SAYEMAN BEACH RESORT

            hotelName.setText("Sayeman Beach Resort");

            hotelLocation.setText(
                    "Marine Drive Road, Cox's Bazar"
            );

            hotelDescription.setText(
                    "Enjoy a relaxing stay beside the beautiful sea " +
                            "at Sayeman Beach Resort. Explore the beach and " +
                            "experience a memorable trip."
            );

            roomPrice.setText(
                    "Room rent: Contact hotel for current rates"
            );

            hotelAmenities.setText(
                    "• Swimming Pool\n" +
                            "• Free Wi-Fi\n" +
                            "• Restaurant\n" +
                            "• Sea View Rooms\n" +
                            "• Room Service"
            );

            hotelMainImage.setImageResource(
                    R.drawable.hotel_cox1
            );
        }

        // VIEW ALL PHOTOS

        btnViewPhotos.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HotelDetailsActivity.this,
                    AllPhotosActivity.class
            );

            intent.putExtra("spot_name", selectedHotel);

            startActivity(intent);
        });

        // BOOK NOW BUTTON

        btnBookNow.setOnClickListener(v -> {

            new AlertDialog.Builder(HotelDetailsActivity.this)
                    .setTitle("Booking Request")
                    .setMessage(
                            "You selected " + selectedHotel +
                                    ". Please contact the hotel to confirm " +
                                    "room availability and current rent."
                    )
                    .setPositiveButton("OK", (dialog, which) ->
                            dialog.dismiss())
                    .show();
        });
    }
}

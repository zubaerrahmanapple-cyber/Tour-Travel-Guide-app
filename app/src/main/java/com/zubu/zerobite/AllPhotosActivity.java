package com.zubu.zerobite;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AllPhotosActivity extends AppCompatActivity {

    private ImageView[] photos;
    private TextView photosPlaceName;
    private TextView photosBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_photos);

        photosPlaceName = findViewById(R.id.photosPlaceName);
        photosBackButton = findViewById(R.id.photosBackButton);

        photos = new ImageView[]{
                findViewById(R.id.photo1),
                findViewById(R.id.photo2),
                findViewById(R.id.photo3),
                findViewById(R.id.photo4),
                findViewById(R.id.photo5),
                findViewById(R.id.photo6),
                findViewById(R.id.photo7),
                findViewById(R.id.photo8),
                findViewById(R.id.photo9),
                findViewById(R.id.photo10)
        };

        photosBackButton.setOnClickListener(v -> finish());

        String spot = getIntent().getStringExtra("spot_name");

        if (spot == null || spot.isEmpty()) {
            spot = "Laboni Beach";
        }

        showPhotos(spot);
    }

    private void showPhotos(String spot) {

        int[] imageResources;

        switch (spot) {

            // MEGH RODDUR HILL RESORT
            case "Megh Roddur Hill Resort":
                imageResources = new int[]{
                        R.drawable.megh_roddur1,
                        R.drawable.megh_roddur2,
                        R.drawable.megh_roddur3,
                        R.drawable.megh_roddur4,
                        R.drawable.megh_roddur5,
                        R.drawable.megh_roddur6,
                        R.drawable.megh_roddur7,
                        R.drawable.megh_roddur8,
                        R.drawable.megh_roddur9,
                        R.drawable.megh_roddur10
                };
                break;

            // SAYEMAN BEACH RESORT
            case "Sayeman Beach Resort":
                imageResources = new int[]{
                        R.drawable.hotel_cox1,
                        R.drawable.hotel_cox2,
                        R.drawable.hotel_cox3,
                        R.drawable.hotel_cox4,
                        R.drawable.hotel_cox5,
                        R.drawable.hotel_cox6,
                        R.drawable.hotel_cox7,
                        R.drawable.hotel_cox8,
                        R.drawable.hotel_cox9,
                        R.drawable.hotel_cox10
                };
                break;

            // LONG BEACH HOTEL
            case "Long Beach Hotel":
                imageResources = new int[]{
                        R.drawable.long_beach1,
                        R.drawable.long_beach2,
                        R.drawable.long_beach3,
                        R.drawable.long_beach4,
                        R.drawable.long_beach5,
                        R.drawable.long_beach6,
                        R.drawable.long_beach7,
                        R.drawable.long_beach8,
                        R.drawable.long_beach9,
                        R.drawable.long_beach10
                };
                break;

            // LABONI BEACH
            case "Laboni Beach":
                imageResources = new int[]{
                        R.drawable.laboni1,
                        R.drawable.laboni2,
                        R.drawable.laboni3,
                        R.drawable.laboni4,
                        R.drawable.laboni5,
                        R.drawable.laboni1
                };
                break;

            // HIMCHARI
            case "Himchari":
                imageResources = new int[]{
                        R.drawable.himchari,
                        R.drawable.himchari1,
                        R.drawable.himchari2,
                        R.drawable.himchari3,
                        R.drawable.himchari4,
                        R.drawable.himchari5
                };
                break;

            // INANI BEACH
            case "Inani Beach":
                imageResources = new int[]{
                        R.drawable.inani,
                        R.drawable.inani1,
                        R.drawable.inani2,
                        R.drawable.inani3,
                        R.drawable.inani4,
                        R.drawable.inani5
                };
                break;

            // DEFAULT
            default:
                imageResources = new int[]{
                        R.drawable.cox,
                        R.drawable.cox,
                        R.drawable.cox,
                        R.drawable.cox,
                        R.drawable.cox,
                        R.drawable.cox
                };
                break;
        }

        photosPlaceName.setText(spot);

        for (int i = 0; i < photos.length; i++) {

            if (i < imageResources.length) {
                photos[i].setVisibility(View.VISIBLE);
                photos[i].setImageResource(imageResources[i]);
            } else {
                photos[i].setVisibility(View.GONE);
            }
        }
    }
}

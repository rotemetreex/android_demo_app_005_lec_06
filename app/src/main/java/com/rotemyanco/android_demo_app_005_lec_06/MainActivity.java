package com.rotemyanco.android_demo_app_005_lec_06;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Build;
import android.os.Bundle;
import com.rotemyanco.android_demo_app_005_lec_06.models.Brand;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;




public class MainActivity extends AppCompatActivity {

    ArrayList<Brand> companiesOBJ;

    private int avatar = R.drawable.ic_launcher_foreground;

    String desc = "Lorem ipsum dolor sit amet. Et earum unde quo molestias " +
            "nobis rem dignissimos nisi quo doloribus aspernatur. Ea laborum " +
            "quam ab facere eius a nisi dolor sed voluptate totam et fugit " +
            "tempora qui optio voluptatum qui optio error.\n" +
            "\n" +
            "A tempora quia aut possimus voluptatibus id similique temporibus " +
            "id velit dolores. Qui quis quas non vitae consectetur ad quia " +
            "facilis.\n" +
            "\n" +
            "Quo ratione consequatur ea molestiae iure et quia facere aut nemo " +
            "voluptates et galisum placeat. Non perspiciatis dolores id omnis " +
            "repellendus aut harum sequi vel adipisci veniam hic vero dolore. " +
            "Est magnam eligendi sed incidunt molestias ut nulla sint qui quos " +
            "beatae sed quidem ducimus 33 fuga quos aut aliquid odit.";


    String[] companyNames = {
            "Android", "Apple", "Coca Cola", "Coca Cola", "Facebook", "Gmail", "Google",
            "Google Photos", "JetBrains", "Linkedin", "Gmail - official",
            "Pinersts 1", "Pinerets 5", "Tesla", "Soundcloud", "Spotify 1",
            "Spotify 2", "Whatsapp 3", "Whatsapp white", "YouTube"};

    int[] logos = {
            R.drawable.android_logo,
            R.drawable.apple_logo,
            R.drawable.coca_cola_logo_1,
            R.drawable.coca_cola_logo_4,
            R.drawable.facebook_logo,
            R.drawable.gmail_logo,
            R.drawable.google_g_2015_logo,
            R.drawable.google_photos_logo,
            R.drawable.jetbrains_logo_1,
            R.drawable.linkedin_logo,
            R.drawable.official_gmail_2020_logo,
            R.drawable.pinterest_logo_1,
            R.drawable.pinterest_logo_5,
            R.drawable.tesla_logo_9,
            R.drawable.soundcloud_logo,
            R.drawable.spotify_logo_1,
            R.drawable.spotify_logo_2,
            R.drawable.whatsapp_logo_3,
            R.drawable.whatsapp_white_logo,
            R.drawable.youtube_logo
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpData();

        RecyclerView rcvBrands = findViewById(R.id.rcv_company_list_activity_main);

        BrandAdapter brandAdapter = new BrandAdapter(companiesOBJ);

        rcvBrands.setAdapter(brandAdapter);

        rcvBrands.setLayoutManager(new LinearLayoutManager(this));


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private LocalDate generateRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1750, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setUpData() {
        companiesOBJ = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            Brand brand = new Brand(logos[i], avatar, companyNames[i], desc, generateRandomDate());
            companiesOBJ.add(brand);
        }
    }
}
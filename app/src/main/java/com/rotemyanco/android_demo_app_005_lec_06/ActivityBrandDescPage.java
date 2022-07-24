package com.rotemyanco.android_demo_app_005_lec_06;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.rotemyanco.android_demo_app_005_lec_06.models.Brand;


public class ActivityBrandDescPage extends AppCompatActivity {

    ImageView ivBigLogo;
    ImageView ivRoundAvatar;
    TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_desc_page);

        setViews();
        setViewsData();
    }

    private void setViews() {
        ivBigLogo = findViewById(R.id.iv_logo_activity_brand_desc_page);
        ivRoundAvatar = findViewById(R.id.iv_round_avatar_activity_brand_desc_page);
        tvDesc = findViewById(R.id.tv_desc_activity_brand_desc_page);
    }

    private void setViewsData() {
        Intent intent = getIntent();
        Brand brand = (Brand) intent.getSerializableExtra(BrandAdapter.BRAND);
        ivBigLogo.setImageResource(brand.getImg());
        ivRoundAvatar.setImageResource(brand.getAvatar());
        tvDesc.setText(brand.getDesc());
    }

}
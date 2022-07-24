package com.rotemyanco.android_demo_app_005_lec_06;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rotemyanco.android_demo_app_005_lec_06.models.Brand;

import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {

    private static final String TAG = "BrandAdapter";
    public static final String BRAND = "BRAND";
    private final ArrayList<Brand> companiesList;
    Context context;


    public BrandAdapter(ArrayList<Brand> companiesList) {
        this.companiesList = companiesList;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        context = parent.getContext();
        return new BrandViewHolder(LayoutInflater.from(context).inflate(R.layout.brand_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called");

        Brand brand = companiesList.get(position);

        holder.ivLogo.setImageResource(brand.getImg());
        holder.tvName.setText(brand.getName());
        holder.tvDate.setText(brand.getDate().toString());

        holder.cl.setOnClickListener(v -> {
            Intent intent = new Intent(context, ActivityBrandDescPage.class);
            intent.putExtra(BRAND, brand);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        if (companiesList == null) {
            return 0;
        }
        return companiesList.size();
    }

    static class BrandViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout cl;
        ImageView ivLogo;
        TextView tvName;
        TextView tvDate;

        public BrandViewHolder(@NonNull View itemView) {
            super(itemView);

            cl = itemView.findViewById(R.id.cl_brand_row);
            ivLogo = itemView.findViewById(R.id.iv_logo_brand_row);
            tvName  = itemView.findViewById(R.id.tv_name_brand_row);
            tvDate = itemView.findViewById(R.id.tv_date_brand_row);

        }
    }

}

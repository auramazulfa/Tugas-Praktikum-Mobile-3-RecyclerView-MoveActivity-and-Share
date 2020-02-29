package com.aurama.aplikasiandroid.klubbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MoveActivity extends AppCompatActivity {
    ImageView ivClub;
    TextView tvName, tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        ivClub = findViewById(R.id.iv_move_item_club);
        tvName = findViewById(R.id.tv_move_club_name);
        tvInfo = findViewById(R.id.tv_move_club_info);

        String clubName = getIntent().getStringExtra("club_name");
        String clubInfo = getIntent().getStringExtra("club_info");
        int clubImage = getIntent().getIntExtra("club_image",0);

        tvName.setText(clubName);
        tvInfo.setText(clubInfo);
        Glide.with(this)
                .asBitmap()
                .load(clubImage)
                .into(ivClub);
    }
}

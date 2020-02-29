package com.aurama.aplikasiandroid.klubbola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aurama.aplikasiandroid.klubbola.adapter.ListClubsAdapter;
import com.aurama.aplikasiandroid.klubbola.model.ClubsData;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvClub = findViewById(R.id.rv_club);
        rvClub.setHasFixedSize(true);

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvClub.setLayoutManager(new LinearLayoutManager(this));

        ListClubsAdapter listClubsAdapter = new ListClubsAdapter(ClubsData.getListData(),getApplicationContext());
        rvClub.setLayoutManager(new LinearLayoutManager(this));
        rvClub.setAdapter(listClubsAdapter);
    }
}

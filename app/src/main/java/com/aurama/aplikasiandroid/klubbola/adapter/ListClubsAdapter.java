package com.aurama.aplikasiandroid.klubbola.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aurama.aplikasiandroid.klubbola.MoveActivity;
import com.aurama.aplikasiandroid.klubbola.R;
import com.aurama.aplikasiandroid.klubbola.model.Clubs;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListClubsAdapter extends RecyclerView.Adapter<ListClubsAdapter.ViewHolder> {
    private ArrayList<Clubs> listClubs = new ArrayList<>();
    private Context context;

    public ListClubsAdapter(ArrayList<Clubs> listClubs, Context context) {
        this.listClubs = listClubs;
        this.context = context;
    }

    public ArrayList<Clubs> getListClubs() {
        return listClubs;
    }

    @NonNull
    @Override
    public ListClubsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListClubsAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(getListClubs().get(position).getPhoto()).into(holder.ivClub);
        holder.tvName.setText(getListClubs().get(position).getName());

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share Info " +
                        listClubs.get(holder.getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String clubInfo = "Klub Sepakbola "+getListClubs().get(position).getInfo();
                intent.putExtra(Intent.EXTRA_TEXT,clubInfo);
                context.startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });

        holder.btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu Memlih " +
                        listClubs.get(holder.getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MoveActivity.class);
                intent.putExtra("club_image", getListClubs().get(position).getPhoto());
                intent.putExtra("club_name",getListClubs().get(position).getName());
                intent.putExtra("club_info",getListClubs().get(position).getInfo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListClubs().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivClub;
        TextView tvName;
        Button btnShare, btnMove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivClub = itemView.findViewById(R.id.iv_item_club);
            tvName = itemView.findViewById(R.id.tv_club_name);
            btnShare = itemView.findViewById(R.id.btn_share);
            btnMove = itemView.findViewById(R.id.btn_lihat);
        }
    }
}

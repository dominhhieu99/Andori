package com.example.myapplication;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

class CateHolder extends RecyclerView.ViewHolder {
    public CircleImageView imgHuyNguyen;
    public TextView tvHuyNguyen,tvAdmin;
    public CateHolder(@NonNull View itemView) {
        super(itemView);
        imgHuyNguyen = itemView.findViewById(R.id.imgHuyNguyen);
        tvHuyNguyen = itemView.findViewById(R.id.tvHuyNguyen);
        tvAdmin = itemView.findViewById(R.id.tvAdmin);
    }
}

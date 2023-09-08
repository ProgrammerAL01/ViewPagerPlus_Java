package com.example.viewpagerplus_java;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public ViewPagerViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.txt_view);
    }

    void bindViews(ViewPagerModel model) {
        textView.setText(model.getDescription());
    }
}

package com.example.moviesdrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activity);

        ImageView im_show_details = findViewById(R.id.iv_details);
        TextView tv_show_details = findViewById(R.id.textView);

        Intent intent=getIntent();

        Picasso.get().load(intent.getStringExtra("image")).into(im_show_details);

        tv_show_details.setText(intent.getStringExtra("over"));



    }
}
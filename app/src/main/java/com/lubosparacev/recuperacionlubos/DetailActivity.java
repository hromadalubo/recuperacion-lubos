package com.lubosparacev.recuperacionlubos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Button likeButton;
    private TextView likesCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.item_image);
        titleTextView = findViewById(R.id.item_title);
        descriptionTextView = findViewById(R.id.item_description);
        likeButton = findViewById(R.id.like_button);
        likesCountTextView = findViewById(R.id.like_counter);

        Intent intent = getIntent();
        if (intent != null) {

            /*int imageResource = holder.itemView.getContext().getResources().getIdentifier(item.getImage(), "drawable", holder.itemView.getContext().getPackageName());
            holder.imageView.setImageResource(imageResource);*/

            int imageResourceId = getIntent().getIntExtra("imageResourceId", -1);
            String title = intent.getStringExtra("title");
            String description = intent.getStringExtra("description");
            int likesCount = intent.getIntExtra("likes_count", 0);

            if (imageResourceId != -1) {
                imageView.setImageResource(imageResourceId);
            }
            if (title != null) {
                titleTextView.setText(title);
            }
            if (description != null) {
                descriptionTextView.setText(description);
            }
            likesCountTextView.setText(String.valueOf(likesCount));
        }

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int likesCount = Integer.parseInt(likesCountTextView.getText().toString());
                likesCount++;
                likesCountTextView.setText(String.valueOf(likesCount));
            }
        });
    }
}

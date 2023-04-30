package com.lubosparacev.recuperacionlubos;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Adapter class
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Item> itemList;

    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.titleTextView.setText(item.getTitle());

        int imageResource = holder.itemView.getContext().getResources().getIdentifier(item.getImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageView.setImageResource(imageResource);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private Drawable getImageFromAssets(String image, Context context) {
        try {
            InputStream ims = context.getAssets().open(image);
            return Drawable.createFromStream(ims, image);
        } catch (IOException e) {
            Log.e("MyAdapter", "Error while trying to get image from assets: " + e.getMessage());
            return null;
        }
    }

    // View holder class
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleTextView;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_view);
            titleTextView = view.findViewById(R.id.title_text_view);
        }
    }
}


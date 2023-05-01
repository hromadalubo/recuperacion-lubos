package com.lubosparacev.recuperacionlubos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter class
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Item> itemList;
    private Context context;

    public MyAdapter(Context context, List<Item> itemList) {
        this.itemList = itemList;
        this.context = context;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("title", item.getTitle());
                intent.putExtra("description", item.getDescription());

                int imageResource = context.getResources().getIdentifier(item.getImage(), "drawable", context.getPackageName());
                intent.putExtra("imageResourceId", imageResource);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
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


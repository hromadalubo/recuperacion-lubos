package com.lubosparacev.recuperacionlubos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataSource dataSource = new DataSource(this);
        List<Item> items = dataSource.getItems();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(items);
        recyclerView.setAdapter(myAdapter);
    }

}

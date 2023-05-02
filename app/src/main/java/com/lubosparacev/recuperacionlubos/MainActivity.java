package com.lubosparacev.recuperacionlubos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    AmplifyCognito amplifyCognito;

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amplifyCognito = new AmplifyCognito(getApplicationContext());

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        DataSource dataSource = new DataSource(this);
        List<Item> items = dataSource.getItems();

        Context context = this;

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(context, items);
        recyclerView.setAdapter(myAdapter);

        signOutBtn = findViewById(R.id.signOutBtn);
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amplifyCognito.signOut();
            }
        });
    }

}

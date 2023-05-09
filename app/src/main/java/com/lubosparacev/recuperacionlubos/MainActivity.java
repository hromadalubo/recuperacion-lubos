package com.lubosparacev.recuperacionlubos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    AmplifyCognito amplifyCognito;

    RecyclerView recyclerView;
    MyAdapter myAdapter;

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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sign_out) {
            // Handle sign out action here
            amplifyCognito.signOut();
            amplifyCognito.loadLogin();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

package com.lubosparacev.recuperacionlubos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter = new MyAdapter(getMyList(), this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Item> getMyList() {
        ArrayList<Item> myItems = new ArrayList<>();

        myItems.add(new Item(R.drawable.android, "Android"));
        myItems.add(new Item(R.drawable.gamification, "Gamificación"));
        myItems.add(new Item(R.drawable.gestion, "Gestión Empresarial"));
        myItems.add(new Item(R.drawable.iot, "Internet Of Things"));
        myItems.add(new Item(R.drawable.m3_3d, "Modelado 3D"));
        myItems.add(new Item(R.drawable.m5_formacion_laboral, "Formación y Orientación Laboral"));
        myItems.add(new Item(R.drawable.m6_web, "Desarrollo Web"));
        myItems.add(new Item(R.drawable.m7_bases_de_datos, "Bases de Datos"));
        myItems.add(new Item(R.drawable.m10_empresa, "Prácticas de Fin de Curso"));
        myItems.add(new Item(R.drawable.m11_acesso_a_datos, "Acesso a Datos"));
        myItems.add(new Item(R.drawable.m12_servicios_procesos, "Servicios y Procesos"));
        myItems.add(new Item(R.drawable.m16_proyecto, "Proyecto de Fin de Curso"));
        myItems.add(new Item(R.drawable.streaming, "Streaming"));
        myItems.add(new Item(R.drawable.ui_ux, "UX / UI"));
        myItems.add(new Item(R.drawable.unity, "Unity"));
        myItems.add(new Item(R.drawable.ios, "iOS"));

        return myItems;

    }

}

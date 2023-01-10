package com.example.vaccineapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    VaccineModel[] listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
    }

    private void initiate() {
        recyclerView = findViewById(R.id.recyclerView);
        listData = new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine", R.drawable.vaccine1),
                new VaccineModel("Tetanus Vaccine", R.drawable.vaccine4),
                new VaccineModel("Pneumococcal Vaccine", R.drawable.vaccine5),
                new VaccineModel("Rotavirus Vaccine", R.drawable.vaccine6),
                new VaccineModel("Measles Virus", R.drawable.vaccine7),
                new VaccineModel("Cholera  Virus", R.drawable.vaccine8),
                new VaccineModel("Covid-19 Virus", R.drawable.vaccine9)
        };
        CustomAdapter adapter = new CustomAdapter(listData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener((view, position) -> {
            Toast.makeText(this, "Vaccine name: " + listData[position].getTitle(), Toast.LENGTH_SHORT).show();
        });
    }
}
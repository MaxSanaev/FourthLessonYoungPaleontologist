package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FlowersActivity extends AppCompatActivity {
    private ListView flowersList;

    private String[] arrayFlowers = {"Розы", "Ромашки", "Тюльпаны", "Гладиолусы", "Пионы", "Васильки"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);
        flowersList = findViewById(R.id.flowersList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.max_list_item_1, R.id.text_view ,arrayFlowers);

               flowersList.setAdapter(adapter);
    }
}
package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class XvoaActivity extends AppCompatActivity {

    private ListView xvoaList;
    private TextView xvoaOut;


    private String[] arrayxvoa = {"Ель", "Сосна", "Лиственница", "Кедр"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xvoa);


        xvoaList = findViewById(R.id.xvoaList);
        xvoaOut = findViewById(R.id.xvoaOut);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.max_list_item_1,  R.id.text_view,arrayxvoa);


        xvoaList.setAdapter(adapter);


       xvoaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String selectedItem = arrayxvoa[position];
              xvoaOut.setText(selectedItem);
            }
        });
    }
}

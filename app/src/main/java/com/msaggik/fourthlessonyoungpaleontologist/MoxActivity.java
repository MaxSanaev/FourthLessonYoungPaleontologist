package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MoxActivity extends AppCompatActivity {

    private ListView moxList; // поле вывода информации на экран
    private EditText moxIn; // поле ввода новых данных
    private ImageButton btnAdd; // поле кнопки добавить данные
    private ImageButton btnDelete; // поле кнопки удалить данные

    // массив данных животных палеозойского периода
    private ArrayList<String> plant = new ArrayList<String>(); // создание коллекции массива для хранения данных о животных
    private ArrayList<String> selectedPlant = new ArrayList<String>(); // создание временной коллекции выбранных животных

    // создание адаптера
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mox);

        // присваивание id полям
       moxList = findViewById(R.id.moxList);
        moxIn = findViewById(R.id.moxIn);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);


        Collections.addAll(plant, "Печеночные", "Антоцеротовые", "Тортула стенная");

              adapter = new ArrayAdapter<>(this,R.layout.max_list_item_muliple_choice,R.id.textMax, plant);


       moxList.setAdapter(adapter);


        moxList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long l) {

                String animalItem = adapter.getItem(position);
                if(moxList.isItemChecked(position))
                    selectedPlant.add(animalItem);
                else {
                    selectedPlant.remove(animalItem);
                }
            }
        });


        btnAdd.setOnClickListener(listener);
        btnDelete.setOnClickListener(listener);
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnAdd:

                    String animalIn = moxIn.getText().toString();

                    if (!animalIn.isEmpty()) {
                        adapter.add(animalIn);
                        moxIn.setText("");
                        adapter.notifyDataSetChanged();
                    }
                    break;

                case R.id.btnDelete:


                    for (int i = 0; i < selectedPlant.size(); i++) {
                        adapter.remove(selectedPlant.get(i));
                    }
                    selectedPlant.clear();
                    moxList.clearChoices();
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
}

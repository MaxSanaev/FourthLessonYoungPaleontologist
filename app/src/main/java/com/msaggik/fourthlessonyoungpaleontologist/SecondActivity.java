package com.msaggik.fourthlessonyoungpaleontologist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {

    private ImageButton imageButtonFlower;
    private ImageButton imageButtonMox;
    private ImageButton imageButtonXvoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageButtonFlower = findViewById(R.id.imageButtonFlower);
        imageButtonMox = findViewById(R.id.imageButtonMox);
        imageButtonXvoa = findViewById(R.id.imageButtonXvoa);

        imageButtonFlower.setOnClickListener(listener);
        imageButtonMox.setOnClickListener(listener);
        imageButtonXvoa.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.imageButtonFlower:
                    Intent intentFlower = new Intent(getApplicationContext(), FlowersActivity.class);
                    intentFlower.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intentFlower);
                    break;
                case R.id.imageButtonMox:
                    Intent intentMox = new Intent(getApplicationContext(), MoxActivity.class);
                    intentMox.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentMox);
                    break;
                case R.id.imageButtonXvoa:
                    Intent intentXvoa = new Intent(getApplicationContext(), XvoaActivity.class);
                    intentXvoa.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentXvoa);
                    break;
            }
        }
    };
}
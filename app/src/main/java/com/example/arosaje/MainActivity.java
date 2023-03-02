package com.example.arosaje;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnMesPlantes;
    private Button btnGardiennage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMesPlantes = findViewById(R.id.btnMesPlantes);
        btnGardiennage = findViewById(R.id.btnGardiennage);

        btnMesPlantes.setOnClickListener(btnMesPlantesListener);
        btnGardiennage.setOnClickListener(btnGardiennageListener);
    }

    private View.OnClickListener btnMesPlantesListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, MesPlantesActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener btnGardiennageListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, GardiennageActivity.class);
            startActivity(intent);

        }
    };
}
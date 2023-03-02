package com.example.arosaje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListePlanteActivity extends AppCompatActivity {

    private Button btnretour;
    private TextView tvNomPlante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_plante);

        btnretour = (Button) findViewById(R.id.btnRetour);
        tvNomPlante = (TextView) findViewById(R.id.edNomPlante);

        btnretour.setOnClickListener(btnretourListener);
    }

    private View.OnClickListener btnretourListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };
}
package com.example.arosaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GardiennageActivity extends AppCompatActivity {

    private ListView lvAnnonce;
    private ListView lvMesGardiennage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardiennage);

        lvAnnonce = (ListView) findViewById(R.id.lvAnnonce);
        lvMesGardiennage = (ListView) findViewById(R.id.lvMesGardiennage);



        //Remplissage de la liste
        List<String> annonceListe = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            String annonce = new String("annonce "+String.valueOf(i));
            annonceListe.add(annonce);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, annonceListe);
        lvAnnonce.setAdapter(arrayAdapter);

        lvAnnonce.setOnItemClickListener(lvAnnonceListener);


        //Remplissage de la liste
        List<String> gardiennageListe = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            String gardiennage = new String("gardiennage "+String.valueOf(i));
            annonceListe.add(gardiennage);
        }
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, gardiennageListe);
        lvMesGardiennage.setAdapter(arrayAdapter);

        lvMesGardiennage.setOnItemClickListener(lvMesGardiennageListener);
    }

    private AdapterView.OnItemClickListener lvAnnonceListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Object obj = lvAnnonce.getItemAtPosition(position);
            String Annonce = (String) obj;
            Intent intent = new Intent(GardiennageActivity.this, ListePlanteActivity.class);
            intent.putExtra("parAnnonce", Annonce);
            startActivity(intent);
        }
    };

    private AdapterView.OnItemClickListener lvMesGardiennageListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Object obj = lvMesGardiennage.getItemAtPosition(position);
            String Gardiennage = (String) obj;
            Intent intent = new Intent(GardiennageActivity.this, ListePlanteActivity.class);
            intent.putExtra("parGardiennage", Gardiennage);
            startActivity(intent);
        }
    };
}
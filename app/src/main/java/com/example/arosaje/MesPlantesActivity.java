package com.example.arosaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MesPlantesActivity extends AppCompatActivity {

    private Button btnStatut;
    private FloatingActionButton fab;
    private TextView tvStatut;
    private ListView lvPlante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_plantes);

        btnStatut = (Button) findViewById(R.id.btnStatut);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvPlante = (ListView) findViewById(R.id.lvPlante);
        tvStatut = (TextView) findViewById(R.id.tvStatut);
        btnStatut.setOnClickListener(btnStatutListener);
        fab.setOnClickListener(fabListener);

        //Remplissage de la liste
        List<String> planteListe = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            String plante = new String("plante "+String.valueOf(i));
            planteListe.add(plante);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, planteListe);
        }
        AppData appData = AppData.getInstance();
        List<Plante>listePlantes = appData.listPlantes;
        ArrayAdapter<Plante> arrayAdapter = new ArrayAdapter<Plante>(this, android.R.layout.simple_selectable_list_item, listePlantes);
        lvPlante.setAdapter(arrayAdapter);
        lvPlante.setOnItemClickListener(lvPlanteListener);

        // Statut gardiennage
        User user = appData.listUsers.get(appData.courantUserId);
        switch (user.getstatusGardiennage()) {
            case 1:
                tvStatut.setText("Demande en cours");
                btnStatut.setText("Annuler");
                break;
            case 2:
                tvStatut.setText("En cours");
                btnStatut.setText("Arreter");
                break;
            default:
                tvStatut.setText("Aucun");
                btnStatut.setText("Demander");
                break;
        }
    }

    @Override
    protected void onResume () {
        super.onResume();
        AppData appData = AppData.getInstance();

        for (int i = 0; i<appData.nbPlantes; i++){
            Log.i("TAG", "onResume: "+appData.listPlantes.get(i));
        }
        ArrayAdapter<Plante> arrayAdapter = new ArrayAdapter<Plante>(this, android.R.layout.simple_selectable_list_item, appData.listPlantes);
        lvPlante.setAdapter(arrayAdapter);
    }

    private View.OnClickListener fabListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MesPlantesActivity.this, FichePlanteActivity.class);
            intent.putExtra("mode", "edition");
            startActivity(intent);
        }
    };

    private View.OnClickListener btnStatutListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AppData appData = AppData.getInstance();
            User user = appData.listUsers.get(appData.courantUserId);
            int statut = ((user.getstatusGardiennage()+1)%3);
            user.setstatusGardiennage(statut);
            Log.i("TAG", "onClick: "+statut);
            switch (statut) {
                case 1:
                    tvStatut.setText("Demande en cours");
                    btnStatut.setText("Annuler");
                    break;
                case 2:
                    tvStatut.setText("En cours");
                    btnStatut.setText("Arreter");
                    break;
                default:
                    tvStatut.setText("Aucun");
                    btnStatut.setText("Demander");
                    break;
            }

        }
    };

    private AdapterView.OnItemClickListener lvPlanteListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Object obj = lvPlante.getItemAtPosition(position);
            Plante plante = (Plante) obj;
            Intent intent = new Intent(MesPlantesActivity.this, FichePlanteActivity.class);
            intent.putExtra("mode", "visualisation");
            intent.putExtra("planteId", plante.getPlanteId().toString());
            Log.i("TAG", "OnItemClickListener: photo :"+plante.getPhoto());
            startActivity(intent);
        }
    };

}
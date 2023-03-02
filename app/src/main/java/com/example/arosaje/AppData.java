package com.example.arosaje;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AppData {
    private static AppData instance = new AppData();
    
    public static AppData getInstance(){return instance;}
    
    public static void setInstance(AppData instance) {AppData.instance = instance;}
    
    public Integer courantUserId;
    public List<User> listUsers;
    public Integer nbUsers;
    public List<Plante> listPlantes;
    public Integer nbPlantes;
    public String imageTemp = "";


    private AppData() {
        listUsers = new ArrayList<>();
        courantUserId = 0;
        for (int i = 0; i < 5; i++){
            User user = new User ("USER "+String.valueOf(i), i, 0);
            Log.i("DEBUG", user.getNomUtilisateur());
            listUsers.add(user);
        }
        listPlantes = new ArrayList<>();
        nbPlantes = 10;
        for (Integer i = 0; i < nbPlantes; i++){
            Plante plante = new Plante ("Plante "+String.valueOf(i), i, i, "","2023-02-03T"+String.valueOf(i)+"15:30", "Paris", "aucun");
            listPlantes.add(plante);
        }
    }
}
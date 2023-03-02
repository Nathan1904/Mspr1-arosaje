package com.example.arosaje;

public class User {
    private String nomUtilisateur;
    private Integer userId;
    // Aucun = 0, Demande = 1, En cours = 2
    private Integer statusGardiennage;


    public User(String nomUtilisateur, Integer userId, Integer statusGardiennage) {
        this.nomUtilisateur = nomUtilisateur;
        this.userId = userId;
        this.statusGardiennage = statusGardiennage;

    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getstatusGardiennage() {
        return statusGardiennage;
    }

    public void setstatusGardiennage(Integer statusGardiennage) {
        this.statusGardiennage = statusGardiennage;
    }
}
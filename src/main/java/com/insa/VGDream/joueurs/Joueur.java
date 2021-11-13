package com.insa.VGDream.joueurs;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Joueur implements Serializable {
    private static final long serialVersionUID = 87638236982367L;
    @Id
    private String id;
    private String prenom, nom, password;

    public Joueur(String id, String prenom, String nom, String password) {
        super();
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
    }

    public Joueur() {
        super();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

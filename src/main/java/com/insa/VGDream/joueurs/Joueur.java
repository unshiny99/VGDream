package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Joueur implements Serializable {
    private static final long serialVersionUID = 87638236982367L;
    @Id
    private String id;
    private String prenom, nom, password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Jeu> jeux;

    public Joueur(String id, String prenom, String nom, String password, Collection<Jeu> jeux) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
        this.jeux = jeux;
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

    public Collection<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(Collection<Jeu> jeux) {
        this.jeux = jeux;
    }
}

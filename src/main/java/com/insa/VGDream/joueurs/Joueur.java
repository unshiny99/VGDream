package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Joueur implements Serializable {
    private static final long serialVersionUID = 87638236982367L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @NotEmpty
    private String prenom, nom, password;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "joueurs")
    private Collection<Jeu> jeux;

    public Joueur(Long id, String pseudo, String prenom, String nom, String password, Collection<Jeu> jeux) {
        this.id = id;
        this.username = pseudo;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

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
    @NotEmpty
    private String prenom, nom, pseudo, password;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "joueurs", cascade = CascadeType.DETACH)
    private Collection<Jeu> jeux;

    public Joueur(Long id, String prenom, String nom, String pseudo, String password, Collection<Jeu> jeux) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.pseudo = pseudo;
        this.password = password;
        this.jeux = jeux;
    }

    public Joueur() {
        super();
    }

    @PreRemove
    public void removeGamesFromPlayer() {
        for (Jeu j : this.getJeux()) {
            j.getJoueurs().remove(this);
        }
    }

    public void addGame(Jeu jeu){
        this.jeux.add(jeu);
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", jeux=" + jeux +
                '}';
    }
}

package com.insa.VGDream.jeux;

import com.insa.VGDream.joueurs.Joueur;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Jeu implements Serializable {
    private static final long serialVersionUID = 87638236982367L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String nom, studioDev, description, categorie;
    private Date dateSortie;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Joueur> joueurs;

    public Jeu() {
        super();
    }

    public Jeu(Long id, String nom, String studioDev, String description, String categorie, Date dateSortie, Collection<Joueur> joueurs) {
        this.id = id;
        this.nom = nom;
        this.studioDev = studioDev;
        this.description = description;
        this.categorie=categorie;
        this.dateSortie = dateSortie;
        this.joueurs = joueurs;
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

    public String getStudioDev() {
        return studioDev;
    }

    public void setStudioDev(String studioDev) {
        this.studioDev = studioDev;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Collection<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Collection<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}

package com.insa.VGDream.jeux;

import java.io.Serializable;
import java.util.Date;

public class JeuDTO implements Serializable {
    private static final long serialVersionUID = 87638236982367L;

    private int id;
    private String nom, studioDev, description, categorie;
    private Date dateSortie;

    public JeuDTO() {
        super();
    }

    public JeuDTO(int id, String nom, String studioDev, String description, String categorie, Date dateSortie) {
        this.id = id;
        this.nom = nom;
        this.studioDev = studioDev;
        this.description = description;
        this.categorie=categorie;
        this.dateSortie = dateSortie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}

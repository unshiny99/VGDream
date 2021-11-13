package com.insa.VGDream.jeux;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class Jeu implements Serializable {
    private static final long serialVersionUID = -8537962680206576813L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom, studioDev, description;
    private Date dateSortie;

    public Jeu() {
        super();
    }

    public Jeu(int id, String nom, String studioDev, String description, Date dateSortie) {
        super();
        this.id = id;
        this.nom = nom;
        this.studioDev = studioDev;
        this.description = description;
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

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
}

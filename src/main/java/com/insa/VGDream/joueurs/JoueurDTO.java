package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import com.insa.VGDream.jeux.JeuDTO;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

public class JoueurDTO {
    private static final long serialVersionUID = 87638236982367L;

    private Long id;
    private String prenom, nom, password;

    private Collection<JeuDTO> jeux;

    public JoueurDTO(Long id, String prenom, String nom, String password, Collection<JeuDTO> jeux) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
        this.jeux = jeux;
    }

    public JoueurDTO() {
        super();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public Collection<JeuDTO> getJeux() {
        return jeux;
    }

    public void setJeux(Collection<JeuDTO> jeux) {
        this.jeux = jeux;
    }
}

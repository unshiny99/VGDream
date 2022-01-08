package com.insa.VGDream;

import com.insa.VGDream.jeux.Jeu;
import com.insa.VGDream.jeux.JeuRepository;
import com.insa.VGDream.joueurs.Joueur;
import com.insa.VGDream.joueurs.JoueurRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {
    protected JoueurRepository joueurRepository;
    protected JeuRepository jeuRepository;
    protected Joueur joueur;
    protected Jeu jeu;

    @Before
    public void setUp() {
        joueur = new Joueur();
    }

    @After
    public void tearDown() {
        System.out.println("Test du joueur terminé");
    }

    @Test
    public void saveJoueur() {
        joueurRepository.save(joueur);
    }

    @Test
    public void addJeu() {
        joueur.addGame(jeu);
        joueurRepository.save(joueur);
        jeu.addJoueur(joueur);
        jeuRepository.save(jeu);
    }

    @Test
    public void deleteJoueur() {
        joueurRepository.delete(joueur);
    }
}

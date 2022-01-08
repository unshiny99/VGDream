package com.insa.VGDream;

import com.insa.VGDream.joueurs.Joueur;
import com.insa.VGDream.joueurs.JoueurRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {
    protected JoueurRepository joueurRepository;
    protected Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur();
    }

    @After
    public void tearDown() {
        System.out.println("");
    }

    @Test
    public void saveJoueur() {
        joueurRepository.save(joueur);
    }

    @Test
    public void deleteJoueur() {
        joueurRepository.delete(joueur);
    }
}

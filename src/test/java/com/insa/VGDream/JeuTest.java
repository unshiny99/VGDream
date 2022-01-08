package com.insa.VGDream;

import com.insa.VGDream.jeux.Jeu;
import com.insa.VGDream.jeux.JeuRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class JeuTest {
    protected JeuRepository jeuRepository;
    protected Jeu jeu;

    @Before
    public void setUp() {
        jeu = new Jeu((long)1,"Test","test développeur","test description","test catégorie",new Date("2022-01-08"));
    }

    @After
    public void tearDown() {
        System.out.println("Test du jeu terminé.");
    }

    /**
     * test save a game
     */
    @Test
    public void saveJeu() {
        try {
            jeuRepository.save(jeu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * test delete a game
     */
    @Test
    public void deleteJeu() {
        try {
            jeuRepository.delete(jeu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

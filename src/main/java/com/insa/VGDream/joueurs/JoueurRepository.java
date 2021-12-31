package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    Joueur findByPseudo(String pseudo);
    long countByPseudo(String pseudo);
}

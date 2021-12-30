package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    Joueur findByPseudo(String pseudo);
    long countByPseudo(String pseudo);

    @Query("update Joueur j set j.jeux=:jeu where j.id in :id")
    @Modifying
    @Transactional
    void updateJoueur(@Param("id") Long id, @Param("jeu") Jeu jeu);
}

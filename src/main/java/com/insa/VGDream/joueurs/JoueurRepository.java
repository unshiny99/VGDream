package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public interface JoueurRepository extends CrudRepository<Joueur, Long> {
    String QUERY_ADD_JEU="(select Jeu where Jeu.id = :jeu)";

    Joueur findByPseudo(String pseudo);
    long countByPseudo(String pseudo);

    @Query("update Joueur j set j.jeux=:jeu where j.id in :id")
    @Modifying
    @Transactional
    void addGame(@Param("id") Long id, @Param("jeu") Jeu jeu);
}

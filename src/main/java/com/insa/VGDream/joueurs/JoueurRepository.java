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
    String QUERY_ADD_JEU="update Joueur j " +
            "set j.jeux = (select Jeu where Jeu.id = :jeu)" +
            "where j.id = :id";

    Joueur findByPseudo(String pseudo);
    long countByPseudo(String pseudo);

    @Query(value = QUERY_ADD_JEU, nativeQuery = true)
    @Modifying
    @Transactional
    void addGame(@Param("jeu") Long jeu, @Param("id") Long id);

    @Query(value = "select count(jo.jeux) from Joueur jo where jo.id= :id")
    int countJeuByJoueurs(@Param("id") Long id);
}

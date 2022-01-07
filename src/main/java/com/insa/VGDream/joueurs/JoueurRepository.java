package com.insa.VGDream.joueurs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    @Query("update Joueur j set j.nom = :nom, j.pseudo = :pseudo, j.prenom = :prenom where j.id = :id")
    @Modifying
    @Transactional
    void putJoueur(@Param("nom") String nom, @Param("prenom") String prenom, @Param("pseudo") String pseudo, @Param("id") Long id);

    @Query("update Joueur j set j.password = :pwd where j.id = :id")
    @Modifying
    @Transactional
    void putPassword(@Param("pwd") String password, @Param("id") Long id);
}

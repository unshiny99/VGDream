package com.insa.VGDream.jeux;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface JeuRepository extends JpaRepository<Jeu, Long> {
    // mise à jour d'un jeu
    @Query("update Jeu j set j.nom = :nom, j.dateSortie = :dateSortie, j.categorie = :categorie, j.description = :description, j.studioDev = :studioDev where j.id = :id")
    @Modifying
    @Transactional
    void putJeu(@Param("nom") String nom, @Param("dateSortie") Date date, @Param("categorie") String categorie, @Param("description") String description, @Param("studioDev") String studioDev, @Param("id") Long id);
}

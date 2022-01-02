package com.insa.VGDream.joueurs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}

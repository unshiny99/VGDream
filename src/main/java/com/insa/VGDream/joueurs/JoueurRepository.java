package com.insa.VGDream.joueurs;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JoueurRepository extends CrudRepository<Joueur, Long> {
    Joueur findByPseudo(String pseudo);
    long countByPseudo(String pseudo);
}

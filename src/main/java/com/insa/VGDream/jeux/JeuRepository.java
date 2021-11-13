package com.insa.VGDream.jeux;

import org.springframework.data.repository.CrudRepository;

public interface JeuRepository extends CrudRepository<Jeu,Long> {
    // futures requêtes de manipulation des données
}

package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import com.insa.VGDream.jeux.JeuDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("joueurs")
public class JoueurResource {

    @Autowired
    private JoueurRepository joueurRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Joueur createJoueur(Joueur joueur){
        return joueurRepository.save(joueur);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Joueur> getJoueurs() {
        /*
        ModelMapper modelMapper = new ModelMapper();
        List<Joueur> joueurs = new ArrayList<>();
        for(Joueur joueur : joueurRepository.findAll()){
            for (Jeu jeu : joueur.getJeux()) {
                modelMapper.map(jeu,JeuDTO.class);
            }
            joueurs.add(joueur);
        }
        return joueurs;
         */
        return joueurRepository.findAll();
    }
}

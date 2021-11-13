package com.insa.VGDream.joueurs;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public Iterable<Joueur> getJoueurs(){
        return joueurRepository.findAll();
    }
}

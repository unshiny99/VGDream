package com.insa.VGDream.joueurs;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("joueurs")
public class JoueurResource {

    static Joueur joueur1 = new Joueur("massar", "Massar", "Abbas", "password");
    static ArrayList<Joueur> joueurs = new ArrayList<Joueur>(Arrays.asList(joueur1));

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
    public ArrayList<Joueur> getJoueurs(){
        return joueurs;
    }
}

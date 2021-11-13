package com.insa.VGDream.jeux;

import com.insa.VGDream.joueurs.Joueur;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Path("jeux")
public class JeuResource {
    static Jeu jeu1 = new Jeu(1,"payday","randomWare","collaborative game",new Date());
    List<Jeu> jeux = new ArrayList<>(Arrays.asList(jeu1));

    @Autowired
    private JeuRepository jeuRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Jeu createJeu(Jeu jeu){
        return jeuRepository.save(jeu);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jeu> getJeux() {
        //return jeuRepository.findAll();
        return jeux;
    }
}

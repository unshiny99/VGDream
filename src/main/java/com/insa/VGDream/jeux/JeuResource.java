package com.insa.VGDream.jeux;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Jeu> getJeux() {
        //return jeuRepository.findAll();
        return jeux;
    }
}

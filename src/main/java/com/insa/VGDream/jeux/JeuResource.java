package com.insa.VGDream.jeux;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("jeux")
public class JeuResource {

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
    public List<JeuDTO> getJeux() {
        ModelMapper modelMapper = new ModelMapper();
        List<JeuDTO> jeux = new ArrayList<>();
        for(Jeu jeu : jeuRepository.findAll()){
            JeuDTO jeuDTO = modelMapper.map(jeu,JeuDTO.class);
            jeux.add(jeuDTO);
        }
        return jeux;
    }
}

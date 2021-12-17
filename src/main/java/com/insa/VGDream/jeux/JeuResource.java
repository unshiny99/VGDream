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

    /**
     * créer un jeu pour tout le monde
     * @param jeu le jeu à créer
     * @return la nouvelle liste de jeux
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Jeu createJeu(Jeu jeu){
        return jeuRepository.save(jeu);
    }

    /**
     * obtenir la liste complète des jeux
     * @return la liste des jeux
     */
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

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public JeuDTO getJeu(@PathParam("id") Long id) {
        ModelMapper modelMapper = new ModelMapper();
        if (jeuRepository.findById(id).isPresent()) {
            Jeu jeu = jeuRepository.findById(id).get();
            return modelMapper.map(jeu,JeuDTO.class);
        }
        else {
            return null;
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void putJeu(@PathParam("id") Long id, Jeu jeu) {
        if (jeuRepository.findById(id).isPresent()) {
            jeuRepository.putJeu(jeu.getNom(),jeu.getDateSortie(),jeu.getCategorie(),jeu.getDescription(),jeu.getStudioDev(),id);
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Jeu> deleteJeu(Jeu jeu) {
        //List<JeuDTO> jeux = getJeux();
        //Jeu jeuEntity = jeuRepository.findById(jeu.getId());
        jeuRepository.delete(jeu);
        return jeuRepository.findAll();
    }

}

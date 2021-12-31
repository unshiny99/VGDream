package com.insa.VGDream.jeux;

import com.insa.VGDream.joueurs.Joueur;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashSet;
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

    /**
     * obtenir un jeu spécifique
     * @param id identifiant du jeu
     * @return le jeu concerné
     */
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

    /**
     * mettre à jour un jeu
     * @param id identifiant du jeu
     * @param jeu le jeu concerné
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void putJeu(@PathParam("id") Long id, Jeu jeu) {
        if (jeuRepository.findById(id).isPresent()) {
            jeuRepository.putJeu(jeu.getNom(),jeu.getDateSortie(),jeu.getCategorie(),jeu.getDescription(),jeu.getStudioDev(),id);
        }
    }

    /**
     * supprimer un jeu
     * @param id identifiant du jeu
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteJeu(@PathParam("id") Long id) {
        jeuRepository.deleteById(id);
    }
}

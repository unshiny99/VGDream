package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("joueurs")
public class JoueurResource {

    @Autowired
    private JoueurRepository joueurRepository;

    /**
     * inscription d'un joueur
     * @param joueur le joueur à créer
     * @return la nouvelle liste de joueurs
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Joueur createJoueur(Joueur joueur){
        return joueurRepository.save(joueur);
    }

    /**
     * obtention de la liste de tous les joueurs
     * @return la liste concernée
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<JoueurDTO> getJoueurs() {
        ModelMapper modelMapper = new ModelMapper();
        List<JoueurDTO> joueurs = new ArrayList<>();

        for(Joueur joueur : joueurRepository.findAll()){
            JoueurDTO joueurDTO = modelMapper.map(joueur,JoueurDTO.class);
            joueurs.add(joueurDTO);
        }
        return joueurs;
    }

    /**
     * ajout d'un jeu à un joueur
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addGame(@PathParam("id") Long id, Long jeu){
        if(joueurRepository.existsById(id)){
            joueurRepository.addGame(jeu,id);
        }
    }
}

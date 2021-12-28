package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import com.insa.VGDream.jeux.JeuDTO;
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

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public JoueurDTO getJoueur(@PathParam("id") Long id) {
        ModelMapper modelMapper = new ModelMapper();
        if (joueurRepository.findById(id).isPresent()) {
            Joueur joueur = joueurRepository.findById(id).get();
            return modelMapper.map(joueur,JoueurDTO.class);
        }
        else {
            return null;
        }
    }

    @GET
    @Path("{id}/nbjeux")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNBJeux(@PathParam("id") Long id) {
        return joueurRepository.countJeuByJoueurs(id);
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

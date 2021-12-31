package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import com.insa.VGDream.jeux.JeuDTO;
import com.insa.VGDream.jeux.JeuRepository;
import com.insa.VGDream.jeux.JeuResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Path("joueurs")
public class JoueurResource {

    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private JeuRepository jeuRepository;

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
     * @param id identifiant du joueur
     * @param jeu le jeu à ajouter (sans les joueurs associés)
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addJeuToJoueur(@PathParam("id") Long id, Jeu jeu){
        // NOTE : a priori la liste des joueurs est réinitialisée (voir pourquoi) => essayer d'appeler le jeuRepo ?
        if(joueurRepository.findById(id).isPresent()) {
            Joueur joueur = joueurRepository.findById(id).get();

            jeu.addJoueur(joueur);
            jeuRepository.save(jeu);

            joueur.addGame(jeu);
            joueurRepository.save(joueur);
        
        }
    }

    /**
     * obtention d'un joueur spécifique
     * @param id identifiant du joueur
     * @return le joueur concerné
     */
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
}

package com.insa.VGDream.joueurs;

import com.insa.VGDream.jeux.Jeu;
import com.insa.VGDream.jeux.JeuDTO;
import com.insa.VGDream.jeux.JeuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

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
     * @param jeuDTO le jeu à ajouter (sans les joueurs associés)
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addJeuToJoueur(@PathParam("id") Long id, JeuDTO jeuDTO){
        // NOTE : a priori la liste des joueurs est réinitialisée (voir pourquoi) => essayer d'appeler le jeuRepo ?
        boolean flag = false;
        if(joueurRepository.findById(id).isPresent()) {
            Joueur joueur = joueurRepository.findById(id).get();

            if (jeuRepository.findById(jeuDTO.getId()).isPresent()) {
                Jeu jeu = jeuRepository.findById(jeuDTO.getId()).get();

                for (Jeu jeuData : joueur.getJeux()) {
                    if (Objects.equals(jeuData.getId(), jeu.getId())) {
                        System.out.println("Jeu déjà enregistré");
                        flag = true;
                    }
                }

                if (!flag) {
                    jeu.addJoueur(joueur);
                    jeuRepository.save(jeu);

                    joueur.addGame(jeu);
                    joueurRepository.save(joueur);
                }
            }
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

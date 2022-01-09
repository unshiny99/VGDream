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
     *
     * @param joueur le joueur à créer
     * @return la nouvelle liste de joueurs
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Joueur createJoueur(Joueur joueur) {
        // check si pseudo existe déjà
        for (Joueur currentJoueur : joueurRepository.findAll()) {
            if (Objects.equals(currentJoueur.getPseudo(), joueur.getPseudo()))
                return null;
        }
        return joueurRepository.save(joueur);
    }

    /**
     * obtention de la liste de tous les joueurs
     *
     * @return la liste concernée
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<JoueurDTO> getJoueurs() {
        ModelMapper modelMapper = new ModelMapper();
        List<JoueurDTO> joueurs = new ArrayList<>();

        for (Joueur joueur : joueurRepository.findAll()) {
            JoueurDTO joueurDTO = modelMapper.map(joueur, JoueurDTO.class);
            joueurs.add(joueurDTO);
        }
        return joueurs;
    }

    @PUT
    @Path("{id}/modifJoueur")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void putJoueur(@PathParam("id") Long id, Joueur joueur) {
        int nbFound = 0;
        for (Joueur currentJoueur : joueurRepository.findAll()) {
            if (Objects.equals(currentJoueur.getPseudo(), joueur.getPseudo())) {
                // si l'id du joueur ne correspond pas à celui qu'on modifie, on détecte
                if (!Objects.equals(currentJoueur.getId(), id)) {
                    nbFound++;
                }
            }
        }
        // vérification de la condition associée
        if (joueurRepository.findById(id).isPresent() && nbFound == 0) {
            joueurRepository.putJoueur(joueur.getNom(), joueur.getPrenom(), joueur.getPseudo(),id);
        }
    }

    @PUT
    @Path("{id}/modifPwd")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void putPassword(@PathParam("id") Long id, Joueur joueur) {
        if (joueurRepository.findById(id).isPresent()) {
            joueurRepository.putPassword(joueur.getPassword(),id);
        }
    }

    /**
     * ajout d'un jeu à un joueur
     *
     * @param id     identifiant du joueur
     * @param jeuDTO le jeu à ajouter (sans les joueurs associés)
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addJeuToJoueur(@PathParam("id") Long id, JeuDTO jeuDTO) {
        // NOTE : a priori la liste des joueurs est réinitialisée (voir pourquoi) => essayer d'appeler le jeuRepo ?
        boolean flag = false;
        if (joueurRepository.findById(id).isPresent()) {
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
     * enlever d'un jeu à un joueur
     *
     * @param id     identifiant du joueur
     * @param jeuDTO le jeu à retirer (sans les joueurs associés)
     */
    @PUT
    @Path("{id}/removeGame")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void removeJeuToJoueur(@PathParam("id") Long id, JeuDTO jeuDTO) {
        if (joueurRepository.findById(id).isPresent()) {
            Joueur joueur = joueurRepository.findById(id).get();

            if (jeuRepository.findById(jeuDTO.getId()).isPresent()) {
                Jeu jeu = jeuRepository.findById(jeuDTO.getId()).get();

                jeu.getJoueurs().removeIf(joueur1 -> joueur.getId().equals(joueur1.getId()));
                jeuRepository.save(jeu);

                joueur.getJeux().removeIf(jeu1 -> jeu.getId().equals(jeu1.getId()));
                joueurRepository.save(joueur);
            }
        }
    }

    /**
     * obtention d'un joueur spécifique
     *
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
            return modelMapper.map(joueur, JoueurDTO.class);
        } else {
            return null;
        }
    }

    /**
     * permet d'obtenir la liste des jeux d'un joueur
     *
     * @param id l'identifiant du joueur concerné
     * @return les jeux d'un joueur
     */
    @GET
    @Path("{id}/jeux")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<JeuDTO> getJeux(@PathParam("id") Long id) {
        ModelMapper modelMapper = new ModelMapper();
        if (joueurRepository.findById(id).isPresent()) {
            Joueur joueur = joueurRepository.findById(id).get();
            JoueurDTO joueurDTO = modelMapper.map(joueur, JoueurDTO.class);

            return joueurDTO.getJeux();
        }
        return null;
    }

    /**
     * permet d'obtenir la liste des jeux que n'a pas un joueur
     *
     * @param id l'identifiant du joueur concerné
     * @return les jeux que le joueur ne possède pas
     */
    @GET
    @Path("{id}/non-jeux")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<JeuDTO> getNonJeux(@PathParam("id") Long id) {
        ModelMapper modelMapper = new ModelMapper();

        if (joueurRepository.findById(id).isPresent()) {
            Joueur joueur = joueurRepository.findById(id).get();
            JoueurDTO joueurDTO = modelMapper.map(joueur, JoueurDTO.class);

            Collection<Jeu> jeux = jeuRepository.findAll();
            Collection<JeuDTO> jeuxPossedes = joueurDTO.getJeux();

            Collection<JeuDTO> jeuxNonPossedes = new HashSet<>();
            for (Jeu jeu : jeux) {
                JeuDTO jeuDTO = modelMapper.map(jeu, JeuDTO.class);
                boolean found = false;

                for (JeuDTO jeuPossede : jeuxPossedes) {
                    if (Objects.equals(jeuPossede.getId(), jeu.getId())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    jeuxNonPossedes.add(jeuDTO);
                }
            }
            return jeuxNonPossedes;
        }
        return null;
    }

    /**
     * supprimer un jeu
     * @param id identifiant du jeu
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteJoueur(@PathParam("id") Long id) {
        
        joueurRepository.deleteById(id);
    }
}

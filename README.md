# VGDream - Video Games Dream

## Développement
* La technologie utilisée pour la partie serveur est **Spring**
* Les technologies pour l'interface cliente sont **JQuery**, ainsi que **Bootstrap 5**

## Préambule
* Nous avons décidé de réaliser une application de gestion de collection de jeux vidéos.

* Le joueur pourra **créer un jeu** si ce dernier n'existe pas encore dans le système, ou en **mettre un à jour** (si ses informations sont incorrectes).

* La **liste complète des jeux** sera affichée sur l'accueil de notre application.

* Un joueur pourra **s'inscrire** sur notre plateforme, **mettre à jour ses informations** personnelles, et même **supprimer son compte** s'il le souhaite.
* Une **liste de tous les joueurs** sera affichée à titre statistique.
* On pourra alors retrouver les détails d'un joueur ainsi que sa collection personnelle de jeux

## Utilisation
### Ne pas oublier d'activer *hsqldb* sur la version locale !
Pour cela, lancer les commandes suivantes :
Dans un premier terminal, lancer le serveur :
- ```cd hsqldb/lib```
- ```java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 VGDreamDB```

Puis, dans un second terminal, réaliser la connection :
- ```cd hsqldb/lib```
- ```java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing```
- Dans la fenêtre graphique, remplacer le champ URL par : `jdbc:hsqldb:hsql://localhost/VGDreamDB`

### Lancer l'application
Pour des soucis de compatibilité, nous avons changé le port par défaut, qui est désormais le 8090.

Après avoir lancé l'application via l'IDE, l'application web sera disponible via le lien suivant :
http://localhost:8090

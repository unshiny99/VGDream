# VGDream
## Video Games Dream

##Développement
* NOTE : pour les fonctions de création, voir si on retourne l'élément ou bien la nouvelle liste 

## Préambule
* Nous avons décidé de réaliser une application de gestion de collection de jeux vidéos.

* Cette application permettra à un joueur **d'ajouter des jeux** à sa collection personnelle, ou bien **d'en enlever**.
* Il pourra également **créer un jeu** si ce dernier n'existe pas encore dans le système, ou en **mettre un à jour** (si ses informations sont incorrectes).

* La **liste complète des jeux** sera affichée sur l'accueil de notre application.

* Un joueur pourra **s'inscrire** sur notre plateforme, **mettre à jour ses informations** personnelles, et même **supprimer son compte** s'il le souhaite.
* Une liste de tous les joueurs pourra être affichée à titre indicatif et statistique.

## Utilisation
### Ne pas oublier d'activer hsqldb sur la version locale !
Pour cela, lancer les commandes suivantes :
- ```cd hsqldb/lib```
- ```java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 VGDreamDB```

Puis, dans un second terminal :
- ```cd hsqldb/lib```
- ```java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing```
- Dans la fenêtre graphique, remplacer le champ URL par : `jdbc:hsqldb:hsql://localhost/VGDreamDB`

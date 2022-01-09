# VGDream - Video Games Dream

## Technologies de développement
* La technologie utilisée pour la partie serveur est **Spring**
* Les technologies pour l'interface cliente sont **JQuery**, ainsi que **Bootstrap 5**

Pré-requis : `jdk-17`

## Préambule
Nous avons décidé de réaliser une application de gestion de collection de jeux vidéos.

* Le joueur pourra **créer un jeu** si ce dernier n'existe pas encore dans le système, ou en **mettre un à jour** si besoin. Il aura également la possibilité d'en **supprimer** un.

* La **liste complète des jeux** sera affichée sur l'accueil de notre application. On pourra **consulter leurs détails**.

* Un joueur pourra **s'inscrire** sur notre plateforme, **mettre à jour ses informations** personnelles, et même **supprimer son compte** s'il le souhaite.
* Une **liste de tous les joueurs** sera affichée à titre indicatif.
* On pourra alors retrouver les **détails d'un joueur** ainsi que sa **collection personnelle de jeux**.
* Enfin, on pourra **ajouter un jeu à la collection** d'un joueur, ou bien en **retirer de sa collection**.

## Utilisation de l'application
### Etape 1 : Ne pas oublier d'activer *hsqldb* sur la version locale !
Pour cela, lancer les commandes suivantes :
Dans un premier terminal, lancer le serveur :
- ```cd hsqldb/lib```
- ```java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 VGDreamDB```

**Remarque :** Si vous souhaitez visualiser et/ou gérer les changements en base de données, dans un second terminal, lancer l'exécutable suivant :
- ```cd hsqldb/lib```
- ```java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing```
- Dans la fenêtre graphique, remplacer le champ URL par : `jdbc:hsqldb:hsql://localhost/VGDreamDB`

### Etape 2 : Lancer l'exécution du programme
Dans un dernier terminal, à la racine du projet, lancez les commandes suivantes :
- ```mvn clean install```
- ```mvn spring-boot:run```

Pour des soucis de compatibilité, nous avons changé le port par défaut, qui est désormais le 8090.

Après avoir lancé l'application en ligne de commande ou via votre IDE, l'application web sera accessible à partir l'URL suivant :
[localhost:8090](http://localhost:8090)

**Remarques :** 
- D'une manière générale, pensez à rafraîchir la page en cas de problème, afin de voir si votre changement a bien été effectué.
- Nous avons implémenté un jeu de test basé sur **JUnit4** pour les entités Jeu et Joueur. Vous pouvez réaliser ce test en utilisant `mvn test` à la racine du projet.
- Si pour une quelconque raison, la base de données constatée s'affichait vide, vous pouvez utiliser le fichier d'insertion `backup.sql` qui se trouve à la racine du projet.

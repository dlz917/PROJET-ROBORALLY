# PROJET ROBORALLY

PROJET S4 JAVA

Objectif : 
-Coder le jeu Roborally. 
-Interface graphique. 
-Fonctionnalite en ligne.

Regles du jeu : 
Inventaire : 
Carte Programme 

A programmer : 
plateau du jeu : puits, murs, cases drapeaux, lasers, case Clef, case Clef&marteau
robot : attributs -> nbr de vies, position, nbr de pions degats
carte de programme : vitesse, actions
programme du robot : choix des 5 cartes par le joueur
elements du plateau : tapis roulant, lasers, repoussoirs, engrenages


Points obligatoires : 
Sockets et serveur 
utiliser methode MVC
Serializer les objets a envoyer entre sockets
utiliser git

Règles du jeu Roborally
Cartes équipement : retire 1 Pion dégât 
Cartes Programme :
x18 avance de 1
x12 avance de 2
x6 avance de 3
x6 recule de 1
x18 tourne à droite
x18 tourne à gauche
x6 demi tour

Déroulement du jeu
Placement des robots sur le plateau

Distribution de 9 cartes Programme par joueur : 
Choix de 5 cartes à jouer dans un certain ordre (une fois le choix fait, pas de retour en arrière possible)

Déclaration des joueurs Hors Tension :
Mise Hors Tension : quand le robot est endommagé, possibilité de ne pas jouer le tour suivant -> -1 pion dégât 
Remarques : robot quand même touché par les actions présentes sur le plateau 
             un joueur peut enchaîner les mises HT
             le joueur garde ses cartes Programme pour le tour suivant

Exécution des programmes des joueurs : 
Les cartes Programme sont exécutées de la vitesse la + grande à la + faible
Si un robot entre en collision avec un autre : il le pousse d’une case 
Exception : si il y a un mur : les 2 robots ne bougent pas

Exécution des éléments du plateau : 
Tapis roulants express : avance d’une case 
Tapis roulants express et normaux : avancent d’une case
Repoussoirs poussent s’ils sont actifs
Engrenages pivotent de 90°
Remarque : tous les robots sont déplacés en même temps, si il y a risque de collision, les robots restent à leur place

Actions à prendre en compte une fois les robots arrivés à leur place finale 
Lasers du plateau : -1 pion dégât pour le robot touché, le laser ne peut pas traverser un mur ou un robot
Lasers des robots : en direction de la ligne de vue du robot, même conséquence que lasers du plateau
Enregistrement des robots ayant atteint un drapeau : position du robot est archivée s’ils sont détruits ils reviendront à la position de leur dernier enregistrement
Si le robot se trouve sur une case Clef : -1 pion dégât
Si le robot se trouve sur une case Clef & Marteau : -1 pion dégät ; + 1 carte
Équipement

Les robots détruits sont remis en jeu avec 2 pions dégâts dès le départ
Répétition des actions 2 à 7 jusqu’à ce qu’un robot ait atteint tous les drapeaux dans l’ordre
Conséquences des pions dégâts : 
1 pion dégât : on distribue 8 cartes Programmes au joueur
2 pions dégât : on distribue 7 cartes Programmes au joueur
3 pions dégât : on distribue 6 cartes Programmes au joueur
4 pions dégât : on distribue 5 cartes Programmes au joueur
5 pions dégât : on distribue 4 cartes Programmes au joueur, la carte Programme en 5ème position est verrouillée
6 pions dégât : on distribue 3 cartes Programmes au joueur, les carte Programme en 4ème et 5ème position sont verrouillées
7 pions dégât : on distribue 2 cartes Programmes au joueur, les carte Programme en 3ème, 4ème et 5ème position sont verrouillées
8 pions dégât : on distribue 1 cartes Programmes au joueur, les carte Programme en 2ème, 3ème, 4ème et 5ème position sont verrouillées
9 pions dégât : on ne distribue pas de carte Programmes, toutes les cartes Programme sont verrouillées
10 pions dégât : destruction du robot

3 possibilités pour détruire un robot : 
Le robot a 10 pions dégât
Le robot est tombé dans un puit
Le robot est tombé du plateau

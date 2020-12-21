# Projet scolaire
    Ce projet est une conception logicielle scolaire.
# Assemblago
    Jeu d'assemblage.
# Targets ANT
    Targets ant possible : 
        ant clean : Clean le projet. 
        ant makedir : Créer les répertoires utile. 
        ant compile : Compile 
        ant docs : Génére la javadoc 
        ant jar : Génére le fichier view.jar 
        ant main :  Compile / créer la jar / créer la doc.
        ant run : Execute le fichier view.jar
# Compiler avec ANT :
    ant compile puis ant jar, ou ant main
# Execution :
    Vue : ant run ou possible d'exécuter sur le view.jar dans dist/jar.
# En ligne de commande :
    Modèle :
    javac -d "build/classes" src/model/*.java
    java -cp "build/classes" src.model.Main
    
    Vue :
    javac -cp "dist/lib/json-simple-1.1.1.jar;" -d "build/classes" src/view/*.java
    java -cp "build/classes;dist/lib/json-simple-1.1.1.jar;" src.view.Main
    
    Tests :
    javac -cp "dist/lib/junit-4.13.1.jar;." -d "test/resources" test/java/src/model/piece/PieceTest.java test/java/src/model/jeu/PlateauTest.java test/java/src/model/ia/IaTest.java
    java -cp "test/resources;dist/lib/junit-4.13.1.jar;dist/lib/hamcrest-core-1.3.jar;." org.junit.runner.JUnitCore src.model.piece.PieceTest src.model.jeu.PlateauTest src.model.ia.IaTest
----------------------------------------------------------------
# Partie Modèle :
    Le modèle est jouable, grace aux commandes rotate move ou finish. 
    Lorsque l'on vous demande de jouer une pièce : écrivez une des valeurs définies pour une pièce (ex : 2).

    Paramètres des commandes en détail:
    move : valeur de la pièce, coord x, coord y
    rotate : valeur de la pièce, horaire ou antihoraire
    finish : pour terminer votre partie et obtenir votre score.
-------------------------------------------------------------
# Partie Vue et Contrôleur:
    On clic sur une pièce pour la sélectionner et on la déplace avec les flèches directionnelles.
    Rotations avec - et +.
    Entrée pour voir votre score actuel.
    Touche n pour définir un nom.

    Pour sauvegarder une partie de préférence, veuillez paramétrer un nom avant avec la touche n et précisez bien le format .json à la fin de votre fichier.
-------------------------------------------------------------------------
# Etudiants
    SAHIN Tolga 21801808
    MERIL Emmanuel Miangouila 21810784
    ZHANDOS Urazov 21801012
    SCHOEBELA Patryk 22012136
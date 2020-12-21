package src.model.parser;

import src.model.jeu.Plateau;
import src.model.jeu.PlateauRandomFactory;
import src.model.parser.json.ParserJson;
import src.model.parser.json.SaveGameJson;
import src.model.piece.Piece;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        /*
        Plateau plateau = PlateauRandomFactory.generateRandomPlateau(10,10,5);
        //save.writeFile("plateau.json", plateau);
        Score score = new Score(plateau);
        SaveScoreJson saveScore = new SaveScoreJson("Toto", score);
        saveScore.writeFile("score.json");
        */

        /*
        Plateau plateau = PlateauRandomFactory.generateRandomPlateau(20,20,10);
        System.out.println(plateau);
        for (Piece p : plateau.getPieces()) {
            System.out.println("FORME : " + p.getForme() + " HAUTEUR : " + p.getHauteur() + " LARGEUR : " + p.getLargeur() + " ORIENTATION  :" + p.getOrientation() + " POSITION X : " + p.getPosition()[0] + " POSITION Y : " + p.getPosition()[1]);
        }
        File file = new File("ll.json");
        SaveGameJson.writeFile(file, plateau);
        ParserJson.parse(file);

         */
        /*
        Plateau plateau2 = ParserJson.parse(file);
        System.out.println(plateau2);

        for (Piece p : plateau2.getPieces()) {
            System.out.println("FORME : " + p.getForme() + " HAUTEUR : " + p.getHauteur() + " LARGEUR : " + p.getLargeur() + " ORIENTATION  :" + p.getOrientation() + " POSITION X : " + p.getPosition()[0] + " POSITION Y : " + p.getPosition()[1]);
        }
         */

    }
}

package src.model;

import src.model.action.Move;
import src.model.action.Rotate;
import src.model.jeu.Plateau;
import src.model.jeu.PlateauRandomFactory;
import src.model.piece.Piece;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Game {

    public void Play(int action) {
        Plateau plateau = PlateauRandomFactory.generateRandomPlateau(20, 20, 10);
        HashMap<Integer, Piece> map = new LinkedHashMap<>();

        label:
        for (int i = 0; i < action; i++) {
            System.out.println("Action numéro " + (i + 1) + " Il vous en reste : " + (action - i - 1));
            System.out.println(plateau);
            int j = 0;
            for (Piece p : plateau.getPieces()) {
                // On lie une valeur intégrale comme clé à une pièce.
                map.put(j, p);
                System.out.println("| Pièce " + j + " forme : " + p.getForme() + " position (" + p.getPosition()[0] + "," + p.getPosition()[1] + ") |");
                j += 1;
            }
            // On demande si la personne veut move ou rotate.
            System.out.println("Move ou rotate ? Ou finish si vous avez terminer");
            Scanner sc = new Scanner(System.in); // On récupère la réponse.
            String answer = sc.nextLine();
            // En fonction de la réponse on générera une action move, rotation ou finish.
            switch (answer) {
                case "move": {
                    System.out.println("Quelle pièce ? (écrivez sa valeur)");
                    Scanner sc2 = new Scanner(System.in);
                    String piece = sc2.nextLine();
                    // Cas où la pièce n'est pas définie.
                    if (Integer.parseInt(piece) > map.size() || Integer.parseInt(piece) < 0) {
                        System.out.println("Faites attention à utiliser une pièce existante.");
                        continue;
                    }
                    // On demande à quelle cordonnée x la déplacer.
                    System.out.println("Cordonnée x");
                    Scanner sc3 = new Scanner(System.in);
                    String x = sc3.nextLine();
                    // On demande à quelle cordonnée y la déplacer.
                    System.out.println("Cordonnée y");
                    Scanner sc4 = new Scanner(System.in);
                    String y = sc4.nextLine();
                    // On effectue le mouvement.
                    Move move = new Move(Integer.parseInt(x), Integer.parseInt(y), map.get(Integer.parseInt(piece)));
                    plateau.move(move);

                    break;
                } // Même logique pour rotation.
                case "rotate": {
                    System.out.println("Quelle pièce (écrivez sa valeur)?");
                    Scanner sc5 = new Scanner(System.in);
                    String piece = sc5.nextLine();

                    if (Integer.parseInt(piece) > map.size() || Integer.parseInt(piece) < 0) {
                        System.out.println("Faites attention à utiliser une pièce existante.");
                        continue;
                    }
                    // On demande le sens de rotation.
                    System.out.println("Quel sens ? (horaire ou antihoraire)");
                    Scanner sc6 = new Scanner(System.in);
                    String sens = sc6.nextLine();

                    Rotate rotation = new Rotate(map.get(Integer.parseInt(piece)), sens);
                    plateau.rotate(rotation);
                    break;
                } // Si c'est fini on break le label.
                case "finish":
                    break label;
                default: // Par défaut, on break une action car ce serait une commande inconnue.
                    System.out.println("Commande inconnue");
                    break;
            }
        }
        // On affiche le dernier plateau et le score.
        System.out.println(plateau);
        System.out.println("Jeu terminé !");
        System.out.println("Votre score est : " + plateau.isFinished());
    }
}

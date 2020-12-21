package src.model.ia;

import src.model.action.*;
import src.model.jeu.*;
import src.model.piece.*;

import java.util.ArrayList;
import java.util.Collections;

public class IaBruteForce implements IaStrategy {

    private final Plateau plateau;
    private ArrayList<Piece>  piecesList;

    public IaBruteForce(Plateau plateau) {
        this.plateau = plateau;
        // Passage en liste, on veut travailler sur des données avec un index fixé.
        this.piecesList = new ArrayList<>(plateau.getPieces());
    }

    // Le but de cet algorithme est de déplacer les pièces triés (une par une tant que celle-ci peut bouger), d'une manière la plus optimale vers (0,0).
    @Override
    public Plateau solve() {
        ArrayList<Piece> sortedPiecesList = sortPieces();

        for (Piece p : sortedPiecesList) {
            boolean hasMove = true;
            // On part sur une logique de déplacer en (posX -1, posY -1) continuellement une pièce tant que celle-ci peut bouger.
            // Afin d'optimiser au maximum cette logique, tous les if correspondent à des cas particuliers où l'on pourrait éventuellement encore bouger la pièce.
            while (hasMove) {
                // (0,y) -> (0, y - 1)
                if (p.getPosition()[0] == 0 && p.getPosition()[1] != 0) {
                    hasMove = plateau.move(new Move(0,p.getPosition()[1] - 1,p));
                }
                // (x,0) -> (x - 1, 0)
                else if (p.getPosition()[1] == 0 && p.getPosition()[0] != 0) {
                    hasMove = plateau.move(new Move(p.getPosition()[0] - 1,0,p));
                }
                // (0,0) -> on stop
                else if (p.getPosition()[0] == 0 && p.getPosition()[1] == 0) {
                    hasMove = false;
                }
                else {
                    // cas général, (x - 1, y - 1)
                    hasMove = plateau.move(new Move(p.getPosition()[0] - 1,p.getPosition()[1] - 1,p));
                    // Si faux, on vérifie si on peut rendre le mouvement possible en (x - 1) ou (y - 1).
                    if (hasMove == false) {
                        hasMove = plateau.move(new Move(p.getPosition()[0],p.getPosition()[1] - 1,p));
                    }
                    if (hasMove == false) {
                        hasMove = plateau.move(new Move(p.getPosition()[0] - 1,p.getPosition()[1],p));
                    }
                }
            }
        }
        return plateau;
    }
    // On transforme les positions int[] en int grace à la somme de celle-ci.
    public ArrayList<Integer> makePositions() {
        ArrayList<Integer> positionsList = new ArrayList<Integer>();
        for (Piece p : piecesList) {
            positionsList.add(p.getPosition()[0] + p.getPosition()[1]);
        }
        return positionsList;
    }

    /*
    On trie les pièces grâce à l'index minimum de la somme des positions.
    (Vu que l'on a des ArrayList, une index dans la liste de pièce correspond à celle dans la liste de positions).
    Ainsi, on trie et renvoie une liste de pièces triés en fonction de la position.
     */
    public ArrayList<Piece> sortPieces() {
        ArrayList<Piece> sortedPiecesList = new ArrayList<Piece>();
        ArrayList<Integer> positionsList = makePositions();
        for (int i = 0; i < positionsList.size(); i++) {
            // Ca recupère l'index minimum (si 2 index sont égales, ca renverra le premier index).
            int minIndex = positionsList.indexOf(Collections.min(positionsList));
            positionsList.set(minIndex, 1000); // L'index minimum est déjà récuperer, afin de continuer les prochaines comparaisons on maximise cette valeur.
            sortedPiecesList.add(piecesList.get(minIndex)); // On ajoute la pièce correspondant à cet index.
        }
        return sortedPiecesList;
    }

    /* Autres recherches.

    public Plateau solve() {
        Score initScore = new Score(plateau);
        int scoreValue = initScore.evaluation();
        int newScore = 1000;
        while (newScore > scoreValue - 50) {
            ArrayList<Move> movesList = allPossibleMoves();
            for (int i = 0; i < piecesList.size(); i++) {
                plateau.move(movesList.get(i));
            }
            Score score = new Score(plateau);
            newScore = score.evaluation();
        }
        return plateau;
    }

    public ArrayList<Move> allPossibleMoves() {
        ArrayList<Move> movesList = new ArrayList<Move>();
        int j = 1;
        for (int i = 0; i < piecesList.size(); i++) {
            Move move = new Move(piecesList.get(i).getPosition()[0] - j, piecesList.get(i).getPosition()[1] - j, piecesList.get(i));
            movesList.add(move);
            }
        return movesList;
    }
     */

    /*
    // On réalise les moves et retourne le nouvel état.
    public Plateau solve() {
        Score score = new Score(plateau);
        int scoreValue = score.evaluation();
        while (scoreValue >= plateau.isFinished()) {
            ArrayList<Move> possibleMoves = makePossibleMoves();
            for (int i = 0; i < possibleMoves.size(); i++) {
                plateau.move(possibleMoves.get(i));
            }
        }
        return plateau;
    }

     */

    /*

    // Move à la distance - hauteur de la pièce 2, et move à la distance - largeur de la pièce 2.
    public ArrayList<Move> makePossibleMoves() {
        ArrayList<Double> listeDistances = nearestPieces();
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        for (int i = 0; i < piecesList.size(); i++) {
            if (piece)
            Move move = new Move( listeDistances.get(i).intValue(), listeDistances.get(i).intValue(), piecesList.get(i));
            possibleMoves.add(move);
        }
        return possibleMoves;
    }

     */

    /*
    // Calcul d'une distance entre une pièce et une autre.
    public static double distance(Piece p1, Piece p2) {
        int x1 = p1.getPosition()[0];
        int y1 = p1.getPosition()[1];
        int x2 = p2.getPosition()[0];
        int y2 = p2.getPosition()[1];
        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);
        return Math.sqrt(x + y);
    }

    // Distance la plus petite entre une pièce et les autres pièces. (heuristic)
    public ArrayList<Double> nearestPieces() {
        ArrayList<Double> distances = new ArrayList<Double>();
        for (int i = 1; i < piecesList.size(); i++) {
            System.out.println(piecesList.get(0).getForme() + "," + piecesList.get(0).getPosition()[0] + "," + piecesList.get(0).getPosition()[1]);
            double dist = distance(piecesList.get(0), piecesList.get(i));
            distances.add(dist);
            System.out.println("|||||||" + piecesList.get(i).getForme() + "," + piecesList.get(i).getPosition()[0] + "," + piecesList.get(i).getPosition()[1]);
        }
        return distances;
    }
     */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.jeu;

import src.model.piece.Piece;
import src.model.piece.PieceRandomFactory;

import java.util.Random;

/**
 * @author tolga
 */
public abstract class PlateauRandomFactory {
    // On construit un plateau aléatoire.
    public static Plateau generateRandomPlateau(int nbLigne, int nbColonne, int nbPiece) {
        Plateau plateau = new Plateau(nbLigne, nbColonne);
        Random random = new Random();
        for (int i = 0; i < nbPiece; i++) {
            Piece p = PieceRandomFactory.generateRandomPiece();
            int randX = random.nextInt(nbLigne - p.getHauteur());
            int randY = random.nextInt(nbColonne - p.getLargeur());
            p.setPosition(randX, randY);
            plateau.ajoutePiece(p);
        }
        return plateau;
    }
}

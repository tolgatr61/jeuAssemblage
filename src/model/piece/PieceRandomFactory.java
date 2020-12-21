/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.piece;

import java.util.Random;

/**
 * @author tolga
 */
public abstract class PieceRandomFactory {

    public static Piece generateRandomPiece() {
        // Taille minimum 3 et maximum 5. On génére une pièce aléatoire.
        char[] formes = new char[]{'a', 'c', 'f', 'h', 'i', 'l', 'o', 't', 'u', 'z'};
        Random random = new Random();
        int hauteur = random.nextInt(5 - 3) + 3;
        int largeur = random.nextInt(5 - 3) + 3;
        int rand = random.nextInt(formes.length);
        int ori = random.nextInt(3);

        return PieceFactory.createPiece(hauteur, largeur, ori, formes[rand]);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.piece.pieceType;

import src.model.piece.Case;
import src.model.piece.PieceImplement;

/**
 * @author tolga
 */
public class PieceA extends PieceImplement {

    // On construit les pièces en étendant PieceImplement.
    public PieceA(int hauteur, int largeur) {
        super(hauteur, largeur);

        for (int i = 0; i < hauteur; i++) {
            this.cases.add(new Case(i, 0, this));
            this.cases.add(new Case(i, largeur - 1, this));
        }
        for (int j = 0; j < largeur; j++) {
            this.cases.add(new Case(0, j, this));
            this.cases.add(new Case((int)hauteur / 2, j, this));
        }
    }
    // On override, la forme de la pièce.
    @Override
    public char getForme() {
        return 'a';
    }
}

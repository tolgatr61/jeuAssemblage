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
public class PieceI extends PieceImplement {

    public PieceI(int hauteur, int largeur) {
        super(hauteur, largeur);

        for (int i = 0; i < hauteur; i++) {
            this.cases.add(new Case(i, (int)largeur / 2, this));
        }
        for (int j = 0; j < largeur; j++) {
            this.cases.add(new Case(hauteur - 1, j, this));
            this.cases.add(new Case(0, j, this));
        }
    }

    @Override
    public char getForme() {
        return 'i';
    }
}

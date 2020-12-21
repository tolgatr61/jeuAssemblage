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
public class PieceF extends PieceImplement {

    public PieceF(int hauteur, int largeur) {
        super(hauteur, largeur);

        for (int i = 0; i < hauteur; i++) {
            this.cases.add(new Case(i, 0, this));
        }
        for (int j = 0; j < largeur; j++) {
            this.cases.add(new Case(0, j, this));
            this.cases.add(new Case((int)hauteur / 2, j, this));
        }
    }

    @Override
    public char getForme() {
        return 'f';
    }
}

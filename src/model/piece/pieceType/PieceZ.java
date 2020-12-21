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
public class PieceZ extends PieceImplement {

    public PieceZ(int hauteur, int largeur) {
        super(hauteur, largeur);
        int moitieLargeur = (int) largeur / 2;

        for (int i = 0; i < hauteur; i++) {
            this.cases.add(new Case(i, moitieLargeur, this));
        }
        for (int j = 0; j < moitieLargeur; j++) {
            this.cases.add(new Case(0, j, this));
        }
        for (int i = moitieLargeur; i < largeur; i++) {
            this.cases.add(new Case(hauteur - 1, i, this));
        }
    }


    @Override
    public char getForme() {
        return 'z';
    }
}

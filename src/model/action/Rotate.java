/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.action;

import src.model.piece.Piece;

/**
 * @author tolga
 */
public class Rotate implements Action {

    private final Piece p;
    private final String sens;
    // Structure d'une rotation.
    public Rotate(Piece p, String sens) {
        this.p = p;
        this.sens = sens;
    }

    @Override
    public Piece getPiece() {
        return this.p;
    }

    public String getSens() {
        return this.sens;
    }
}

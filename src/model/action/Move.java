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
public class Move implements Action {

    private final int x;
    private final int y;
    private final Piece p;
    // Structure d'un Move.
    public Move(int x, int y, Piece p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Piece getPiece() {
        return p;
    }


}

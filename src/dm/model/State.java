/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm.model;

import dm.model.c.Case;

/**
 *
 * @author Tolga
 */
public class State {
    
    private Grille grille;
    
    public State(Grille grille) {
        this.grille = grille;
    }
    
    public void play(Move move) {
        if (move.getPiece().getForme() == 'l') {
            this.grille.getGrille()[move.getPiece().getX()][move.getPiece().getY()] = new Case(move.getPiece().getX(),move.getPiece().getY());
            this.grille.getGrille()[move.getX()][move.getY()] = move.getPiece();
        }
    }
    
}

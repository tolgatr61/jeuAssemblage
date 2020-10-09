/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm;

import dm.model.Grille;
import dm.model.Move;
import dm.model.State;
import dm.model.c.Piece;

/**
 *
 * @author 21801808
 */
public class DM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grille grille = new Grille(15,15);
        Piece p = new Piece(1,1,'l');                      
        
        
        grille.addPiece(p);
        grille.afficheGrille();
        System.out.println("--------------------");
        State s = new State(grille);
        Move m = new Move(p,1,5);
        s.play(m);
        grille.afficheGrille();
    }
    
}

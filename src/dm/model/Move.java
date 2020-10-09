/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm.model;
import dm.model.c.Piece;

/**
 *
 * @author Tolga
 */
public class Move {
    
    private Piece piece;
    private Integer x;
    private Integer y;
    
    public Move(Piece p, Integer x, Integer y) {
        this.piece = p;
        this.x = x;
        this.y = y;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
    
    public Integer getX() {
        return this.x;
    }
    
    public Integer getY() {
        return this.y;
    }
}

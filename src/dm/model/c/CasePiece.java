/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm.model.c;

/**
 *
 * @author Tolga 21801808
 */
public class CasePiece extends Case {
    
    private Integer x;
    private Integer y;
    private Piece p;
    private char forme;
    
    public CasePiece(Integer x, Integer y, Piece p) {
        super(x,y, p.getForme());
        this.p = p;
    }
    
    @Override
    public boolean collision() {
        return true;
    }
    
    @Override
    public boolean isPiece() {
        return true;
    }
    
    @Override
    public Piece getPiece() {
        return this.p;
    }
    
}

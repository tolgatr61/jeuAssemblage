/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm.model.c;

/**
 *
 * @author 21801808
 */
public class Case {
    
    private Integer x;
    private Integer y;
    private char forme;
    
    public Case(Integer x, Integer y, char forme) {
        this.x = x;
        this.y = y;
        this.forme = forme;
    }
    
    public Case(Integer x, Integer y) {
        this(x,y,'.');
    }

    public char getForme() {
        return this.forme;
    }
    
    public Integer getX() {
        return this.x;
    }
    
    public Integer getY() {
        return this.y;
    }
    
    public boolean collision() {
        return false;
    }
}

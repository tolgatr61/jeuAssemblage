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
public class Mur extends Case {
    
    private Integer x;
    private Integer y;
    private char forme;
    
    public Mur(Integer x, Integer y, char forme) {
        super(x,y,forme);
    }
    
    @Override
    public boolean collision() {
        return true;
    }
}

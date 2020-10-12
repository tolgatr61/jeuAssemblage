/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm.model;

import dm.model.c.*;

/**
 *
 * @author 21801808
 */
public class Grille {
    
    private Case[][] grille;
    private Integer x;
    private Integer y;
    
    public Grille(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.grille = this.createGrille();
        this.setMurs();
    }
    
    public Case[][] createGrille() {
        Case[][] grid = new Case[this.x][this.y];
        for (int i = 0; i < this.getX(); i++) {
            for (int j = 0; j< this.getY(); j++) {
                grid[i][j] = new Case(i,j);
            }
        }
        return grid;
    }
    
    public void afficheGrille() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                System.out.print("|" + this.grille[i][j].getForme());
            }
        System.out.println("|");
        }
    }

    public void addPiece(Piece p) {
        for (Case shape : p.getShape()) {
            System.out.println(shape.getX() + "," + shape.getY() + "," + p.getX() + "," + p.getY());
            this.grille[p.getX() + shape.getX()][p.getY() + shape.getY()] = shape;
        }
    }
    
    public void removePiece(Piece p) {
        for (Case shape : p.getShape()) {
            //System.out.println(shape.getX() + "," + shape.getY() + "," + p.getX() + "," + p.getY());
            this.grille[p.getX() + shape.getX()][p.getY() + shape.getY()] = new Case(p.getX() + shape.getX(), p.getY() + shape.getY());
        }
    }
    
    public void applyRotation(Piece p) {
        removePiece(p);
        p.rotation();
        addPiece(p);
    }
    
    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    public void setMurs() {
        for (int i = 0; i < this.getY(); i++) {
            this.grille[0][i] = new Mur(0,i,'x');
            this.grille[this.getX() - 1][i] = new Mur(0,i,'x');
        }
        for (int j = 1; j < this.getX() - 1; j++) {
            this.grille[j][0] = new Mur(j,0,'x');
            this.grille[j][this.getY()- 1] = new Mur(j,this.getY() - 1,'x');
        }
    }
    
    public Case[][] getGrille() {
        return this.grille;
    }
}

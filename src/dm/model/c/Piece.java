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
public class Piece {
    
    private Integer x;
    private Integer y;
    private char forme;
    private Case[][] ensembleFormes;
    private Case[] shape;
    private Integer rotationValue;
    
    public Piece(Integer x, Integer y, char forme) {
        this.x = x;
        this.y = y;
        this.forme = forme;
        this.ensembleFormes = setCases();
        this.shape = setCase();
        this.rotationValue = 0;
    }

    //TODO créer une dépendance entre this() et Case. (il faudra sans doute qu'une pièce soit indépendant d'une Case et que les coordonnées d'une pièce
    // soit eux une Case identifié à une pièce ou non (si mur). (que l'on pourra mettre en paramètre).
    public Case[][] setCases() {
        Case[][] tempCases = new Case[][] {
            {new CasePiece(0,0, this), new CasePiece(0,1, this), new CasePiece(0,2, this), new CasePiece(0,3, this)}, // L
            {new CasePiece(0,0, this), new CasePiece(0,1, this), new CasePiece(0,2, this), new CasePiece(1,1, this)}, // T
            {new CasePiece(0,0, this), new CasePiece(1,0, this), new CasePiece(0,1, this), new CasePiece(1,1, this)}, // Carré
            {new CasePiece(0,0, this), new CasePiece(0,1, this), new CasePiece(0,2, this), new CasePiece(0,3, this), new CasePiece(0,4, this)}, // L allongé
            {new CasePiece(0,0, this), new CasePiece(0,1, this), new CasePiece(0,2, this), new CasePiece(1,1, this), new CasePiece(1,2, this)} // T sous forme de F
        };
        return tempCases;
    }
    
    public Case[] setCase() {
        switch (this.getForme()) {
            case 'l':
                return this.ensembleFormes[0];
            case 't':
                return this.ensembleFormes[1];
            case 'c':
                return this.ensembleFormes[2];
            case 'n':
                return this.ensembleFormes[3];
            case 'v':
                return this.ensembleFormes[4];
        }
        return null;
    }
    
    public Case[][] getEnsembleFormes() {
        return this.ensembleFormes;
    }
    
    public Case[] getShape() {
        return this.shape;
    }
    
    public Integer getX() {
        return this.x;
    }
    
    public Integer getY() {
        return this.y;
    }

    public char getForme() {
        return this.forme;
    }
    
    public Integer getRotationValue() {
        return this.rotationValue;
    }
    
    public void rotation() {
        // (x,y) to (y,-x)
        int i = 0;
        for (Case c : this.getShape()) {
            this.getShape()[i] = new CasePiece(c.getY()*-1, c.getX(), this);
            i+=1;
            }
        }
    
}

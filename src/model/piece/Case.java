/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.piece;

/**
 * @author tolga
 */
public class Case {

    private int x;
    private int y;
    private final char forme;
    private final Piece pieceType;

    // Constructeur d'une case vide. (lié à aucun type de pièce)
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.pieceType = null;
        this.forme = '.';
    }

    // Constructeur d'une classe pleine. (lié à un type de pièce)
    public Case(int x, int y, Piece p) {
        this.x = x;
        this.y = y;
        this.pieceType = p;
        this.forme = p.getForme();
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getForme() {
        return this.forme;
    }

    public Piece getPieceType() {
        return this.pieceType;
    }

    public boolean collision() {
        return pieceType != null;
    }

}

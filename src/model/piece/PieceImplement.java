/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.piece;

import java.util.HashSet;

/**
 * @author tolga
 */
public abstract class PieceImplement implements Piece {

    protected HashSet<Case> cases;
    private int hauteur;
    private int largeur;
    private int[] position;
    private int orientation;

    public PieceImplement(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.position = new int[]{0, 0};
        this.cases = new HashSet<Case>();
        this.orientation = 0;
    }

    @Override
    public char getForme() {
        return '.';
    }

    @Override
    public HashSet<Case> getCases() {
        return this.cases;
    }

    @Override
    public boolean estOccupee(int x, int y) {
        for (Case c : this.cases) {
            if (c.getX() + position[0] == x && c.getY() + position[0] == y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setPosition(int x, int y) {
        this.position = new int[]{x, y};
    }
    @Override
    public int[] getPosition() { return this.position; }

    // Rotation horaire, Nos cases sont définies en (0,0) donc on on va procéder à une inversion de cordonnées X en fonction de Y,
    // et de Y en fonction de la hauteur - X - 1.
    @Override
    public void rotationHoraire() {
        int tmp;
        for (Case c : this.cases) {
            int tmpX = c.getX();
            c.setX(c.getY());
            c.setY(this.hauteur - tmpX - 1);
        }
        // On inverse les dimensions.
        tmp = this.hauteur;
        this.hauteur = largeur;
        this.largeur = tmp;

        // On incrémente l'orientation de 0 à 3.
        if (this.orientation == 3) {
            this.orientation = 0;
        } else this.orientation += 1;
    }

    // Idem pour antihoraire, mais avec une logique inverse et on définit X en fonction de la largeur - Y - 1.
    @Override
    public void rotationAntiHoraire() {
        int tmp;
        for (Case c : this.cases) {
            int tmpY = c.getY();
            c.setY(c.getX());
            c.setX(this.largeur - tmpY - 1);

        }
        // On inverse les dimensions.
        tmp = this.hauteur;
        this.hauteur = largeur;
        this.largeur = tmp;
        // On décremente l'orientation de 0 à 3.
        if (this.orientation == 0) {
            this.orientation = 3;
        } else this.orientation -= 1;
    }

    @Override
    public void affichePiece() {
        Case[][] grille = new Case[hauteur][largeur];
        // Init une grille de cases vide.
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grille[i][j] = new Case(i, j);
            }
        }
        // On y écrase les cases remplies.
        for (Case c : this.cases) {
            grille[c.getX()][c.getY()] = c;
        }
        // On affiche
        for (int i = 0; i < hauteur; i++) {
            System.out.print("|");
            for (int j = 0; j < largeur; j++) {
                System.out.print(grille[i][j].getForme());
            }
            System.out.println("|");
        }

    }
    @Override
    public int getHauteur() {
        return hauteur;
    }
    @Override
    public int getLargeur() {
        return largeur;
    }
    @Override
    public int getOrientation() {
        return orientation;
    }

}

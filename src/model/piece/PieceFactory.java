/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.piece;

import src.model.piece.pieceType.*;

/**
 * @author tolga
 */
public abstract class PieceFactory {

    public static Piece createPiece(int hauteur, int largeur, int ori, char forme) {
        // Dans le cas où une orientation impaire est définie, on inverse bien la largeur et la hauteur.
        // Vu que l'on va récuperer la rotation de la pièce. (à partir d'une orientation de départ à 0)
        if (ori == 1 || ori == 3) {
            int tmpLargeur = largeur;
            largeur = hauteur;
            hauteur = largeur;
        }
        // En fonction de la forme on retourne une instance de p, et la rotationne si une orientation est définie.
        switch (forme) {
            case 'a':
                Piece p = new PieceA(hauteur, largeur);
                makeRotate(p, ori);
                return p;
            case 'c':
                Piece p2 = new PieceC(hauteur, largeur);
                makeRotate(p2, ori);
                return p2;
            case 'f':
                Piece p3 = new PieceF(hauteur, largeur);
                makeRotate(p3, ori);
                return p3;
            case 'h':
                Piece p4 = new PieceH(hauteur, largeur);
                makeRotate(p4, ori);
                return p4;
            case 'i':
                Piece p5 = new PieceI(hauteur, largeur);
                makeRotate(p5, ori);
                return p5;
            case 'l':
                Piece p6 = new PieceL(hauteur, largeur);
                makeRotate(p6, ori);
                return p6;
            case 'o':
                Piece p7 = new PieceO(hauteur, largeur);
                makeRotate(p7, ori);
                return p7;
            case 't':
                Piece p8 = new PieceT(hauteur, largeur);
                makeRotate(p8, ori);
                return p8;
            case 'u':
                Piece p9 = new PieceU(hauteur, largeur);
                makeRotate(p9, ori);
                return p9;
            case 'z':
                Piece p10 = new PieceZ(hauteur, largeur);
                makeRotate(p10, ori);
                return p10;
            default:
                return null;
        }
    }

    // Méthode pour faire rotate la pièce (ori fois).
    public static void makeRotate(Piece p, int ori) {
        for (int i = 0; i < ori; i++) {
            p.rotationHoraire();
        }
    }

}

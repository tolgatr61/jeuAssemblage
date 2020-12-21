/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.jeu;

/**
 *
 * @author tolga
 */

import src.model.action.Move;
import src.model.action.Rotate;
import src.model.jeu.listeners.AbstractModeleEcoutable;
import src.model.piece.Case;
import src.model.piece.Piece;

import java.util.ArrayList;
import java.util.HashSet;

public class Plateau extends AbstractModeleEcoutable {
    
    private HashSet<Piece> plateau;
    private int nbLigne;
    private int nbColonne;

    private String playerName;
    
    public Plateau(int nbLigne, int nbColonne) {
        plateau = new HashSet<Piece>();
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        this.ecouteurs= new ArrayList<>();
        this.playerName = "";
    }
    
    public void ajoutePiece(Piece p) {
        if (!checkCollision(p) && !checkPosition(p)) {
            plateau.add(p);
        }
    }
    
    public void removePiece(Piece p) {
        plateau.remove(p);
    }

    // Move en fonction de la classe Move et de ses données.
    public boolean move(Move move) {
        Piece p = move.getPiece();
        boolean hasMove = true;
        int[] firstPositions = p.getPosition();
        if (plateau.contains(p)) {
            plateau.remove(p);
            if (move.getX() <= (getNL() - p.getHauteur()) && move.getY() <= (getNC() - p.getLargeur())) p.setPosition(move.getX(), move.getY());
		}
		this.ajoutePiece(p); // La méthode ajoutePiece ajoutera la pièce dans l'ensemble uniquement si elle vérifie les collisions.
        // Sinon on remet à l'état initial.
        if (!plateau.contains(p)) {
            hasMove = false;
            p.setPosition(firstPositions[0], firstPositions[1]);
            this.ajoutePiece(p);
        }
        fireChangement();
        return hasMove;
    }
    
    public boolean rotate(Rotate rotation) {
        Piece p = rotation.getPiece();
        boolean hasRotate = true;
        // Cas d'une rotation horaire. On supprime et ajoute la pièce orienter si elle ne collisione pas. Sinon on la remet à son état initiale.
        if (rotation.getSens().equals("horaire")) {
            if (plateau.contains(p)) {
                plateau.remove(p);
            }
            p.rotationHoraire();
            this.ajoutePiece(p);

            if (!plateau.contains(p)) {
                p.rotationAntiHoraire();
                this.ajoutePiece(p);
                hasRotate = false;
            }
        } // idem mais dans le sens inverse pour antihoraire.
        else if (rotation.getSens().equals("antihoraire")) {
            if (plateau.contains(p)) {
                plateau.remove(p);
            }
            p.rotationAntiHoraire();
            this.ajoutePiece(p);

            if (!plateau.contains(p)) {
                p.rotationHoraire();
                this.ajoutePiece(p);
                hasRotate = false;
            }
        }
		fireChangement();
        return hasRotate;
    }
    
    public boolean checkCollision(Piece piece) {
        
        // Pour chaque case de la Pièce on vérifie si pour chaque cases des pièces du plateau.
        // Si les cases ont une quelconques cordonnées identiques.
        for (Case c : piece.getCases()) {
            int posX = c.getX() + piece.getPosition()[0];
            int posY = c.getY() + piece.getPosition()[1];
            for (Piece p : plateau) {
                for (Case c2 : p.getCases()) {
                    int posXb = c2.getX() + p.getPosition()[0];
                    int posYb = c2.getY() + p.getPosition()[1];
                    if (posXb == posX && posYb == posY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean checkPosition(Piece piece) {
        // On vérifie qu'une case de la pièce ne dépasse pas la grille.
        for (Case c : piece.getCases()) {
            int posX = c.getX() + piece.getPosition()[0];
            int posY = c.getY() + piece.getPosition()[1];
            if (posX > nbLigne || posX < 0 || posY > nbColonne || posY < 0) {
                return true;
            }
        }
        return false;
    }

    // Cas d'un jeu terminer, on retourne le score du plateau.
    public int isFinished() {
        Score score = new Score(this);
        return score.evaluation();
    }
    
    @Override
    public String toString() {
        String str = "";
        Case[][] grille = new Case[nbLigne][nbColonne];
        // init d'une Grille
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                grille[i][j] = new Case(i,j);
            }
        }
        // Placement des Cases remplis de nos pièces.

        for (Piece p : plateau) {
            for (Case c : p.getCases()) {
                int posX = c.getX() + p.getPosition()[0];
                int posY = c.getY() + p.getPosition()[1];
                grille[posX][posY] = c;
            }
        }
        // Affichage en fonction de la forme des pièces.
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                str += "|" + grille[i][j].getForme() + "|";
            }
            str += "\n";
        }
        return str;
    }
    
    public HashSet<Piece> getPieces() {
        return plateau;
    }
    
    public int getNL() {
        return nbLigne;
    }
    
    public int getNC() {
        return nbColonne;
    }

    public void ensembleAlea() {
        this.plateau = PlateauRandomFactory.generateRandomPlateau(getNL(), getNC(), 10).getPieces();
        fireChangement();
    }

    public void setPieces(HashSet<Piece> listePieces) {
        this.plateau = listePieces;
        fireChangement();
    }

    public void loadPlateau(HashSet<Piece> listePieces, int nbLigne, int nbColonne) {
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        this.plateau = listePieces;
        fireChangement();
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        fireChangement();
    }

    public String getPlayerName() {
        return this.playerName;
    }
}

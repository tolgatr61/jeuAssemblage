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
public interface Piece {
    // Position d'un pièce dans le plateau.
    int[] getPosition();
    // Hauteur d'une pièce.
    int getHauteur();
    // Largeur d'une pièce.
    int getLargeur();
    // Setter de la position d'une pièce dans le plateau.
    void setPosition(int x, int y);
    // Forme d'une pièce.
    char getForme();
    // Méthode pour réaliser une rotation anti horaire.
    void rotationAntiHoraire();
    // Méthode pour réaliser une rotation horaire.
    void rotationHoraire();
    // Méthode pour récuperer les cases de la pièce.
    HashSet<Case> getCases();
    // Méthode pour afficher uen pièce.
    void affichePiece();
    // Getter de l'orientation.
    int getOrientation();
    // Vérifier si une cordonnée de la pièce est occupée.
    boolean estOccupee(int x, int y);
}

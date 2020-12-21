package src.model.action;

import src.model.piece.Piece;

public interface Action {

    // Une action doit obligatoirement au moins permettre de get une pièce.
    public Piece getPiece();

}

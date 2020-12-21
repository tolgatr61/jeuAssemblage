package src.model.parser.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import src.model.jeu.Plateau;
import src.model.parser.ParserStrategy;
import src.model.piece.Piece;
import src.model.piece.PieceFactory;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ParserJson implements ParserStrategy {

    @SuppressWarnings("unchecked")
    public Plateau parse(File fileName) {
        JSONParser parser = new JSONParser();
        try {
            // On parse le fichier.
            Object obj = parser.parse(new FileReader(fileName));
            // On le cast en type JSONObject.
            JSONObject jsonObject = (JSONObject) obj;
            // Les valeurs sont typés en JSONObject, on peut les convertir en long, puis les cast en (int).
            long ligne = (long) jsonObject.get("Ligne");
            int ligne2 = Math.toIntExact(ligne);

            long colonne = (long) jsonObject.get("Colonne");
            int colonne2 = Math.toIntExact(colonne);

            long nbPieces = (long) jsonObject.get("nbPieces");
            int nbPieces2 = Math.toIntExact(nbPieces);

            long score = (long) jsonObject.get("Score");
            int score2 = Math.toIntExact(score);

            String playerName = (String) jsonObject.get("Player");

            HashSet<Piece> ensemblePieces = new HashSet<Piece>();
            // Pour toutes les pièces sauvegarder dans le JSON chaque (avec comme clé Piece0, Piece1, Piece2, etc ...)
            // On recupère les données, puis initialise la pièce et l'insère dans l'ensemble de pièces.
            for (int i = 0; i < nbPieces2; i++) {
                Object str = jsonObject.get("Piece" + String.valueOf(i));
                JSONObject json = (JSONObject) str;

                long hauteur = (long) json.get("Hauteur");
                int hauteur2 = (int) hauteur;

                long largeur = (long) json.get("Largeur");
                int largeur2 = (int) largeur;

                long orientation = (long) json.get("Orientation");
                int ori = (int) orientation;

                long posa = (long) json.get("X");
                int posX = (int) posa;

                long posb = (long) json.get("Y");
                int posY = (int) posb;

                String forme = (String) json.get("Forme");
                char forme2 = forme.charAt(0);

                Piece p = PieceFactory.createPiece(hauteur2, largeur2, ori, forme2);
                p.setPosition(posX, posY);
                ensemblePieces.add(p);

            }
            // On initialise le plateau, et set les pièces et le nom du joueur sauvegarder.
            Plateau plateau = new Plateau(ligne2, colonne2);
            plateau.setPieces(ensemblePieces);
            plateau.setPlayerName(playerName);
            return plateau;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

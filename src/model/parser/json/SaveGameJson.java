package src.model.parser.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import src.model.parser.SaveStrategy;
import src.model.piece.Piece;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import src.model.jeu.Plateau;

public class SaveGameJson implements SaveStrategy {

    private File fileName;
    private static FileWriter file;
    private Plateau plateau;

    public SaveGameJson(File fileName, Plateau plateau) {
        this.fileName = fileName;
        this.plateau = plateau;
    }

    @SuppressWarnings("unchecked")
    public void writeFile() {

        // JSONObject container
        JSONObject pl = new JSONObject();
        // JSONObject sous container
        JSONObject obj = new JSONObject();
        // On écrit les lignes et colonnes.
        obj.put("Ligne", plateau.getNL());
        obj.put("Colonne", plateau.getNC());

        /* Puis vu que JSON n'est pas forcément ordonnée, on réalise un LinkedHashMap() dans lequel on y
         met tout ce dont on a besoin pour recréer une pièce, et on définit une clé de type Piece + String.valueOf(i)
         afin que l'on puisse récuperer assez facilement toutes les clés de Pièce lors du parsing.
         */
        int i = 0;
        for (Piece p : plateau.getPieces()) {
            Map ordonateElements = new LinkedHashMap();
            ordonateElements.put("Forme", String.valueOf(p.getForme()));
            ordonateElements.put("Hauteur", p.getHauteur());
            ordonateElements.put("Largeur", p.getLargeur());
            ordonateElements.put("Orientation", p.getOrientation());
            ordonateElements.put("X", p.getPosition()[0]);
            ordonateElements.put("Y", p.getPosition()[1]);
            JSONObject json = new JSONObject(ordonateElements);
            obj.put("Piece" + String.valueOf(i), json);
            i+=1;
        }
        // On écrit le score, le joueur, et le nombre de Pièces.
        obj.put("Score", plateau.isFinished());
        obj.put("Player", plateau.getPlayerName());
        obj.put("nbPieces", i);
        // On met le tout dans le premier container.
        pl.put("Plateau", obj);

        // Puis, on écrit le fichier.
        try {

            file = new FileWriter(fileName);
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

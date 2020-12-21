package src.model.parser.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import src.model.jeu.Score;
import src.model.parser.SaveStrategy;
import src.model.piece.Piece;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SaveScoreJson implements SaveStrategy {

    private String name;
    private Score score;
    private File fileName;
    private static FileWriter file;

    public SaveScoreJson(String name, Score score, File fileName) {
        this.name = name;
        this.score = score;
        this.fileName = fileName;
    }

    @SuppressWarnings("unchecked")
    public void writeFile() {
        JSONObject obj = new JSONObject();
        obj.put("Name", name);
        obj.put("Score", score.evaluation());

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

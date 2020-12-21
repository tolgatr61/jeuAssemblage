package src.model.parser;

import src.model.jeu.Plateau;

import java.io.File;

// classe Context (pour le pattern Strategy)
public class ParserContext {

    private ParserStrategy parser;

    public ParserContext(ParserStrategy parser){
        this.parser = parser;
    }

    public Plateau executeStrategy(File fileName){
        return parser.parse(fileName);
    }
}



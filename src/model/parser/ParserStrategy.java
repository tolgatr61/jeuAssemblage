package src.model.parser;

import src.model.jeu.Plateau;

import java.io.File;

public interface ParserStrategy {
    public Plateau parse(File fileName); // parser du fichier.
}

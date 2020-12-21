package src.controller;

import javax.swing.filechooser.FileFilter;
import java.io.*;

class JsonFilter extends FileFilter {

    // Filtre des types de fichiers pour n'accepter que le type JSON.
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');

        if (i > 0 && i < fileName.length() - 1) {
            if (fileName.substring(i + 1).toLowerCase().equals("json")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getDescription() {
        return ".json (Json format)";
    }
}


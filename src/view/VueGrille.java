package src.view;

import src.model.action.Move;
import src.model.action.Rotate;
import src.model.jeu.Plateau;
import src.model.jeu.Score;
import src.model.jeu.listeners.EcouteurModele;
import src.model.piece.Case;
import src.model.piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VueGrille extends JPanel implements EcouteurModele, KeyListener {
    private Plateau plateau;
    private Piece activePiece;
    private final Vue vue;

    public VueGrille(Plateau jeu, Vue vue) {
        this.plateau = jeu;
        this.plateau.ajoutEcouteur(this);
        this.activePiece = null;
        this.vue = vue;
        setLayout(new GridLayout(plateau.getNL(), plateau.getNC(), 1, 1));
        setup();
        setVisible(true);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    public Piece getActivePiece() {
        return this.activePiece;
    }

    public void setActivePiece(Piece p) {
        this.activePiece = p;
    }

    // Méthode pour faire rotate la pièce active.
    public void makeRotation(char sens) {
        if (activePiece != null && plateau.getPieces().contains(activePiece)) {
            if (sens != '-' && sens != '+') return;
            String rotation = "horaire";
            if (sens == '+') rotation = "horaire";
            else if (sens == '-') rotation = "antihoraire";
            this.plateau.rotate(new Rotate(this.activePiece, rotation));
        }
    }

    // Méthode pour faire move la pièce active avec les flèches directionnelles.
    public void makeMove(String direction) {
        if (activePiece != null && plateau.getPieces().contains(activePiece)) {
            int x = activePiece.getPosition()[0];
            int y = activePiece.getPosition()[1];
            switch (direction) {
                case "up":
                    this.plateau.move(new Move(x - 1, y, activePiece));
                    break;
                case "right":
                    this.plateau.move(new Move(x, y + 1, activePiece));
                    break;
                case "down":
                    this.plateau.move(new Move(x + 1, y, activePiece));
                    break;
                case "left":
                    this.plateau.move(new Move(x, y - 1, activePiece));
                    break;
                default:
                    return;
            }
        }
    }

    public void modeleMisAJour(Object source) {
        this.repaint();
        for (Component c : this.getComponents()) {
            this.remove(c);
        }
        this.setup();
        this.revalidate();
    }

    // Construction de la grille.
    public void setup() {
        System.out.println(this.plateau);
        for (Piece p : this.plateau.getPieces()) {
            System.out.println("Pièce " + p.getForme() + " : " + p.getPosition()[0] + ", " + p.getPosition()[1] + " ori : " + p.getOrientation());
        }

        int nbLigne = this.plateau.getNL();
        int nbColonne = this.plateau.getNC();
        Case[][] grille = new Case[nbLigne][nbColonne];
        // init d'une Grille
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                grille[i][j] = new Case(i, j);
            }
        }
        // placement des Cases remplis de nos pièces.

        for (Piece p : this.plateau.getPieces()) {
            for (Case c : p.getCases()) {
                int posX = c.getX() + p.getPosition()[0];
                int posY = c.getY() + p.getPosition()[1];
                grille[posX][posY] = c;
            }
        }

        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                this.add(new CasePan(grille[i][j], this));
            }
        }
    }


    // Evenements de touches du clavier.
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == '+') {
            makeRotation('+');
        }
        if (e.getKeyChar() == '-') {
            makeRotation('-');
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            makeMove("up");
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            makeMove("right");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            makeMove("down");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            makeMove("left");
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Score score = new Score(this.plateau);
            JOptionPane.showMessageDialog(null, "Votre score actuel : " + score.evaluation(), "SCORE ACTUEL", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getKeyChar() == 'n') {
            String resp = "Votre nom";
            String name = JOptionPane.showInputDialog(null, resp);
            plateau.setPlayerName(name);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.vue.setVisible(false);
            this.vue.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

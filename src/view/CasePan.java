package src.view;

import src.model.piece.Case;
import src.model.piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CasePan extends JPanel implements MouseListener {
    public static final int WIDTH = 30;
    private final Case subject;
    private final VueGrille vueGrille;

    public CasePan(Case subject, VueGrille vueGrille) {
        super();
        this.subject = subject;
        this.vueGrille = vueGrille;
        setPreferredSize(new Dimension(WIDTH,WIDTH));
        addMouseListener(this);
    }

    // Dessin d'une case.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        char forme = this.subject.getForme();
        if (forme == '.') {
            g.setColor(Color.black);
        } else {
            if (forme == 'a')
                g.setColor(Color.blue);
            else if (forme == 'c')
                g.setColor(Color.cyan);
            else if (forme == 'f')
                g.setColor(Color.gray);
            else if (forme == 'h')
                g.setColor(Color.green);
            else if (forme == 'i')
                g.setColor(Color.magenta);
            else if (forme == 'l')
                g.setColor(Color.orange);
            else if (forme == 'o')
                g.setColor(Color.pink);
            else if (forme == 't')
                g.setColor(Color.red);
            else if (forme == 'u')
                g.setColor(Color.white);
            else if (forme == 'z')
                g.setColor(Color.yellow);
        }
        g.fillRect(0, 0, WIDTH, WIDTH);
    }

    // On rend la pièce de la case cliqué, comme la pièce active.
    @Override
    public void mouseClicked(MouseEvent e) {
        Piece p = this.subject.getPieceType();
		this.vueGrille.setActivePiece(p);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}

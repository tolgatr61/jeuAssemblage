package src.model.ia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.model.jeu.Plateau;
import src.model.jeu.PlateauRandomFactory;
import src.model.piece.Piece;

import static org.junit.Assert.*;

public class TestIa {

    private Ia ia;

    @Before
    public void setIa() throws Exception {
        ia = new Ia(new IaBruteForce(PlateauRandomFactory.generateRandomPlateau(20,20,5)));
    }

    @Test
    public void testSolveBruteForce() {
        Plateau plateau = ia.executeStrategy();
        assertNotNull(plateau);
    }


}
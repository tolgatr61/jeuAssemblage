package src.model.jeu;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.model.action.Move;
import src.model.action.Rotate;
import src.model.piece.Piece;

import java.util.HashSet;

import static org.junit.Assert.*;

public class TestPlateau {

    private Plateau plateau;

    @Before
    public void setPlateau() throws Exception {
        this.plateau = PlateauRandomFactory.generateRandomPlateau(30,30,2);
    }


    @Test
    public void testMove() {
        Piece p0 = plateau.getPieces().iterator().next();
        Move move = new Move(3,2, p0);
        if (plateau.move(move))
            assertEquals(p0.getPosition()[0], 3);
            assertEquals(p0.getPosition()[1], 2);
    }

    @Test
    public void testCollidedMove() {
        Piece p0 = plateau.getPieces().iterator().next();
        Move move = new Move(-1,2, p0);
        assertFalse(plateau.move(move));
    }

    @Test
    public void testRotate() {
        Piece p0 = plateau.getPieces().iterator().next();
        int initOri = p0.getOrientation();
        Rotate rotation = new Rotate(p0, "horaire");
        if (plateau.rotate(rotation))
            assertEquals(p0.getOrientation(), initOri + 1);
    }

    @Test
    public void testScore() {
        Score score = new Score(plateau);
        assertEquals(plateau.isFinished(), score.evaluation());
    }

    @Test
    public void testPlayerName() {
        plateau.setPlayerName("toto");
        assertEquals(plateau.getPlayerName(), "toto");
    }
}
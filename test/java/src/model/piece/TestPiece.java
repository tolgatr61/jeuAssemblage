package src.model.piece;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPiece {

    private Piece piece;

    @Before
    public void setPieceTest() throws Exception {
        this.piece = PieceFactory.createPiece(4, 4, 0, 'f');
    }

    @Test
    public void testPiecePosition() {
        int positionX = 2;
        int positionY = 3;
        piece.setPosition(positionX, positionY);
        assertEquals(piece.getPosition()[0], positionX);
        assertEquals(piece.getPosition()[1], positionY);
    }

    @Test
    public void testRotationHorairePiece() {
        piece.rotationHoraire(); // si 3 on oriente à 0
        assertEquals(piece.getOrientation(), 1);
    }

    @Test
    public void testRotationAntiHorairePiece() {
        piece.rotationAntiHoraire(); // si 0 alors on oriente à 3
        assertEquals(piece.getOrientation(), 3);
    }

    @Test
    public void testEstOccupee() {
        assertEquals(piece.estOccupee(0,0), true);
    }
}
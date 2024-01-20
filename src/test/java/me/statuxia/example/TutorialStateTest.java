package me.statuxia.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TutorialStateTest extends Assertions {

    @Test
    public void testStateWithOnlyPrimitive() throws IllegalAccessException {
        TutorialState tutorialState = new TutorialState();
        assertEquals(tutorialState.getJoin(), 1);
        assertEquals(tutorialState.getMenu(), 2);
        assertEquals(tutorialState.getProfile(), 4);
        assertEquals(tutorialState.getStatistics(), 8);
        assertNull(tutorialState.getSettings());
    }

    @Test
    public void testStateWithNonOnlyPrimitive() throws IllegalAccessException {
        TutorialState tutorialState = new TutorialState(false);
        assertEquals(tutorialState.getJoin(), 1);
        assertEquals(tutorialState.getMenu(), 2);
        assertEquals(tutorialState.getProfile(), 4);
        assertEquals(tutorialState.getStatistics(), 8);
        assertEquals(tutorialState.getSettings(), 16);
    }

    @Test
    public void testStateWithOnlyPrimitiveAndStartPos() throws IllegalAccessException {
        TutorialState tutorialState = new TutorialState(2);
        assertEquals(tutorialState.getJoin(), 2);
        assertEquals(tutorialState.getMenu(), 4);
        assertEquals(tutorialState.getProfile(), 8);
        assertEquals(tutorialState.getStatistics(), 16);
        assertNull(tutorialState.getSettings());
    }

    @Test
    public void testStateWithNonOnlyPrimitiveAndStartPos() throws IllegalAccessException {
        TutorialState tutorialState = new TutorialState(2, false);
        assertEquals(tutorialState.getJoin(), 2);
        assertEquals(tutorialState.getMenu(), 4);
        assertEquals(tutorialState.getProfile(), 8);
        assertEquals(tutorialState.getStatistics(), 16);
        assertEquals(tutorialState.getSettings(), 32);
    }
}

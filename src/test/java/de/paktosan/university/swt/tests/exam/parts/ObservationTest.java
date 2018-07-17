package de.paktosan.university.swt.tests.exam.parts;

import de.paktosan.university.swt.exam.parts.Observation;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObservationTest {
    @Test
    public void testInterface(){
        assertTrue(Observation.class.isInterface());
    }
}
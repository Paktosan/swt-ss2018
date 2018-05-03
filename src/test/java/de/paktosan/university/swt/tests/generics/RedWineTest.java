package de.paktosan.university.swt.tests.generics;

import de.paktosan.university.swt.generics.RedWine;
import de.paktosan.university.swt.generics.Wine;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedWineTest {
    @Test
    public void testExtendsDrink() {
        assertTrue("The class RedWine should extend Wine!", RedWine.class.getSuperclass().equals(Wine.class));
    }

    @Test
    public void testGetRegion() {
        RedWine rw = new RedWine("Dresden");
        assertEquals("RedWine.getRegion() should return the correct region!", "Dresden", rw.getRegion());
    }
}
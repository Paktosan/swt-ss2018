package de.paktosan.university.swt.tests.generics;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import de.paktosan.university.swt.generics.Drink;
import org.junit.Test;

public class DrinkTest {
    @Test
    public void testDrinkAbstract() {
        assertTrue("The class Drink should be an abstract class!", Modifier.isAbstract(Drink.class.getModifiers()));
        assertTrue("The class Drink should be an abstract class, not an interface!", !Drink.class.isInterface());
    }
}

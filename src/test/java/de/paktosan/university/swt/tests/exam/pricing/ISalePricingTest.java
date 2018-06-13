package de.paktosan.university.swt.tests.exam.pricing;

import de.paktosan.university.swt.exam.pricing.ISalePricing;
import org.junit.Test;

import static org.junit.Assert.*;

public class ISalePricingTest {
    @Test
    public void testInterface() {
        assertTrue(ISalePricing.class.isInterface());
    }
}
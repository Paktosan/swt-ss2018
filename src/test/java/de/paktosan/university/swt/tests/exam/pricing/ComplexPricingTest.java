package de.paktosan.university.swt.tests.exam.pricing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import de.paktosan.university.swt.exam.pricing.*;
import org.junit.Before;
import org.junit.Test;

public class ComplexPricingTest {
    private Sale testSale;
    private ISalePricing p1, p2, p3, p4, p5;

    @Before
    public void setUp() {
        p1 = new PercentageDiscountPricing(10.0); // 9000
        p2 = new PercentageDiscountPricing(5.0); // 9500
        p3 = new AbsoluteDiscountPricing(500, 5000); // 9500
        p4 = new AbsoluteDiscountPricing(3000, 9000); // 9000
        p5 = new AbsoluteDiscountPricing(1900, 8000); // 8100

        testSale = new Sale(10000, p1);
    }

    @Test
    public void testAbstract() {
        assertTrue("The class ComplexPricing should be abstract!",
                Modifier.isAbstract(ComplexPricing.class.getModifiers()));
    }

    @Test
    public void testBestForCustomerPricingConstructorNullArgument() {
        try {
            new BestForCustomerPricing(null);
            fail("BestForCustomerPricing.BestForCustomerPricing() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testBestForCustomerPricingAdd() {
        List<ISalePricing> solution = new LinkedList<ISalePricing>();
        solution.add(p1);
        ComplexPricing cPricing = new BestForCustomerPricing(p1);
        assertEquals("BestForCustomerPricing.BestForCustomerPricing() should add the argument to the pricings!",
                solution, cPricing.getPricings());
        cPricing.add(p2);
        solution.add(p2);
        assertEquals("BestForCustomerPricing.add() should add the argument to the pricings!", solution,
                cPricing.getPricings());
        cPricing.add(p3);
        solution.add(p3);
        assertEquals("BestForCustomerPricing.add() should add the argument to the pricings!", solution,
                cPricing.getPricings());
    }

    @Test
    public void testBestForCustomerPricingGetTotalNullArgument() {
        try {
            BestForCustomerPricing p = new BestForCustomerPricing(p1);
            p.getTotal(null);
            fail("BestForCustomerPricing.getTotal() should throw a NullPointerEception if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testBestForCustomerPricingGetTotal() {
        BestForCustomerPricing p = new BestForCustomerPricing(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        testSale.setPricing(p);
        assertEquals("BestForCustomerPricing.getTotal() should return the correct total price!", 8100,
                testSale.getTotal());
    }

    @Test
    public void testBestForStorePricingConstructorNullArgument() {
        try {
            new BestForStorePricing(null);
            fail("BestForStorePricing.BestForStorePricing() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testBestForStorePricingAdd() {
        List<ISalePricing> solution = new LinkedList<ISalePricing>();
        solution.add(p1);
        ComplexPricing cPricing = new BestForStorePricing(p1);
        assertEquals("BestForStorePricing.BestForStorePricing() should add the argument to the pricings!", solution,
                cPricing.getPricings());
        cPricing.add(p2);
        solution.add(p2);
        assertEquals("BestForStorePricing.add() should add the argument to the pricings!", solution,
                cPricing.getPricings());
        cPricing.add(p3);
        solution.add(p3);
        assertEquals("BestForStorePricing.add() should add the argument to the pricings!", solution,
                cPricing.getPricings());
    }

    @Test
    public void testBestForStorePricingGetTotalNullArgument() {
        try {
            BestForStorePricing p = new BestForStorePricing(p1);
            p.getTotal(null);
            fail("BestForStorePricing.getTotal() should throw a NullPointerEception if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testBestForStorePricingGetTotal() {
        BestForStorePricing p = new BestForStorePricing(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        testSale.setPricing(p);
        assertEquals("BestForStorePricing.getTotal() should return the correct total price!", 9500,
                testSale.getTotal());
    }

}

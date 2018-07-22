package de.paktosan.university.swt.tests.exam.payroll;

import de.paktosan.university.swt.exam.payroll.PayrollDB;
import org.junit.Test;

import static org.junit.Assert.*;

public class PayrollDBTest {
    @Test
    public void testInterface() {
        assertTrue(PayrollDB.class.isInterface());
    }
}
package de.paktosan.university.swt.tests.exam.projects;

import de.paktosan.university.swt.exam.projects.IProject;
import org.junit.Test;

import static org.junit.Assert.*;

public class IProjectTest {
    @Test
    public void testInterface() {
        assertTrue(IProject.class.isInterface());
    }
}
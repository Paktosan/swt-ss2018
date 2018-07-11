package de.paktosan.university.swt.tests.garage;

import static org.junit.Assert.assertTrue;

import de.paktosan.university.swt.garage.GarageDoor;
import de.paktosan.university.swt.tests.garage.DoorStateBaseTest;
import org.junit.Test;

public class StatePatternTest extends DoorStateBaseTest {
    private String methodOpenDoor = "openDoor";
    private String methodCloseDoor = "closeDoor";
    private String methodStopper = "stopper";

    @Test
    public void testDoorStateOpenDoor() {
        assertTrue("DoorState should have a method named " + methodOpenDoor + " without any parameters!",
                searchForMethod("DoorState", methodOpenDoor));
    }

    @Test
    public void testDoorStateCloseDoor() {
        assertTrue("DoorState should have a method named " + methodCloseDoor + " without any parameters!",
                searchForMethod("DoorState", methodCloseDoor));
    }

    @Test
    public void testDoorStateStopper() {
        assertTrue("DoorState should have a method named " + methodStopper + " without any parameters!",
                searchForMethod("DoorState", methodStopper));
    }

    private boolean searchForMethod(String name, String method) {
        for (Class<?> c : GarageDoor.class.getDeclaredClasses()) {
            if (c.getSimpleName().equals(name)) {
                try {
                    c.getMethod(method);
                    return true;
                } catch (NoSuchMethodException ex) {
                    return false;
                }
            }
        }
        return false;
    }
}

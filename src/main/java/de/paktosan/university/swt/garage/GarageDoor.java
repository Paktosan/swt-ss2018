package de.paktosan.university.swt.garage;

public class GarageDoor {
    private DoorState currentState;
    private Motor motor;

    public GarageDoor() {
        currentState = new Closed();
        motor = new Motor();
    }

    public void openDoor() {
        currentState.openDoor();
        currentState = new Opening();
    }

    public void stopper() {
        currentState.stopper();
        if (currentState instanceof Opening) {
            currentState = new Open();
        } else if (currentState instanceof Closing) {
            currentState = new Closed();
        }
    }

    public void closeDoor() {
        currentState.closeDoor();
        currentState = new Closing();
    }

    public Motor getMotor() {
        return motor;
    }

    private void setState(DoorState ds) {
        currentState = ds;
    }

    abstract class DoorState {
        public void openDoor() {
        }

        public void closeDoor() {
        }

        public void stopper() {
        }
    }

    class Closed extends DoorState {
        @Override
        public void closeDoor() {
            throw new IllegalStateException("A closed door can't be closed!");
        }

        @Override
        public void stopper() {
            throw new IllegalStateException("Door is not moving!");
        }
    }

    class Opening extends DoorState {
        @Override
        public void openDoor() {
            throw new IllegalStateException("Door is already opening!");
        }
    }

    class Open extends DoorState {
        @Override
        public void openDoor() {
            throw new IllegalStateException("A open door can't be opened!");
        }

        @Override
        public void stopper() {
            throw new IllegalStateException("Door is not moving!");
        }
    }

    class Closing extends DoorState {
        @Override
        public void closeDoor() {
            throw new IllegalStateException("Door is already closing!");
        }
    }

}

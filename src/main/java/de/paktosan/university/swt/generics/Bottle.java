package de.paktosan.university.swt.generics;

public class Bottle<T extends Drink> {
    private T content;

    public boolean isEmpty() {
        return content == null;
    }

    public void fill(T content) {
        if (this.content != null) {
            throw new IllegalStateException("You cant fill a full bottle!");
        } else {
            this.content = content;
        }
    }

    public T empty() {
        if (content == null) {
            throw new IllegalStateException("You cant empty a empty bottle!");
        } else {
            T content = this.content;
            this.content = null;
            return content;
        }
    }
}

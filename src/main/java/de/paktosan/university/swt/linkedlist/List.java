package de.paktosan.university.swt.linkedlist;


public class List {
    private ListElement firstElement;

    public List() {
        this.firstElement = null;
    }

    public void append(String content) {
        ListElement newElement = new ListElement(content);
        if (firstElement == null) {
            firstElement = newElement;
        } else {
            ListElement appendBase = firstElement;
            while (true) {
                if (appendBase.getNext() != null) {
                    appendBase = appendBase.getNext();
                } else {
                    appendBase.setNext(newElement);
                    break;
                }
            }
        }
    }

    public String remove(String content) {
        if (content == null | firstElement == null) {
            return null;
        }
        if (content.isEmpty()) {
            return null;
        }
        ListElement previousElement = null;
        ListElement searchBase = firstElement;
        while (true) {
            if (searchBase.getContent().equals(content)) {
                if (searchBase.equals(firstElement)) {
                    if (firstElement.getNext() != null) {
                        firstElement = firstElement.getNext();
                    } else {
                        firstElement = null;
                    }
                    return content;
                } else {
                    if (searchBase.getNext() != null) {
                        previousElement.setNext(searchBase.getNext());
                    } else {
                        previousElement.setNext(null);
                    }
                    return content;
                }
            }
            if (searchBase.getNext() != null) {
                previousElement = searchBase;
                searchBase = searchBase.getNext();
            } else {
                return null;
            }
        }
    }
}

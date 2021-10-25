package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private ArrayList<Entry> entries = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("ROOT");
    }

    @Override
    public boolean add(String s) {
        Entry<String> child = new Entry<>(s);
        entries.add(child);

        if (entries.size() < 3) {
            child.parent = root;
            if (root.availableToAddLeftChildren) {
                root.leftChild = child;
                root.availableToAddLeftChildren = false;
                child.isLeftChild = true;
            } else {
                root.rightChild = child;
                root.availableToAddRightChildren = false;
                child.isRightChild = true;
            }
            return true;
        }

        for (Entry entry : entries) {
            child.parent = entry;
            if (entry.availableToAddRightChildren) {
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = child;
                    entry.availableToAddLeftChildren = false;
                } else {
                    entry.rightChild = child;
                    entry.availableToAddRightChildren = false;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return entries.size();
    }

    public String getParent(String elementName) {
        for (Entry entry : entries) {
            if (entry.getElementName().equals(elementName)) {
                return entry.parent.getElementName();
            }
        }
        return "null";
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof String) {
            for (Entry entry : entries) {
                if (entry.getElementName().equals(o)) {
                    removeChildren(entry);
                    if (entry.isLeftChild) {
                        entry.parent.availableToAddLeftChildren = true;
                    } else if (entry.isRightChild) {
                        entry.parent.availableToAddRightChildren = true;
                    }
                    entries.remove(entry);
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }

        return false;
    }

    private void removeChildren(Entry parent) {
        Entry leftChild = parent.leftChild;
        while (parent.leftChild != null) {
            removeChildren(leftChild);
            entries.remove(leftChild);
            parent.leftChild = null;
            parent.availableToAddLeftChildren = true;
        }
        Entry rightChild = parent.rightChild;
        while (parent.rightChild != null) {
            removeChildren(rightChild);
            entries.remove(rightChild);
            parent.rightChild = null;
            parent.availableToAddRightChildren = true;
        }
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        boolean isLeftChild, isRightChild;
        Entry<T> parent, leftChild, rightChild;

        Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        String getElementName() {
            return elementName;
        }


    }

}

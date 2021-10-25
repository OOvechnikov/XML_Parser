package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) Math.ceil((float) collection.size() / 0.75f));
        map = new HashMap<>(capacity);
        addAll(collection);
    }

    public boolean add(E e) {
        if (map.containsKey(e)) {
            return false;
        }
        map.put(e, PRESENT);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        if (map.containsKey(o)) {
            map.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public AmigoSet clone() throws InternalError {
        try {
            AmigoSet newAmigoSet = (AmigoSet) super.clone();
            newAmigoSet.map = (HashMap) map.clone();
            return newAmigoSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();

//        Set<E> set = HashMapReflectionHelper.callHiddenMethod(map, "keySet");
        Set<E> set = map.keySet();
        int size = set.size();
        oos.writeInt(size);
        for (E e : set) {
            oos.writeObject(e);
        }

        oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        int size = ois.readInt();
        Set<E> set = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            set.add((E) ois.readObject());
        }

        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();

        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
        }
    }

}

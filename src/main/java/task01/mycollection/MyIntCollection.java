package task01.mycollection;

import java.util.Arrays;

/**
 * Created by Rustam on 17.10.2016.
 */
public class MyIntCollection implements MyCollection<Integer> {

    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int[] array;
    private int size;

    public MyIntCollection() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyIntCollection(int[] intArray) {
        this.array = Arrays.copyOf(intArray, (intArray.length + DEFAULT_CAPACITY));
        this.size = intArray.length;
    }

    @Override
    public void add(int index, Integer value) {
        checkIndexInBounds(index);
        ensureCapacity(index);
        int[] newArray = new int[array.length + 1];

        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, size - index);
        size++;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                newArray[i] += value;
            }
        }
        this.array = newArray;
    }

    @Override
    public void add(Integer value) {
        this.add(size, value);
    }

    @Override
    public void addToHead(Integer value) {
        this.add(0, value);
    }

    @Override
    public void removeByIndex(int index) {
        checkIndexInBounds(index);
        int value = this.array[index];
        int[] newArray = new int[this.array.length - 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(this.array, index + 1, newArray, index, size - index - 1);
        size--;

        for (int i = 0; i < size; i++) {
            newArray[i] -= value;
        }
            this.array = newArray;
    }

    @Override
    public boolean remove(Integer value) {
        boolean isRemoved = false;
        for (int i = 0; i < size; i++) {
            if (this.array[i] == value) {
                removeByIndex(i);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    @Override
    public Integer get(int index) {
        checkIndexInBounds(index);
        return this.array[index];
    }

    private void ensureCapacity(int requiredCapacity) {
        if (this.capacity < requiredCapacity) {
            int newCapacity = requiredCapacity + DEFAULT_CAPACITY;
            this.array = Arrays.copyOf(this.array, newCapacity);
        }
    }

    private void checkIndexInBounds(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Error: index is less than zero or bigger than collection size");
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}

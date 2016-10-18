package task01.mycollection;

/**
 * Created by Rustam on 17.10.2016.
 */
interface MyCollection<E> {

    void addToHead(E element);

    void add(int index, E element);

    void add(E element);

    void removeByIndex(int index);

    boolean remove(E element);

    E get(int index);

}

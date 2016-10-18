package task01.mycollection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rustam on 17.10.2016.
 */
public class MyIntCollectionTest {

    private int[] intArray = {10, 20, 30};
    private MyIntCollection myCollection = new MyIntCollection(intArray);

    @Test
    public void addToHeadTest() throws Exception {
        myCollection.addToHead(3);
        assertTrue(myCollection.get(0).equals(3));
        myCollection.addToHead(2);
        assertTrue(myCollection.get(0).equals(2));
        myCollection.addToHead(1);
        assertTrue(myCollection.get(0).equals(1));
        assertTrue("addToHeadTest(): invalid size", myCollection.getSize() == 6);
    }

    @Test
    public void addToTailTest() throws Exception {
        MyIntCollection collection = new MyIntCollection();
        collection.add(10);
        assertTrue(collection.get(0).equals(10));
        collection.add(20);
        assertTrue(collection.get(1).equals(20));
        collection.add(30);
        assertTrue(collection.get(2).equals(30));
        assertTrue("addToTailTest(): invalid size", collection.getSize() == 3);
    }

    @Test
    public void addByIndexTest() throws Exception {
        myCollection.add(1, 100);
        assertTrue(myCollection.get(0) == 110);
        assertTrue(myCollection.get(1) == 100);
        assertTrue(myCollection.get(2) == 120);
        assertTrue(myCollection.get(3) == 130);
        assertTrue("addByIndexTest(): invalid size", myCollection.getSize() == 4);
    }

    @Test
    public void addAndChangeValuesTest() throws Exception {
        myCollection.add(5);
        assertTrue(myCollection.get(0).equals(15));
        assertTrue(myCollection.get(1).equals(25));
        assertTrue(myCollection.get(2).equals(35));
        assertTrue(myCollection.get(3).equals(5));
        assertTrue("addAndChangeValuesTest(): invalid size", myCollection.getSize() == 4);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addByIndexOutOfBoundsTest() throws Exception {
        myCollection.add(5, 7);
    }

    @Test
    public void addHundredElements() throws Exception {
        for (int i = 0; i < 100; i++) {
            myCollection.add(10);
        }
        assertTrue(myCollection.getSize() == 103);
    }

    @Test
    public void removeExistentValueTest() throws Exception {
        assertTrue(myCollection.remove(10));
    }

    @Test
    public void removeNonExistentValueTest() throws Exception {
        assertTrue(!myCollection.remove(555));
    }

    @Test
    public void removeByIndexTest() throws Exception {
        assertTrue(myCollection.getSize() == 3);
        myCollection.removeByIndex(2);
        assertTrue(myCollection.getSize() == 2);
        myCollection.removeByIndex(1);
        assertTrue(myCollection.getSize() == 1);
        myCollection.removeByIndex(0);
        assertTrue("removeByIndexTest(): invalid size", myCollection.getSize() == 0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeByIndexOutOfBoundsTest() throws Exception {
        myCollection.removeByIndex(8);
    }

    @Test
    public void removeAndChangeExistentValues() throws Exception {
        System.out.println(myCollection);
        myCollection.remove(10);
        System.out.println(myCollection);
        assertTrue(myCollection.get(0) == 10);
        assertTrue(myCollection.get(1) == 20);
        assertTrue("removeAndChangeExistentValues(): invalid size", myCollection.getSize() == 2);
    }
}
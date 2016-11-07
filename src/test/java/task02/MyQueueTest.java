package task02;

import org.junit.Test;
import task02.myqueue.MyQueue;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Пользователь on 31.10.2016.
 */
public class MyQueueTest {

    MyQueue<Integer> myQueue;
    String sizeError = "Wrong size!";

    @Test
    public void offerLessThanCapacityTest() throws Exception {
        myQueue = new MyQueue<Integer>(3);
        assertTrue(myQueue.offer(10));
        assertEquals(sizeError, 1, myQueue.size());
        assertTrue(myQueue.offer(20));
        assertEquals(sizeError, 2, myQueue.size());
        assertTrue(myQueue.offer(30));
        assertEquals(sizeError, 3, myQueue.size());
    }

    @Test
    public void offerMoreThanCapacityTest() throws Exception {
        myQueue = new MyQueue<Integer>(3);
        assertTrue(myQueue.offer(10));
        assertEquals(sizeError, 1, myQueue.size());
        assertTrue(myQueue.offer(20));
        assertEquals(sizeError, 2, myQueue.size());
        assertTrue(myQueue.offer(30));
        assertEquals(sizeError, 3, myQueue.size());
        assertTrue(myQueue.offer(40));
        assertEquals(sizeError, 3, myQueue.size());
    }

    @Test
    public void removeNonExistentElementTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        assertEquals(sizeError, 1, myQueue.size());
        assertTrue(!myQueue.remove(20));
    }

    @Test
    public void removeExistentElementTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        myQueue.offer(20);
        assertEquals(sizeError, 2, myQueue.size());
        assertTrue(myQueue.remove(10));
        assertTrue(!myQueue.contains(10));
        assertEquals(sizeError, 1, myQueue.size());
    }

    @Test
    public void removeTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        myQueue.offer(20);
        assertEquals(sizeError, 2, myQueue.size());
        assertTrue(myQueue.remove() == 10);
        assertTrue(myQueue.remove() == 20);
        assertEquals(sizeError, 0, myQueue.size());
    }

    @Test (expected = NoSuchElementException.class)
    public void removeFromEmptyQueueTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        assertEquals(sizeError, 1, myQueue.size());
        assertTrue(myQueue.remove() == 10);
        myQueue.remove();
    }

    @Test
    public void pollTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        assertEquals(sizeError, 1, myQueue.size());
        assertTrue(myQueue.poll() == 10);
        myQueue.poll();
    }

    @Test
    public void pollFromEmptyQueueTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        assertEquals(sizeError, 1, myQueue.size());
        assertTrue(myQueue.poll() == 10);
        myQueue.poll();
        assertTrue(myQueue.poll() == null);
    }

    @Test
    public void peekTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        myQueue.offer(20);
        assertEquals(sizeError, 2, myQueue.size());
        assertTrue(myQueue.peek() == 10);
        assertTrue(myQueue.peek() == 10);
    }

    @Test
    public void peekEmptyQueueTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        assertEquals(sizeError, 0, myQueue.size());
        assertTrue(myQueue.peek() == null);
        assertTrue(myQueue.peek() == null);
    }

    @Test
    public void elementTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        myQueue.offer(10);
        myQueue.offer(20);
        assertEquals(sizeError, 2, myQueue.size());
        assertTrue(myQueue.element() == 10);
        assertTrue(myQueue.element() == 10);
    }

    @Test (expected = NoSuchElementException.class)
    public void elementEmptyQueueTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        assertEquals(sizeError, 0, myQueue.size());
        myQueue.element();
    }

    @Test
    public void iteratorNextTest() throws Exception {
        myQueue = new MyQueue<Integer>(3);
        Iterator<Integer> itr = myQueue.iterator();
        assertTrue(myQueue.add(10));
        assertTrue(myQueue.add(20));
        assertTrue(myQueue.add(30));
        assertTrue(itr.next() == 10);
        assertTrue(itr.next() == 20);
        assertTrue(itr.next() == 30);
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextMoreThanCapacityTest() throws Exception {
        myQueue = new MyQueue<Integer>(3);
        Iterator<Integer> itr = myQueue.iterator();
        assertTrue(myQueue.add(10));
        assertTrue(myQueue.add(20));
        assertTrue(myQueue.add(30));
        assertTrue(itr.next() == 10);
        assertTrue(itr.next() == 20);
        assertTrue(itr.next() == 30);
        assertTrue(itr.next() == 40);
    }

    @Test
    public void iteratorRemoveTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        Iterator<Integer> itr = myQueue.iterator();
        assertTrue(myQueue.add(10));
        assertTrue(myQueue.add(20));
        itr.next();
        itr.remove();
        assertTrue(!myQueue.contains(10));
        itr.next();
        itr.remove();
        assertTrue(!myQueue.contains(20));
        assertTrue(myQueue.isEmpty());
    }

    @Test (expected = NoSuchElementException.class)
    public void iteratorRemoveEmptyQueueTest() throws Exception {
        myQueue = new MyQueue<Integer>(2);
        Iterator<Integer> itr = myQueue.iterator();
        itr.next();
        itr.remove();
    }

    @Test
    public void addTest() throws Exception {
        myQueue = new MyQueue<Integer>(3);
        assertTrue(myQueue.add(10));
        assertEquals(sizeError, 1, myQueue.size());
        assertTrue(myQueue.add(20));
        assertEquals(sizeError, 2, myQueue.size());
    }

    @Test
    public void addAllTest() throws Exception {
        myQueue = new MyQueue<Integer>(6);
        Collection<Integer> coll = Arrays.asList(300, 400, 500);
        myQueue.offer(10);
        myQueue.offer(20);
        assertTrue(myQueue.addAll(coll));
        assertTrue(myQueue.size() == 5);
    }

    @Test
    public void addAllMoreThanCapacityTest() throws Exception {
        myQueue = new MyQueue<Integer>(4);
        Collection<Integer> coll = Arrays.asList(300, 400, 500);
        myQueue.offer(10);
        myQueue.offer(20);
        assertTrue(!myQueue.addAll(coll));
        assertTrue(myQueue.size() == 2);
    }

    @Test
    public void removeAllTest() throws Exception {
        myQueue = new MyQueue<Integer>(6);
        Collection<Integer> coll = Arrays.asList(10, 30, 50);
        myQueue.offer(10);
        myQueue.offer(20);
        myQueue.offer(30);
        myQueue.offer(40);
        myQueue.offer(50);
        myQueue.offer(60);
        assertTrue(myQueue.removeAll(coll));
        assertTrue(myQueue.size() == 3);
        assertTrue(!myQueue.contains(10));
        assertTrue(!myQueue.contains(30));
        assertTrue(!myQueue.contains(50));
    }

    @Test
    public void removeAllNonExistentCollectionTest() throws Exception {
        myQueue = new MyQueue<Integer>(6);
        Collection<Integer> coll = Arrays.asList(100, 300, 500);
        myQueue.offer(10);
        myQueue.offer(20);
        myQueue.offer(30);
        myQueue.offer(40);
        myQueue.offer(50);
        assertTrue(!myQueue.removeAll(coll));
        assertTrue(myQueue.size() == 5);
    }
}
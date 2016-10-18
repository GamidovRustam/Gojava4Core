package task01;

import task01.mycollection.MyIntCollection;

/**
 * Created by Rustam on 18.10.2016.
 */
class App {

    public static void main(String[] args) {
        int[] startValues = {10, 20, 30, 40, 50};
        MyIntCollection myCollection = new MyIntCollection(startValues);

        System.out.println("'MyCollection' filled with start values:");
        System.out.println(myCollection + "\n");

        myCollection.addToHead(5);
        System.out.println("add value '5' to head: ");
        System.out.println(myCollection + "\n");

        myCollection.add(100);
        System.out.println("add value '100' to tail: ");
        System.out.println(myCollection + "\n");

        myCollection.add(4, 1000);
        System.out.println("add value '1000' to index position '4': ");
        System.out.println(myCollection + "\n");

        myCollection.remove(1000);
        System.out.println("remove existing value '1000': ");
        System.out.println(myCollection + "\n");

        myCollection.removeByIndex(2);
        System.out.println("remove value '125' by index '2': ");
        System.out.println(myCollection + "\n");

    }

}

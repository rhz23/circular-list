package program;

import entities.CircularList;

public class Main {
    public static void main(String[] args) {

        CircularList<String> myList = new CircularList<>();

        myList.add("c1");
        System.out.println(myList);

        myList.remove(0);
        System.out.println(myList);
        //myList.add("c1");

        myList.add("c1");
        System.out.println(myList);

        myList.add("c2");
        myList.add("c3");
        myList.add("c4");
        myList.add("c5");
        System.out.println(myList);


        System.out.println(myList.get(0));
    }
}

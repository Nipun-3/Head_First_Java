package c11.sharpenYourPencil.pg_353;

import java.util .*;

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();

    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");

        Set<Book> tree = new TreeSet<>((one,two)->one.getTitle().compareTo(two.getTitle()));   // custom comparator
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);

    }
}

class Book {
    private String title;

    public String getTitle() {    // added getter as title is private
        return title;
    }

    public Book(String t) {
        title = t;
    }

    public String toString() {
        return title;
    }
}

//  is getting compiled successfully
// Exception in thread "main" java.lang.ClassCastException: class c14.sharpenYourPencil.pg_353.Book cannot be cast to class java.lang.Comparable
// need to implement comparable or a custom comparator
// and also override toString method
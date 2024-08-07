package c11.sharpenYourPencil.pg_343;

import java.util .*;
public class SortMountains {
    public static void main(String[ ] args) {
        new SortMountains ().go();
    }
    public void go() {
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain("Longs",14255));
        mountains.add(new Mountain("Elbert", 14433));
        mountains.add(new Mountain("Maroon", 14156));
        mountains.add(new Mountain("Castle", 14265));
        System.out.println("as entered:\n"+mountains);

        mountains.sort((one, two) -> one.name.compareTo(two.name));
        System.out.println("by name:\n" + mountains);

        mountains.sort((one, two) -> one.height - two.height);
        System.out.println("by height:\n" + mountains);
    }

}

class Mountain {
    String name;
    int height;

    Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String toString( ) {
        return name + " " + height;
    }
}

// without overriding toString method output will be like :

//as entered:
//        [c14.sharpenYourPencil.pg_343.Mountain@28a418fc, c14.sharpenYourPencil.pg_343.Mountain@5305068a, c14.sharpenYourPencil.pg_343.Mountain@1f32e575, c14.sharpenYourPencil.pg_343.Mountain@279f2327]
//by name:
//        [c14.sharpenYourPencil.pg_343.Mountain@279f2327, c14.sharpenYourPencil.pg_343.Mountain@5305068a, c14.sharpenYourPencil.pg_343.Mountain@28a418fc, c14.sharpenYourPencil.pg_343.Mountain@1f32e575]
//by height:
//        [c14.sharpenYourPencil.pg_343.Mountain@1f32e575, c14.sharpenYourPencil.pg_343.Mountain@28a418fc, c14.sharpenYourPencil.pg_343.Mountain@279f2327, c14.sharpenYourPencil.pg_343.Mountain@5305068a]

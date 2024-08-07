package c7;

public class MonsterTestDrive {

    public static void main(String[] args) {
        Monster[] monsters = new Monster[3];
        monsters[0] = new Vampire();
        monsters[1] = new Dragon();
        monsters[2] = new Monster();
        for (int i = 0; i < monsters.length; i++)
            monsters[i].frighten(i);

    }
}

//class Monster {
//    boolean frighten(int d) {
//        System.out.println("arrrgh");
//        return true;
//    }
//}
//
//class Vampire extends Monster {
//    boolean frighten(int x) {
//        System.out.println("a bite?");
//        return false;
//    }
//}

//1. output :
//a bite?
//breathe fire
//arrrgh

//-------------------------------------------------------------

//class Monster {
//    boolean frighten(int x) {
//        System.out.println("arrrgh");
//        return true;
//    }
//}
//
//class Vampire extends Monster {
//    int frighten(int f) {
//        System.out.println("a bite?");
//        return 1;
//    }
//}
//    2.    will not work coz return type of frighten method is boolean not int (overriding doesn't allow this)

//-----------------------------------------------------

//class Monster {
//    boolean frighten(int x) {
//        System.out.println("arrrgh");
//        return true;
//    }
//}
//
//class Vampire extends Monster {
//    boolean scare(int x) {
//        System.out.println("a bite?");
//        return true;
//    }
//}
//
//3.     output : // vampire object calling the method of monster class
//
//arrrgh
//breathe fire
//arrrgh

//-------------------------------------------------------

class Monster {
    boolean frighten(int z) {
        System.out.println("arrrgh");
        return true;
    }
}

class Vampire extends Monster {
    boolean frighten(byte b) {
        System.out.println("a bite?");
        return true;
    }
}


//4. output:  // we are overloading the frighten method here not overriding
//
//arrrgh
//breathe fire
//arrrgh


class Dragon extends Monster {
    boolean frighten(int degree) {
        System.out.println("breathe fire");
        return true;
    }
}

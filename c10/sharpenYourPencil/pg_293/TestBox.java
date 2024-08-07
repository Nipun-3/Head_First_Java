package c10.sharpenYourPencil.pg_293;

public class TestBox {
    private Integer i;    //  null reference
    private int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();

    }

    public void go() {
        j = i;                  // NullPointerException
        System.out.println(j);
        System.out.println(i);

    }
}

//       Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "this.i" is null

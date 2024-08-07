package c9;

public class GC {
    public static GC doStuff() {
        GC newGC = new GC();
        doStuff2(newGC);
        return newGC;

    }

    public static void main(String[] args) {
        GC gcl;
        GC gc2 = new GC();
        GC gc3 = new GC();
        GC gc4 = gc3;
        gcl = doStuff();

        //copyGC = null;        out of scope

        //gc2 = null;             yes

        //newGC= gc3;          out of scope

       // gcl = null;          yes

       // newGC = null;           out of scope

        //gc4 = null;            no, gc3 and gc4 are pointing to same object

       // gc3= gc2;             no, gc4 is still pointing to that object

        //gcl= gc4;             yes

       // gc3= null;            no, gc4 is still pointing to that object

    }

    public static void doStuff2(GC copyGC) {
        GC localGC = copyGC;

    }
}
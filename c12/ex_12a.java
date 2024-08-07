package c12;

public class ex_12a {
    public interface Runnable {
        void run();
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Supplier<T> {
        T get();
    }

    public interface Function<T, R> {
        R apply(T t);
    }

//    Runnable r = () -> System.out.println("Hi!");         //C

//    Consumer<String> c = s -> System.out.println(s) ;       //C

//    Supplier<String> s = () -> System.out.println("Some string") ;   //NC : should return a string

//    Consumer<String> c = (s1, s2) -> System.out.println(s1 + s2) ;     //NC : requires only 1 arg

//    Runnable r = (String str) -> System.out.println(str) ;     //NC

//    Function<String, Integer> f = s -> s.length () ;          //C

//    Supplier<String> s = () -> "Some string";           //C

//    Consumer<String> c = s -> "String" + s;      //  NC : should return nothing

//    Function<String, Integer> f = (int i) -> "i = " + i;  // NC : params interchanged

//    Supplier<String> s = s -> "Some string: " + s;     //NC

    Function<String, Integer> f = (String s) -> s.length() ;        //C

}

package c18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ex_18a {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Data_ data = new Data_();


        threadPool.execute(() -> addLetterToData('a', data));
        threadPool.execute(() -> addLetterToData('A', data));
        threadPool.shutdown();
    }

    private static void addLetterToData(char letter, Data_ data) {
        for (int i = 0; i < 26; i++) {
            synchronized (data) {   // addLetter method is synchronized
                data.addLetter(letter++);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {
            }
        }
        // Print the data after all letters are added
        System.out.println(Thread.currentThread().getName() + " " + data.getLetters());
        System.out.println(Thread.currentThread().getName() + " size = " + data.getLetters().size());
    }
}

final class Data_ {
    private final List<String> letters = new ArrayList<>();

    public List<String> getLetters() {
        return new ArrayList<>(letters); // Defensive copy
    }

    public void addLetter(char letter) {
        letters.add(String.valueOf(letter));
    }
}

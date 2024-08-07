package c12;

import java.util .*;
import java.util.stream .*;

public class CoffeeOrder {
    public static void main(String[] args) {
        List<String> coffees = List.of("Cappuccino",
                "Americano", "Espresso", "Cortado", "Mocha",
                "Cappuccino", "Flat White", "Latte");

        List<String> coffeesEndingIno = coffees.stream()
                .distinct()
                .sorted()
                .filter(s -> s.endsWith("o"))
                .collect(Collectors.toList());
        System.out.println(coffeesEndingIno);
    }
}
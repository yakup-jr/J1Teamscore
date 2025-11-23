package ru.teamscore.ui;

import java.util.List;
import java.util.Map;

/**
 * The type Rounding.
 */
public class Rounding {

    private static final String division =
        "|---------------------|----------------------|----------------------|---------------------|";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Map<String, List<Double>> values = ru.teamscore.core.Rounding.calculate();
        System.out.println(division);
        System.out.printf("|%20s | %20s | %20s | %20s|", "round", "ceil", "floor",
            "rint");
        for (int i = 0; i < values.get("Math.round").size(); i++) {
            System.out.println("\n" + division);
            System.out.printf("|%20s | %20s | %20s | %20s|",
                values.get("Math.round").get(i),
                values.get("Math.ceil").get(i), values.get("Math.floor").get(i),
                values.get("Math.rint").get(i));
        }
        System.out.println(
            "\n" + division);
    }

}

package ru.teamscore.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rounding {

    private static final double[] values =
        {30.0, 10000.1, 12.5, 99.99, 0.0, -23.45, -4.5, -129.675};

    private Rounding() {
    }

    public static Map<String, List<Double>> calculate() {
        Map<String, List<Double>> valuesMathRoundingMethods = new HashMap<>();
        valuesMathRoundingMethods.put("Math.round", new ArrayList<>());
        valuesMathRoundingMethods.put("Math.ceil", new ArrayList<>());
        valuesMathRoundingMethods.put("Math.floor", new ArrayList<>());
        valuesMathRoundingMethods.put("Math.rint", new ArrayList<>());
        for (double value : values) {
            valuesMathRoundingMethods.get("Math.round").add((double) Math.round(value));
            valuesMathRoundingMethods.get("Math.ceil").add(Math.ceil(value));
            valuesMathRoundingMethods.get("Math.floor").add(Math.floor(value));
            valuesMathRoundingMethods.get("Math.rint").add(Math.rint(value));
        }
        return valuesMathRoundingMethods;
    }

}

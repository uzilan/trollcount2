package com.landsmann.trollcount2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TrollNumber {

    int value;

    TrollNumber(int value) {
        this.value = value;
    }

    public static TrollNumber one = new TrollNumber(1);
    public static TrollNumber two = new TrollNumber(2);
    public static TrollNumber three = new TrollNumber(3);
    public static TrollNumber many = new TrollNumber(4);
    public static TrollNumber lots = new TrollNumber(16);

    public static TrollNumber parse(String s) {
        String[] split = s.split("-");
        switch (split.length) {

            case 0: throw new IllegalArgumentException("Huh?");

            case 1:
                switch (split[0]) {
                    case "one": return one;
                    case "two": return two;
                    case "three": return three;
                    case "many": return many;
                    case "lots": return lots;
                    default: throw new IllegalArgumentException("Huh?");
                }

            default: return new ComplexTrollNumber(Arrays.stream(split)
                        .map(spl -> parse(spl).value)
                        .collect(Collectors.toList()));
        }
    }

    @Override
    public String toString() {
        switch (value) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "many";
            case 16: return "lots";
            default: return "Huh?";
        }
    }
}

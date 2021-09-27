package com.company;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum RomanNumeral {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    private static final List<RomanNumeral> REVERSE_SORTED_VALUES =
            Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral v) -> v.value).reversed())
                    .collect(Collectors.toList());
    public static String convertArabicNumber(int number) throws Exception {
        if (number < 0){
            throw new Exception ("Римское число не может быть меньше 0");
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number != 0) {
            if (REVERSE_SORTED_VALUES.get(i).value <= number) {
                number -= REVERSE_SORTED_VALUES.get(i).value;
                result.append(REVERSE_SORTED_VALUES.get(i).toString());
            } else i++;
        }
        return result.toString();
    }

}
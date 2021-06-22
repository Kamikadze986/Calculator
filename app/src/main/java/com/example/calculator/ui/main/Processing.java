package com.example.calculator.ui.main;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Processing {
    static public int searchMinIndex(String item, int middleIndex) {
        do {
            middleIndex--;
            if (middleIndex <= 0)
                return 0;
        } while (item.charAt(middleIndex) != ' ');
        return middleIndex;
    }

    static public int searchMaxIndex(String item, int middleIndex) {
        do {
            middleIndex++;
            if (middleIndex == item.length())
                return middleIndex;
        } while (item.charAt(middleIndex) != ' ');
        return middleIndex;
    }

    static public String processingExpression(String item, int middleIndex) {
        Long num1 = Long.parseLong(item.substring(0, middleIndex - 1).replaceAll("\\s+", ""));
        Long num2 = Long.parseLong(item.substring(middleIndex + 2));
        char sign = item.charAt(middleIndex);
        switch (sign) {
            case '+':
                return " " + (num1 + num2);
            case '-':
                return " " + (num1 - num2);
            case '*':
                return " " + num1 * num2;
            case '/':
                if (num1 == 0)
                    return " 0";
                return " " + num1 / num2;
            default:
                return item;
        }
    }

}

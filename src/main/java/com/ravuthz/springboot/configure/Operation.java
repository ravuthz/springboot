package com.ravuthz.springboot.configure;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/2017, 11:53 AM
 * Email : ravuthz@gmail.com
 */

public enum Operation {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE;

    double calculate(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }
}

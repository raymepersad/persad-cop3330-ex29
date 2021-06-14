/*
 *  UCF COP3330 Summer 2021 Assignment 27 Solution
 *  Copyright 2021 RAYME PERSAD
 */

/*
Write a quick calculator that prompts for the rate of return on an investment
and calculates how many years it will take to double your investment.
 */


package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BadInputHandler {
    private String rateFromUSer;
    private float rate;
    private BufferedReader input;

    BadInputHandler() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    private String promptRate() throws IOException {
        System.out.println("What is the rate of return ? ");
        return input.readLine();
    }

    //variant with while loop
    void readRateFromUser() throws IOException {
        while (true) {
            rateFromUSer = promptRate();
            if (mustExit(rateFromUSer)) {
                return;
            }
            if (isValid(rateFromUSer)) {
                rate = Float.parseFloat(rateFromUSer);
                break;
            }
        }
        System.out.println("It will take " + 72 / rate + " years to double your initial investment.");
    }

    //variant with for loop
    void readRateFromUser1() throws IOException {
        for (int i = 0; i < 1; i = incrementValue()) {
            rateFromUSer = promptRate();
            if (mustExit(rateFromUSer)) {
                return;
            }
        }
        System.out.println("It will take " + 72 / rate + " years to double your initial investment.");
    }

    private int incrementValue() {
        int value = 0;
        if (isValid(rateFromUSer)) {
            rate = Float.parseFloat(rateFromUSer);
            value++;
        }
        return value;
    }

    // variant with do while loop
    void readRateFromUser2() throws IOException {
        do {
            rateFromUSer = promptRate();
            if (mustExit(rateFromUSer)) {
                return;
            }
            if (isValid(rateFromUSer)) {
                rate = Float.parseFloat(rateFromUSer);
                break;
            }
        } while (true);
        System.out.println("It will take " + 72 / rate + " years to double your initial investment.");
    }

    private boolean isValid(String inputFromUser) {
        boolean isValidInput = false;
        try {
            float valueInt = Float.parseFloat(inputFromUser);
            if (valueInt == 0) {
                System.out.println("Sorry. That's not a valid input.");
            } else {
                isValidInput = true;
            }
        } catch (IllegalArgumentException e) {
            isValidInput = false;
            System.out.println("Sorry. That's not a valid input.");
        }
        return isValidInput;
    }

    private boolean mustExit(String input) {
        return input.equals("exit");
    }
}

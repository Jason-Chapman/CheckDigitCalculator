package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long[] barcode = new long[13];

        System.out.println("Input 13 Digit Barcode: ");
        long digits = input.nextLong();

        for (int i = barcode.length - 1; i >= 0; i--) {
            barcode[i] = digits % 10;
            digits = digits / 10;
        }

        int checkDigit = (int) barcode[12];
        int calcCheckDigit = 0;

        for (int i = 0; i < 13; i++) {
            calcCheckDigit = (int) (calcCheckDigit + barcode[i]);
        }

        long[] calcCheckDigitList = new long[3];

        for (int i = calcCheckDigitList.length - 1; i >= 0; i--) {
            calcCheckDigitList[i] = calcCheckDigit % 10;
            calcCheckDigit = calcCheckDigit / 10;
        }

        for (int i = 0; i < 3; i++) {
            calcCheckDigit = (int) (calcCheckDigit + calcCheckDigitList[i]);
        }

        long[] finalCalcCheckDigitList = new long[2];

        for (int i = finalCalcCheckDigitList.length - 1; i >= 0; i--) {
            finalCalcCheckDigitList[i] = calcCheckDigit % 10;
            calcCheckDigit = calcCheckDigit / 10;
        }

        for (int i = 0; i < 2; i++) {
            calcCheckDigit = (int) (calcCheckDigit + finalCalcCheckDigitList[i]);
        }

        System.out.println("The Check Digit of this Barcode is: "+calcCheckDigit);
    }
}

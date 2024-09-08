package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static int quyu(char c) {
        if (c >= '1' && c <= '8') {
            return (c - '1') % 2;
        } else {
            return (c - 'a') % 2;
        }
    }

    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int c1 = quyu(coordinate1.charAt(0));
        int c2 = quyu(coordinate1.charAt(1));
        int d1 = quyu(coordinate2.charAt(0));
        int d2 = quyu(coordinate2.charAt(1));

        System.out.println(c1 + " " + c2 + " " + d1 + " " + d2);
//        System.out.println(1 ^ 0);
//        System.out.println(0 ^ 0);
        return false;
    }

    public static void main(String[] args) {
        checkTwoChessboards("a1", "h3");
    }
}

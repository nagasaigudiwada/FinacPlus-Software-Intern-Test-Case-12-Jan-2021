/*
Write a program that finds the most optimized set of 6 units to shop with for values
fewer than 100. Example: Units used are 1, 2, 5, 10, 20, 50 1: 1 (1 unit used) 2: 2 (1
unit used) 3: 1+2 (2 units used) 4: 2+2 (2 units used) ... 98: 1+2+5+20+20+50 (6 units
used) 99: 2+2+5+20+20+50 (6 units used) AVG of units = 3.4
  */




import java.util.*;

public class Set {

    static int[] units = {1, 2, 5, 10, 20, 50};

    public static int minUnits(int value) {
        int count = 0;
        for (int i = units.length - 1; i >= 0 && value > 0; i--) {
            while (value >= units[i]) {
                value -= units[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int sum = 0;
        int maxValue = 99;

        for (int i = 1; i <= maxValue; i++) {
            sum += minUnits(i);
        }

        double average = (double) sum / maxValue;

        System.out.println("AVG of units = " + average);
    }
}

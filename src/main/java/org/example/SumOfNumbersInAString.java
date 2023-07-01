package org.example;


//Given a string, WAP to print the sum of numbers present in the string.
/**
 Input: S = “11aa32bbb5”
 Output: 48
 Explanation:
 The consecutive sequence of numbers present in the string S are {11, 32, 5}.
 Therefore, sum = 11 + 32 + 5 = 48
 */


public class SumOfNumbersInAString {

    public static void main(String[] args) {

      String str = "11aa32bbb5";
     int sum = getSumOfNumbersFromAString(str);
     System.out.println(sum);

    }

    private static int getSumOfNumbersFromAString(String s){

        int sum = 0;
        int currentNumber = 0;

        for(int i=0; i<s.length();i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                currentNumber = currentNumber * 10 + Character.getNumericValue(ch);
            }
            else {
                sum = sum + currentNumber;
                currentNumber = 0;
            }
        }
        sum = sum + currentNumber;
        return sum;
    }



}

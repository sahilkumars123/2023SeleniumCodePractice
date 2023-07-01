package org.example;

public class SecondLargestElementInArray {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5};
        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++){
            if(array[i] > largest){
                second_largest = largest;
                largest = array[i];
            }
            else if(array[i] < largest && array[i]!= second_largest) {
                second_largest = array[i];
            }
        }
        System.out.println("largest element is :: "+largest);
        System.out.println("second largest element:: "+second_largest);
    }
}

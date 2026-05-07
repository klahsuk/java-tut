package Collections;

 import java.util.Scanner;

public class Arrays {

    public int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter number #" + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        return numbers;
    }

    public void printArray(int[] numbers){
        for (int n = 0; n < numbers.length;  n++) {
            System.out.printf("Element %d contents %d", n, numbers[n]);
        }
    }

    public int[] sortIntegers(int[] numbers){
        java.util.Arrays.sort(numbers);

        int[] reversed = new int[numbers.length];
        for (int i = numbers.length -1, j = 0; i >= 0 &&  j < numbers.length ; i--, j++) {
            reversed[j] = numbers[i];
        }
        return reversed;
    }
}

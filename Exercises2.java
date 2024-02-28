import java.util.Vector;
import java.util.Scanner;
import java.util.Arrays;


public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        // TODO
        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */


    public class romanIntoInt {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            int size = str.length();
            char [] charArray = str.toCharArray();

            int sum = 0;


            for(int i = 0;i < size;i++){
                if(charArray[i] == 'I')
                {
                    sum += 1;
                }

                if(charArray[i] == 'V')
                {
                    if(charArray[0] == charArray[i]){
                        sum += 5;
                    }

                    else if(charArray[i - 1] == 'I'){
                        sum += 3;
                    }

                    else{
                        sum += 5;
                    }
                }

                if(charArray[i] == 'X') {

                    if(charArray[0] == charArray[i])
                    {
                        sum += 10;
                    }

                    else if (charArray[i - 1] == 'I') {
                        sum += 8;
                    }

                    else
                        sum += 10;
                }
                if(charArray[i] == 'L'){

                    if(charArray[0] == charArray[i])
                    {
                        sum += 50;
                    }

                    else if(charArray[i - 1] == 'X'){
                        sum += 30;
                    }

                    else{
                        sum += 50;
                    }
                }

                if(charArray[i] == 'C'){

                    boolean condition;
                    condition = true;

                    if(charArray[0] == charArray[i])
                    {
                        sum += 100;
                    }

                    else if(charArray[i - 1] == 'X')
                        sum += 80;

                    else
                        sum += 100;
                }

                if(charArray[i] == 'D'){

                    if(charArray[0] == charArray[i])
                    {
                        sum += 500;
                    }

                    else if(charArray[i - 1] == 'C')
                        sum += 300;

                    else
                        sum += 500;
                }

                if(charArray[i] == 'M'){
                    if(charArray[0] == charArray[i])
                    {
                        sum += 1000;
                    }
                    else if(charArray[i - 1] == 'C')
                        sum += 800;

                    else
                        sum += 1000;
                }
            }
            System.out.println(sum);
        }



    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

        public class Permutation {
            public static void generatePermutations(int[] arr, int start, int end) {
                if (start == end) {
                    System.out.println(Arrays.toString(arr));
                    return;
                }

                for (int i = start; i <= end; ++i) {
                    swap(arr, start, i);
                    generatePermutations(arr, start + 1, end);
                    swap(arr, start, i);  // Backtrack
                }
            }

            public static void swap(int[] arr, int i, int j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Input array size
                System.out.println("Enter the size of the array: ");
                int n = scanner.nextInt();

                // Input array elements
                int[] array = new int[n];
                System.out.println("Enter the elements of the array:");
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.nextInt();
                }

                System.out.println("Permutations:");
                generatePermutations(array, 0, n - 1);
            }
        }

    public static void main(String[] args) {
        // test your code here!
    }
}
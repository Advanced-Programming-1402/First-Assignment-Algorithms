import java.util.*;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public static int[] twoSum(int[] nums, int target) {
        int arraySize = nums.length;
        int[] answerArray = new int[2];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    answerArray[0] = j;
                    answerArray[1] = i;
                    break;
                }
            }
        }
        return answerArray;
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

    public static int romanToInt(String s) {
        int stringSize = s.length();
        int sum = 0;

        for (int i = 0; i < stringSize; i++) {
            if (s.charAt(i) == 'I') {
                if (i < stringSize - 1 && s.charAt(i + 1) == 'V') {
                    sum = sum + 4;
                    i++;
                }
                else if (i < stringSize - 1 && s.charAt(i + 1) == 'X') {
                    sum = sum + 9;
                    i++;
                }
                else {
                    sum = sum + 1;
                }
            }
            else if (s.charAt(i) == 'V') {
                sum = sum + 5;
            }
            else if (s.charAt(i) == 'X') {
                if (i < stringSize - 1 && s.charAt(i + 1) == 'L') {
                    sum = sum + 40;
                    i++;
                }
                else if (i < stringSize - 1 && s.charAt(i + 1) == 'C') {
                    sum = sum + 90;
                    i++;
                }
                else {
                    sum = sum + 10;
                }
            }
            else if (s.charAt(i) == 'L') {
                sum = sum + 50;
            }
            else if (s.charAt(i) == 'C') {
                if (i < stringSize - 1 && s.charAt(i + 1) == 'D') {
                    sum = sum + 400;
                    i++;
                }
                else if (i < stringSize - 1 && s.charAt(i + 1) == 'M') {
                    sum = sum + 900;
                    i++;
                }
                else {
                    sum = sum + 100;
                }
            }
            else if (s.charAt(i) == 'D') {
                sum = sum + 500;
            }
            else if (s.charAt(i) == 'M') {
                sum = sum + 1000;
            }
        }
        return sum;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        for (int num : nums)
        {
            List<List<Integer>> permutations = new ArrayList<>();

            for (List<Integer> permutation : answer)
            {
                for (int i = 0; i <= permutation.size(); i++)
                {
                    List<Integer> newPermutation = new ArrayList<>(permutation);
                    newPermutation.add(i, num);
                    permutations.add(newPermutation);
                }
            }
            answer = permutations;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the count of numbers:");
        int numsCount = input.nextInt();
        int[] nums = new int[numsCount];

        System.out.println("Enter the numbers:");
        for (int i = 0; i < numsCount; i++) {
            nums[i] = input.nextInt();
        }

        System.out.println("Enter the target number:");
        int target = input.nextInt();

        System.out.println("The two numbers that sum up to target:");
        int[] answerArray = twoSum(nums, target);
        System.out.print("[" + answerArray[0] + ", " + answerArray[1] + "]");
        System.out.println();
        System.out.println();

        System.out.println("Enter the Roman number:");
        String romanNumber = input.next();

        int integerNumber = romanToInt(romanNumber);
        System.out.println("The integer value of Roman number:");
        System.out.println(integerNumber);
        System.out.println();

        System.out.println("Enter the count of numbers:");
        int numbersCount = input.nextInt();

        System.out.println("Enter the numbers:");
        int[] numbers = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            numbers[i] = input.nextInt();
        }

        List<List<Integer>> permutations = permute(numbers);
        System.out.println("All possible permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

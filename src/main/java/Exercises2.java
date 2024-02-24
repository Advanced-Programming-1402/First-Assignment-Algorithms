import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[nums.length];
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    temp[counter] = i;
                    temp[counter + 1] = j;
                    counter += 2;
                }
            }
        }

        int[] ans = new int[counter];

        for (int index = 0; index < counter; index++) {
            ans[index] = temp[index];
        }
        return ans;
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

    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'V':
                    ans += 5;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                default:
                    break;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'I') {
                if (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')
                    ans -= 1;
                else
                    ans += 1;
            }
            else if (s.charAt(i) == 'X') {
                if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')
                    ans -= 10;
                else
                    ans += 10;
            }
            else if (s.charAt(i) == 'C') {
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')
                    ans -= 100;
                else
                    ans += 100;
            }
        }
        if (s.charAt(s.length() - 1) == 'I')
            ans += 1;
        else if (s.charAt(s.length() - 1) == 'X')
            ans += 10;
        else if (s.charAt(s.length() - 1) == 'C')
            ans += 100;

        return ans;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    private void listCreator(List<List<Integer>> ans, List<Integer> temp, int[] nums) { // a Function to creat permutes and add them to answer List
        if (temp.size() == nums.length)
            ans.add(new ArrayList<>(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);

                listCreator(ans, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        listCreator(ans, new ArrayList<>(), nums);
        return ans;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}
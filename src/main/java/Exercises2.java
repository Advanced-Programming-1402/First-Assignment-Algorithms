import java.util.ArrayList;
import java.util.List;

public class Exercises2 {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
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
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I')
                ans++;
            else if (s.charAt(i) == 'V')
                ans += 5;
            else if (s.charAt(i) == 'X')
                ans += 10;
            else if (s.charAt(i) == 'L')
                ans += 50;
            else if (s.charAt(i) == 'C')
                ans += 100;
            else if (s.charAt(i) == 'D')
                ans += 500;
            else if (s.charAt(i) == 'M')
                ans += 1000;
        }
        for (int i = 0; i < (n - 1); i++) {
            if (s.charAt(i) == 'I') {
                if (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')
                    ans -= 2;
                if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')
                    ans -= 2;
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')
                    ans -= 2;
            }
            else if (s.charAt(i) == 'V') {
                if (s.charAt(i + 1) == 'X')
                    ans -= 10;
                if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')
                    ans -= 10;
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')
                    ans -= 10;
            }
            else if (s.charAt(i) == 'X') {
                if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')
                    ans -= 20;
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')
                    ans -= 20;
            }
            else if (s.charAt(i) == 'L') {
                if (s.charAt(i + 1) == 'C')
                    ans -= 100;
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')
                    ans -= 100;
            }
            else if (s.charAt(i) == 'C') {
                if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')
                    ans -= 200;
            }
            else if (s.charAt(i) == 'D') {
                if (s.charAt(i + 1) == 'M')
                    ans -= 1000;
            }
        }
        return ans;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> save = new ArrayList<Integer>();
        save.add(nums[0]);
        ans.add(save);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> save2 = new ArrayList<List<Integer>>();
            for (int j = 0; j < ans.size(); j++) {
                for (int k = 0; k <= i; k++) {
                    List<Integer> save4 = new ArrayList<Integer>();
                    for (int l = 0; l < k; l++)
                        save4.add(ans.get(j).get(l));
                    save4.add(nums[i]);
                    for (int l = k; l <= (i - 1); l++)
                        save4.add(ans.get(j).get(l));
                    save2.add(save4);
                }
            }
            ans = save2;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

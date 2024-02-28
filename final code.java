import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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

    public static int romanToInt(String s) {
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
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> save = new ArrayList<Integer>();
        save.add(nums[0]);
        ans.add(save);
        for (int i = 1; i < nums.length; i++) {
            ArrayList<ArrayList<Integer>> save2 = new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j < ans.size(); j++) {
                for (int k = 0; k <= i; k++) {
                    ArrayList<Integer> save3 = new ArrayList<Integer>();
                    save3 = (ans.get(j));
                    ArrayList<Integer> save4 = new ArrayList<Integer>();
                    for (int l = 0; l < k; l++)
                        save4.add(save3.get(l));
                    save4.add(nums[i]);
                    for (int l = k; l <= (i - 1); l++)
                        save4.add(save3.get(l));
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
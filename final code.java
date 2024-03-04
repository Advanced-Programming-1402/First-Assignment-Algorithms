import java.util.ArrayList;
import java.util.List;

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

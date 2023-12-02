import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class DP {

    static String Backpack0_1(int[] w, int s) {
        int n = w.length;
        boolean[] dp = new boolean[s + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int curr = w[i];
            for (int j = s; j >= w[i]; j--) {
                dp[j] = dp[j] || dp[j - curr];
            }
        }
        if (dp[s]) {
            return "YES";
        } else {
            return "NO";
        }
    }

    static int BackpackCost(int[] w, int[] c, int s) {
        int n = w.length;
        int[] dp = new int[s + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int curr = w[i];
            for (int j = s; j >= w[i]; j--) {
                dp[j] = max(dp[j], dp[j - curr] + c[i]);
            }
        }
        int max = 0;
        for (int i = 0; i < s + 1; i++) {
            max = max(max, dp[i]);
        }
        return max;
    }

    static void BackpackCostAnswer(int[] w, int[] c, int s) {
        int n = w.length;
        int[][] dp = new int[n + 1][s + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i - 1]) {
                    if (dp[i - 1][j - w[i - 1]] + c[i - 1] > dp[i][j]) {
                        dp[i][j] = max(dp[i][j], dp[i - 1][j - w[i - 1]] + c[i - 1]);
                    }
                }
            }
        }
        int max = 0;
        int curr = 0;
        for (int i = 0; i < s + 1; i++) {
            if (dp[n][i] > max) {
                max = max(max, dp[n][i]);
                curr = i;
            }
        }
        System.out.println(max);
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (dp[i][curr] == dp[i - 1][curr]) {
                continue;
            }
            curr -= w[i - 1];
            ans.add(i);
        }
        System.out.println(ans.size());
        for (int l : ans) {
            System.out.println(l + " ");
        }
    }
    static void LIS(int[] a) {
        int n = a.length;
        int[] p = new int[n + 1];
        int[] par = new int[n];
        Arrays.fill(p, -1);
        Arrays.fill(par, -1);
        int[] dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            int j = BinarySearch.firstMore(dp, a[i]);
            if (dp[j - 1] < a[i] && dp[j] > a[i]) {
                p[j] = i;
                par[i] = p[j - 1];
                dp[j] = a[i];
            }
        }
        for (int i = n; i >= 0; i--) {
            if (dp[i] < Integer.MAX_VALUE) {
                System.out.println(i);
                List<Integer> ans = new ArrayList<>();
                int start = p[i];
                while (start != -1) {
                    ans.add(start + 1);
                    start = par[start];
                }
                for (int j = ans.size() - 1; j >= 0; j--) {
                    System.out.print(ans.get(j) + " ");
                }
                return;
            }
        }
    }
}

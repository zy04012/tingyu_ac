package ac_.a1_100;

//
public class A_05 {
    class Solution {
        public String longestPalindrome(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            String ans = "";
            int maxLen = 0;

            for (int r=0;r<s.length();r++) {
                for (int l=0; l<=r; l++) {
                    if (s.charAt(l) == s.charAt(r)) {
                        if (l == r) {
                            dp[l][r] = true;
                        } else if (r - l == 1){
                            dp[l][r] = true;
                        } else {
                            dp[l][r] = dp[l][r] ? dp[l][r] : dp[l+1][r-1];
                        }
                    } else {
                        continue;
                    }

                    if (dp[l][r] && r-l+1 > maxLen) {
                        maxLen = r-l+1;
                        ans = s.substring(l, r+1);
                    }
                }
            }

            return ans;
        }
    }
}

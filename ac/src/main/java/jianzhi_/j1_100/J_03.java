package jianzhi_.j1_100;

import java.util.HashSet;
import java.util.Set;

public class J_03 {
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
//请找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
//
// Related Topics 数组 哈希表 排序 👍 987 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int n : nums) {
                if (set.contains(n)) {
                    return n;
                } else {
                    set.add(n);
                }
            }
            return 0;
        }
    }
}

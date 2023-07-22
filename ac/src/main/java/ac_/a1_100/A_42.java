package ac_.a1_100;

import java.util.Stack;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
public class A_42 {
    public int trap(int[] height) {
        int ans = 0;
        // 维护一个单调栈，存储可以"接到雨水"的高
        Stack<Integer> stack = new Stack<Integer>();

        int index = 0;
        while (index < height.length) {
            if (stack.empty()) {
                stack.push(index);
                index++;
                continue;
            }

            if (height[index] < height[stack.peek()]) {
                stack.push(index);
                index++;
                continue;
            }

            if (height[index] == height[stack.peek()]) {
                stack.pop();
                stack.push(index);
                index++;
                continue;
            }

            int temp = stack.pop();

            if (stack.empty()) {
                continue;
            }
            if (height[stack.peek()] > height[index]) {
                ans += (height[index] - height[temp]) * (index - stack.peek() - 1);
            } else {
                ans += (height[stack.peek()] - height[temp]) * (index - stack.peek() - 1);
            }
        }
        return ans;
    }
}

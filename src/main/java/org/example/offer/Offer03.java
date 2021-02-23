package org.example.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-02-20 16:24
 */
public class Offer03 {
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 3};

        System.out.println(findRepeatNumber3(nums));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }


    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // swap
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    // 巧妙思路
    public static int findRepeatNumber3(int[] nums) {
        // 默认是false
        boolean k[] = new boolean[nums.length];
        for (int num : nums) {
            if (k[num]) {
                return num;
            } else {
                k[num] = true;
            }
        }
        return 0;
    }

}

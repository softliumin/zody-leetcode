package org.example.leetcode.kotlin




/**
 * 移除元素
 *
 * @param nums
 * @param val
 * @return
 */
fun removeElement(nums: IntArray?, `val`: Int): Int {
    if (nums == null || nums.size == 0) {
        return 0
    }
    var j = 0
    for (i in nums.indices) {
        if (nums[i] != `val`) {
            nums[j] = nums[i]
            j++
        }
    }
    return j
}

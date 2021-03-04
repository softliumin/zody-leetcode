package main

import (
	"fmt"
	"math"
)

func main() {
	temp := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	fmt.Print(maxSubArray(temp))
}

// 最大子序合
func maxSubArray(nums []int) int {
	result := nums[0]
	sum := 0
	for _, num := range nums {
		if sum > 0 {
			sum = sum + num
		} else {
			sum = num
		}
		if sum > result {
			result = sum
		}
	}
	return result
}

func maxSubArray2(nums []int) int {
	ret := math.MinInt64
	var sum int
	for _, n := range nums {
		if sum < 0 {
			sum = 0
		}
		sum += n

		if sum > ret {
			ret = sum
		}
	}
	return ret
}

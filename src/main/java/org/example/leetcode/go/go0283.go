package main

import "fmt"

func main() {
	tt := []int{1, 0, 12, 3, 0}
	moveZeroes(tt)
	fmt.Print(1)
}

func moveZeroes(nums []int) {
	n := len(nums)
	l := 0
	r := 0
	for r < n {
		if nums[r] != 0 {
			temp := nums[l]
			nums[l] = nums[r]
			nums[r] = temp
			l++
		}
		r++
	}
}

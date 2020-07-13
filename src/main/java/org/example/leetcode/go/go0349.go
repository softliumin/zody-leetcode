package main

import "fmt"

func main() {

	var nums1 = []int{4, 9, 5}
	var nums2 = []int{9, 4, 9, 8, 4}
	var nums3 = intersection(nums1, nums2)

	fmt.Println(nums3)
}

func intersection(nums1 []int, nums2 []int) []int {
	hash := make(map[int]bool)
	res := make([]int, 0)

	for _, v := range nums1 {
		hash[v] = true
	}

	for _, v := range nums2 {
		if hash[v] == true {
			res = append(res, v)
			hash[v] = false
		}
	}
	return res
}

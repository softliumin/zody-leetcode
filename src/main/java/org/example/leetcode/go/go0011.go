package main

func main() {

}

func maxArea(height []int) int {
	l := 0
	r := len(height) - 1
	result := 0
	for l <= r {
		temp := 0
		if height[l] > height[r] {
			temp = height[r] * (r - l)
			r--
		} else {
			temp = height[l] * (r - l)
			l++
		}
		if temp > result {
			result = temp
		}
	}
	return result
}

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

func maxArea2(height []int) int {
	left, right := 0, len(height)-1
	maxContain := 0
	for left != right {
		heiLeft, heiRight := height[left], height[right]
		ContainerVal := min(heiLeft, heiRight) * (right - left)
		if ContainerVal > maxContain {
			maxContain = ContainerVal
		}
		if heiLeft > heiRight {
			right--
		} else {
			left++
		}
	}
	return maxContain
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

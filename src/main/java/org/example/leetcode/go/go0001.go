package main

import "fmt"

func main() {
	fmt.Println("22222")

	array := [5]int{1, 2, 3, 4, 5}
	fmt.Print(array[1])
}

// 声明结构
type book struct {
	name   string
	price  int
	num    int
	author string
	tt     bool
}

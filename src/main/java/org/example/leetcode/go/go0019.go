package main

func main() {

}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	//建立哨兵节点
	dummy := new(ListNode)
	dummy.Next = head
	//倒数第N个节点的前一个节点
	preN := dummy
	//记录遍历次数
	i := 1
	for head != nil {
		if i > n {
			preN = preN.Next
		}
		head = head.Next
		i++
	}
	//跨过倒数第N个节点
	preN.Next = preN.Next.Next
	//返回链表的头结点
	return dummy.Next
}

from typing import Optional
from q0_base import ListNode, append, traversal


def addTwoNumbers(l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    temp1 = l1
    temp2 = l2

    carry = 0
    ans_head = ListNode(-1)
    temp_ans = ans_head

    while temp1 or temp2:
        val_sum = carry
        if temp1:
            val_sum += temp1.val
            temp1 = temp1.next
        if temp2:
            val_sum += temp2.val
            temp2 = temp2.next
        
        carry = val_sum // 10
        temp_ans.next = ListNode(val_sum % 10)
        temp_ans = temp_ans.next

    if carry:
        temp_ans.next = ListNode(1)

    return ans_head.next     


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head1 = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head1, ListNode(numbers[j]))

    numbers = list(map(int, input().split()))
    head2 = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head2, ListNode(numbers[j]))
    head = addTwoNumbers(head1, head2)
    traversal(head)

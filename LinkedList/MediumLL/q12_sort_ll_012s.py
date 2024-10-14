from typing import Optional
from q0_base import ListNode, append, traversal


def segregate(head: ListNode) -> ListNode:
    temp = head
    count_0 = 0
    count_1 = 0
    while temp:
        if temp.val == 0:
            count_0 += 1
        elif temp.val == 1:
            count_1 += 1
        temp = temp.next

    temp = head
    while count_0 != 0:
        temp.val = 0
        count_0 -= 1
        temp = temp.next

    while count_1 != 0:
        temp.val = 1
        count_1 -= 1
        temp = temp.next

    while temp:
        temp.val = 2
        temp = temp.next
    return head


def segregateBetter(head: ListNode) -> ListNode:

    if head.next is None and head is None:
        return head
    head_0 = ListNode(-1)
    head_1 = ListNode(-1)
    head_2 = ListNode(-1)

    temp0 = head_0
    temp1 = head_1
    temp2 = head_2

    temp = head

    while (temp):
        if temp.val == 0:
            temp0.next = temp
            temp0 = temp
        elif temp.val == 1:
            temp1.next = temp
            temp1 = temp
        else:
            temp2.next = temp
            temp2 = temp
        temp = temp.next

    if head_1.next:
        temp0.next = head_1.next
    else:
        temp0.next = head_2.next
    
    if head_2.next:
        temp1.next = head_2.next
    
    temp2.next = None
    return head_0.next


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head1 = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head1, ListNode(numbers[j]))
    head = segregateBetter(head1)
    traversal(head)

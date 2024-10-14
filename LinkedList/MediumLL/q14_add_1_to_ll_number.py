from typing import Optional
from q0_base import ListNode, append, traversal

# TC = O(2N)
# Space  = O(N)


def add_1_brute(head: ListNode) -> ListNode:
    no = ''
    temp = head
    while temp:
        no += str(temp.val)
        temp = temp.next

    no = int(no) + 1
    new_head = None
    while no > 0:
        r = no % 10
        node = ListNode(r)
        node.next = new_head
        new_head = node
        no //= 10
    return new_head


def reverse(head: ListNode):
    pre = None
    curr = head
    while curr:
        front = curr.next
        curr.next = pre
        pre = curr
        curr = front
    return pre


def add_1(head: ListNode) -> ListNode:
    head = reverse(head)
    temp = head

    if temp.val == 9:
        carry = 1
    else:
        carry = 0
        temp.val += 1

    while carry and temp.next:
        if temp.val == 9:
            carry = 1
            temp.val = 0
        else:
            carry = 0
            temp.val += 1
        temp = temp.next

    if carry:
        if temp.val < 9:
            temp.val += 1
        else:
            temp.val = 0
            temp.next = ListNode(1)

    return reverse(head)


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head1 = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head1, ListNode(numbers[j]))
    head = add_1(head1)
    traversal(head)

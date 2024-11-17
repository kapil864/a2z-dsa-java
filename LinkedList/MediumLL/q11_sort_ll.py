from typing import Optional
from q0_base import ListNode, append, traversal

# use method from linked list
def merge(head1: ListNode, head2: ListNode):

    temp = ListNode(-1)
    head = temp
    while head1 and head2:

        if head1.val < head2.val:
            temp.next = head1
            temp = temp.next
            head1 = head1.next
        else:
            temp.next = head2
            temp = temp.next
            head2 = head2.next
    if head2:
        temp.next = head2
    else:
        temp.next = head1

    return head.next


def sortLL(head: ListNode):

    if head == None or head.next == None:
        return head

    fast = head.next
    mid = head
    while fast and fast.next:
        fast = fast.next.next
        mid = mid.next
    right = mid.next
    mid.next = None
    left = head
    left = sortLL(head)
    right = sortLL(right)

    return merge(left, right)


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head1 = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head1, ListNode(numbers[j]))
    head = sortLL(head1)
    traversal(head)

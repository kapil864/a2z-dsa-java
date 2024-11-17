from typing import Optional
from q0_base import ListNode, append, traversal


def isPalindromeBrute(head: Optional[ListNode]) -> bool:
    curr = head
    stk = []
    while curr:
        stk.append(curr.val)
        curr = curr.next

    curr = head
    while len(stk) != 0:
        elm = stk.pop()
        if elm != curr.val:
            return False
        curr = curr.next
    return True


def reverse_list(head: ListNode):
    pre = None
    curr = head
    while curr:
        temp = curr.next
        curr.next = pre
        pre = curr
        curr = temp
    return pre

# two pointer approach
# similar to that of tortoise and hare
# reverse only the half of linked list and check 
def isPalindrome(head: Optional[ListNode]) -> bool:
    slow = head
    fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    rev_head = reverse_list(slow)
    rev = rev_head
    while rev:
        if head.val != rev.val:
            return False
        head = head.next
        rev = rev.next
    return True


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    print(isPalindromeBrute(head))
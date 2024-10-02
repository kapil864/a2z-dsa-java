from typing import Optional
from q0_base import ListNode, append, traversal

# count nodes in list (k) then delete k-n+1 node
def removeNthFromEndBrute(head: Optional[ListNode], n: int) -> Optional[ListNode]:
    lenght = 0
    curr = head 
    while curr:
        lenght += 1
        curr = curr.next
    
    curr = head
    n = lenght-n
    for _ in range(1,n):
        curr = curr.next

    if n == 0:
        temp = head
        head = head.next
        del temp
        return head
    temp = curr.next
    curr.next = temp.next
    temp.next = None
    del temp
    return head

# use two pointers such that the diffrence between two pointes in n
# we delete the ptr1 
def removeNthFrom(head: Optional[ListNode], n: int) -> Optional[ListNode]:
    ptr1 = head
    ptr2 = head

    while n > 0:
        ptr2 = ptr2.next
        n -= 1

    if not ptr2:
        return head.next
   
    while ptr2.next:
        
        ptr1 = ptr1.next
        ptr2 = ptr2.next
    
    temp = ptr1.next
    ptr1.next = temp.next
    temp.next = None
    del temp   
    return head

if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    n  = int(input())
    head = removeNthFrom(head, n)
    traversal(head)
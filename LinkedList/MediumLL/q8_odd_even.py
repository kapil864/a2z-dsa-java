from typing import Optional
from q0_base import ListNode, append, traversal

# store elements for odd positon and even postion the fill them in the list
def oddEvenListBrute(head: Optional[ListNode]) -> Optional[ListNode]:
    odd_list = []
    even_list = []
    curr  = head
    while curr:
        odd_list.append(curr.val)
        if curr.next:
            even_list.append(curr.next.val)
            curr = curr.next.next
        else:
            break
    
    curr = head
    for val in odd_list:
        curr.val = val
        curr = curr.next
    
    for val in even_list:
        curr.val = val
        curr = curr.next
    
    return head

# Without using extra space and performing operation in place
def oddEvenList(head: Optional[ListNode]) -> Optional[ListNode]:
    if not head or  not head.next:
            return head
    even_head = head.next
    curr = head
    even_tail = even_head
    while even_tail.next:

        curr.next = even_tail.next
        curr = curr.next
        
        if curr.next:
            even_tail.next = curr.next
            even_tail = even_tail.next
        else:
            even_tail.next = None
            break
    
    curr.next = even_head
    return head



if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    head = oddEvenList(head)
    traversal(head)
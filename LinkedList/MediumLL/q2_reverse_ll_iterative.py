from q0_base import ListNode, append, traversal

def reverse_iterative(head : ListNode) :
    
    pre = None
    curr = head
    while curr:
        front = curr.next
        curr.next = pre
        pre = curr
        curr = front
    
    return pre

if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    head = reverse_iterative(head)
    traversal(head)
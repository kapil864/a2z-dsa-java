from q0_base import ListNode, append, traversal

def reverse_recursive(head : ListNode) :
    
    if head.next == None:
        return head
    temp = head.next
    reversed_list = reverse_recursive(head.next)
    temp.next = head
    head.next = None
    return reversed_list

if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    head = reverse_recursive(head)
    traversal(head)
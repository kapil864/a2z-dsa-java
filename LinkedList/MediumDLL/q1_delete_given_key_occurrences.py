from q0_base import Node, traversal, append


def deleteAllOccurOfX(head: Node, x):
    temp = head

    while temp:
        if temp.data == x:
            if temp is head:
                head = temp.next

            pre = temp.prev
            nextNode = temp.next

            if pre:
                pre.next = nextNode
            if nextNode:
                nextNode.prev = pre
            del temp
            temp = nextNode
        else:
            temp = temp.next
        
    return head


if __name__ == "__main__":

    numbers = list(map(int, input().split(' ')))
    head = Node(numbers[0])
    for i in range(1, len(numbers)):
        append(head, Node(numbers[i]))
    traversal(head)
    x = int(input())
    nhead = deleteAllOccurOfX(head, x)
    traversal(nhead)

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def deleteNode(node : ListNode):
    while node.next.next:
            node.val = node.next.val
            node = node.next
        
    node.val = node.next.val
    node.next = None
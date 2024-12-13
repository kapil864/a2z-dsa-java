from typing import List


class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def pre_order(root: Node, traversal: List):

    if root == None:
        return

    traversal.append(root.value)
    pre_order(root.left, traversal)
    pre_order(root.right, traversal)

def in_order(root: Node, traversal: List):

    if root == None:
        return

    in_order(root.left, traversal)
    traversal.append(root.value)
    in_order(root.right, traversal)

def post_order(root: Node, traversal: List):

    if root == None:
        return

    post_order(root.left, traversal)
    post_order(root.right, traversal)
    traversal.append(root.value)


if __name__ == "__main__":

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)
    traversal = []

    # pre order traversal
    pre_order(root, traversal)
    print(traversal)
    traversal = []

    # in order traversal
    in_order(root, traversal)
    print(traversal)
    traversal = []

    # post order traversal
    post_order(root, traversal)
    print(traversal)

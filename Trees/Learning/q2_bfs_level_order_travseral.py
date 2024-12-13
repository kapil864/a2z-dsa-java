from queue import Queue


class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def bfs(root: Node):

    queue = Queue()
    queue.put(root)
    traversal = []
    while not queue.empty():

        nodes = []
        size = queue.qsize()
        for _ in range(size):
            node = queue.get()
            nodes.append(node.value)
            if node.left:
                queue.put(node.left)
            if node.right:
                queue.put(node.right)
        traversal.append(nodes)
    return traversal


if __name__ == "__main__":

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    print(bfs(root))

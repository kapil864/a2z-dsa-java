from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# since height is already being calculated at every node for left and right subtree
# so calculate the diameter for that node at that time and store the maximum diameter
def helper(root, diameter):
    if root == None:
        return 0

    lh = helper(root.left, diameter)
    rh = helper(root.right, diameter)
    diameter[0] = max(diameter[0], lh+rh)
    return max(lh, rh)+1


def diameterOfBinaryTree(root: Optional[TreeNode]) -> int:
    diameter = [0]
    helper(root, diameter)
    return diameter[0]


if __name__ == "__main__":

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)

    print(diameterOfBinaryTree(root))

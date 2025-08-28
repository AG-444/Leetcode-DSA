# Last updated: 8/28/2025, 9:58:33 AM
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        def helper(node, low, high):
            if not node:
                return True
            
            # The current node's value must be between low and high
            if node.val <= low or node.val >= high:
                return False
            
            # Recursively validate the left and right subtrees
            return (helper(node.left, low, node.val) and
                    helper(node.right, node.val, high))
        
        return helper(root, float('-inf'), float('inf'))

// Last updated: 8/28/2025, 9:58:01 AM
import java.util.ArrayList;
import java.util.Collections;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int maxDepth(TreeNode root,ArrayList<Integer> l) {
        if(root==null) return 0;
        int lh = maxDepth(root.left,l);
        int rh = maxDepth(root.right,l);

        l.add(lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        maxDepth(root,l);
        return Collections.max(l);
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
*/

public class ValidateBinarySearchTree {

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("isValidBST(t1) = " + isValidBST(t1));
        printTree(t1);
        TreeNode t2 = new TreeNode(3,  new TreeNode(1),
                                            new TreeNode(4, new TreeNode(5), new TreeNode(6))  );
        System.out.println("isValidBST(t2) = " + isValidBST(t2));
    }

    private static void printTree(TreeNode tree){
        Queue<TreeNode> queue = new LinkedList();
        queue.add(tree);
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

    }

    public static boolean isValidBST(TreeNode root) {
        boolean isValid = false;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null){
                if (left.val < node.val) {
                    isValid = true;
                    queue.add(node.left);
                } else {
                    return false;
                }
            }

            if (right != null){
                if (right.val > node.val) {
                    isValid = true;
                    queue.add(node.right);
                } else {
                    return false;
                }
            }
        }
        return isValid;
    }

}

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class Leetcode144{
    public static void main(String[] args) {
        
    }


    // Preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val); // Visit root
        dfs(node.left, result); // Traverse left subtree
        dfs(node.right, result); // Traverse right subtree
    }
}
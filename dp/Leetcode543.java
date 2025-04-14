import java.util.HashMap;

public class Leetcode543 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int levels(TreeNode root){
        if(root == null)return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        HashMap<TreeNode,Integer> dp = new HashMap<>();
        return helper(root,dp);
    }

    static int helper(TreeNode root, HashMap<TreeNode,Integer> dp){
        if(root == null)return 0;
        int ll = levels(root.left) + levels(root.right);
        int dl = helper(root.left, dp);
        int dr = helper(root.right, dp);
        int ans = Math.max(ll, Math.max(dl, dr));
        dp.put(root, ans);
        return ans;   
    }



    public static void main(String[] args){

    }
    
}

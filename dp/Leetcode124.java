class Leetcode124{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int maxPathSum(TreeNode root) {
        if(root == null)return Integer.MIN_VALUE;

        int ans = root.val;
        // yadi root se hoker jaa rha hai
        int leftMax = maximumPath(root.left);
        int rigthMax = maximumPath(root.right);

        if(leftMax != Integer.MIN_VALUE && rigthMax != Integer.MIN_VALUE){
            ans = Math.max(root.val + leftMax + rigthMax,ans);
        }else{
            if(leftMax != Integer.MIN_VALUE)ans = Math.max(ans,root.val + leftMax);
            if(rigthMax != Integer.MIN_VALUE)ans = Math.max(ans, root.val + rigthMax);
        }

        ans = Math.max(ans,Math.max(maxPathSum(root.left),maxPathSum(root.right)));

        return ans;
    }

    static int maximumPath(TreeNode root){
        if(root == null)return Integer.MIN_VALUE;
        return root.val + Math.max(maximumPath(root.left), maximumPath(root.right));
    }



    public static void main(String[] args){

    }
}
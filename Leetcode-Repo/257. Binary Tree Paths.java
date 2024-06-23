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
    public List<String> binaryTreePaths(TreeNode root) {
        Stack<String> ss= new Stack<>();
        Stack<TreeNode> tree = new Stack<>();
        List<String> res=new ArrayList<>();
        tree.push(root);
        ss.push(Integer.toString(root.val));
        String s;
        TreeNode node;
        while(!tree.isEmpty()){
            node=tree.pop();
            s=ss.pop();
            if(node.right!=null){
                if(!s.isEmpty()){
                    ss.push(s+"->"+Integer.toString(node.right.val));
                }
                tree.push(node.right);
            }
            if(node.left!=null){
                if(!s.isEmpty()){
                ss.push(s+"->"+Integer.toString(node.left.val));
                }
                tree.push(node.left);
            }
            if(node.left==null && node.right==null){
                res.add(s);
            }
            s="";
        }
        return res;
    }
}
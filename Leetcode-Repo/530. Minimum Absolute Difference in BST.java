/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode tmp;
        while (!s.isEmpty()) {
            tmp = s.pop();
            l.add(tmp.val);
            if (tmp.right != null) {
                s.push(tmp.right);
            }
            if (tmp.left != null) {
                s.push(tmp.left);
            }
        }
        int ans = Integer.MAX_VALUE;
        Collections.sort(l);
        for (int i = 1; i < l.size(); i++) {
            ans = Math.min(ans, l.get(i) - l.get(i - 1));

        }
        return ans;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution2 {
    int mindiff = Integer.MAX_VALUE;
    TreeNode prev;

    public void inOrderT(TreeNode tmp) {
        if (tmp == null) {
            return;
        }
        inOrderT(tmp.left);
        if (prev != null) {
            mindiff = Math.min(mindiff, tmp.val - prev.val);
        }
        prev = tmp;
        inOrderT(tmp.right);
    }

    public int getMinimumDifference(TreeNode root) {
        inOrderT(root);
        return mindiff;
    }
}
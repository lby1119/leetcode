package leet200_299;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
class TreeNode {
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
public class leet226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()>0){
            TreeNode treeNode = queue.poll();
            if(treeNode!=null){
                TreeNode left = treeNode.left;
                treeNode.left= treeNode.right;
                treeNode.right=left;
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }

        }
        return root;
    }
}

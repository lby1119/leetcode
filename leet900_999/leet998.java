package leet900_999;

public class leet998 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(1,null,null);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(2,null,null);
        root.right.right=null;

        Solution sol=new Solution();
        sol.insertIntoMaxTree(root,5);
    }
}



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
class Solution {

    int count=0;
    int[] a=new int[100];

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        inorder(root);
        a[count]=val;

        TreeNode node=new TreeNode();
        maxNode(0,count,node);


        return node;
    }

    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);


        a[count]=root.val;
        count++;

        inorder(root.right);

    }

    public TreeNode maxNode(int left,int right,TreeNode node){
        int max=a[left];
        int k=left;


        for(int i=left;i<=right;i++){
            if(max<a[i]){
                max=a[i];
                k=i;
            }
        }




        node.val=max;
        if(k+1<=right){
            node.right=new TreeNode();
            maxNode(k+1,right,node.right);
        }

        if(left<=k-1){
            node.left=new TreeNode();
            maxNode(left,k-1,node.left);
        }



        return node;



    }

}
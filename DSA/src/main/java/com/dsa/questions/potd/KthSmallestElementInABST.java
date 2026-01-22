package com.dsa.questions.potd;

import com.dsa.questions.potd.utils.TreeNode;

public class KthSmallestElementInABST {
    private int cnt=0;
    private void inOrderTraversal(TreeNode node, int k, int ans){
        if(node == null || ans !=-1){
            return;
        }
        inOrderTraversal(node.left, k, ans);
        cnt++;
        if(cnt == k){
            ans = node.val;
            return;
        }
        inOrderTraversal(node.right, k, ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans=-1;
        inOrderTraversal(root, k, ans);
        return ans;
    }

}

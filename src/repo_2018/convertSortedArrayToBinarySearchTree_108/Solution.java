package repo_2018.convertSortedArrayToBinarySearchTree_108;

import repo_2018.commonStructure.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums){
        return convert(nums,0,nums.length-1);
    }
    public TreeNode convert(int[] nums,int start, int end){
        if (end<start) return null;
        int mid = start+(end-start+1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums,start,mid-1);
        root.right = convert(nums,mid+1,end);
        return root;
    }
}

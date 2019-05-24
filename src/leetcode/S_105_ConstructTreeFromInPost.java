package leetcode;

public class S_105_ConstructTreeFromInPost {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        	return null;
        return buildCore(preorder, 0, inorder, 0, inorder.length);
    }

	private TreeNode buildCore(int[] preorder, int pre_s, int[] inorder, int in_s, int len) {
		if(len == 0)
            return null;
        TreeNode root = new TreeNode(preorder[pre_s]);
		if(len == 1)
			return root;
		int i = 0;
		for(; i < len; i++)
			if(inorder[i+in_s] == preorder[pre_s]){
				break;
			}
		root.left = buildCore(preorder, pre_s+1, inorder, in_s, i);
		root.right = buildCore(preorder, pre_s+i+1, inorder, in_s+i+1, len - 1 - i );
		return root;
	}
}

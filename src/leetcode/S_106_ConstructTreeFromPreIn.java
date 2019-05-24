package leetcode;

public class S_106_ConstructTreeFromPreIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildCore(postorder, 0, inorder, 0, inorder.length);
    }
	private TreeNode buildCore(int[] postorder, int post_s, int[] inorder, int in_s, int len) {
		if(len == 0)
            return null;
        TreeNode root = new TreeNode(postorder[post_s+len-1]);
		if(len == 1)
			return root;
		int i = 0;
		for(; i < len; i++)
			if(inorder[i+in_s] == postorder[post_s+len-1]){
				break;
			}
		root.left = buildCore(postorder, post_s, inorder, in_s, i);
		root.right = buildCore(postorder, post_s+i, inorder, in_s+i+1, len - 1 - i );
		return root;
	}
}

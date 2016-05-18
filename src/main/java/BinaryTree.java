import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/17/16.
 */
public class BinaryTree {
    List<Integer> result = new ArrayList<Integer>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root !=null){
            helper(root);
        }

        return result;
    }

    public void helper(TreeNode p){
        if(p.left!=null)
            helper(p.left);

        result.add(p.val);

        if(p.right!=null)
            helper(p.right);
    }
}

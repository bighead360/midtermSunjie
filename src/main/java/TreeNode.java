import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/17/16.
 * Time complexity: O(logn)
 */
public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    /**
     * Constructs leaf node -- left and right are null
     */
    public TreeNode(int val) {
        this.val = val; this.left = null; this.right = null;
    }

    /**
     * Constructs inner node
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; this.left = left; this.right = right;
    }


    static List<Integer> badNodeValList = new ArrayList<Integer>();
    public static List<Integer> findBadBSTNodes(TreeNode root){

        if (root.left != null) {


            if (root.left.val > root.val) {
                badNodeValList.add(root.left.val);

            }

            if (root.right.val <= root.val) {
                badNodeValList.add(root.right.val);
            }

            findBadBSTNodes(root.left);
            findBadBSTNodes(root.right);

        }

        return badNodeValList;
    }

    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(2,
                new TreeNode(8), new TreeNode(7));
        TreeNode rightChild = new TreeNode(3,
                new TreeNode(1), new TreeNode(2));
        TreeNode tree= new TreeNode(5, leftChild,
                rightChild);

        List<Integer> badNode = new ArrayList<Integer>();
        badNode = findBadBSTNodes(tree);
        System.out.println(badNode);

    }
}

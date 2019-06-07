package datastruct;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public static final TreeNode EMPTY = new TreeNode(Integer.MIN_VALUE);

    public TreeNode(int val) {
        this.val = val;
    }


    public static final TreeNode TREE = tree();

    private static TreeNode tree() {
        TreeNode root = new TreeNode(1);
        int i = 0;
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.add(root);
//        while (i++ < 10) {
//            TreeNode node = deque.poll();
//            if(node != null) {
//                TreeNode left = new TreeNode(node.val + 1);
//                TreeNode right = new TreeNode(node.val + 2);
//                node.left = left;
//                node.right = right;
//                deque.add(left);
//                deque.add(right);
//            }
//        }
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        return root;
    }
}

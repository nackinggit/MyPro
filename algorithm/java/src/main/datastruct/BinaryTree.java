package datastruct;

public class BinaryTree {
    private Node root;

    public void addLeft(Node node) {
        if (root != null) {
            Node cur = root;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = node;
        } else {
            throw new IllegalStateException();
        }
    }

    public void addRight(Node node) {
        if (root != null) {
            Node cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = node;
        }

    }


    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}

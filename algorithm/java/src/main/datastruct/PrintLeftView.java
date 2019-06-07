package datastruct;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PrintLeftView {

    static void printLeftView(TreeNode root) {
        if (root != null) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            queue.add(TreeNode.EMPTY);
            while (!queue.isEmpty()) {
                TreeNode first = queue.poll();
                if (first != null) {
                    if (first != TreeNode.EMPTY) {
                        System.out.print(first.val);
                    } else {
                        System.out.print(", ");
                    }

                    if (first.left != null) {
                        queue.add(first.left);
                    }

                    if (first.right != null) {
                        queue.add(first.right);
                    }

                    while (true) {
                        TreeNode node = queue.poll();
                        if (node != null && node != TreeNode.EMPTY) {
//                            System.out.print(node.val);
                            if (node.left != null) {
                                queue.add(node.left);
                            }
                            if (node.right != null) {
                                queue.add(node.right);
                            }
                        } else {
//                            System.out.print(",");
                            if (!queue.isEmpty()) {
                                queue.add(TreeNode.EMPTY);
                            }
                            break;
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        printLeftView(TreeNode.TREE);
    }
}

package link;

public class Link {
    public Node root;

    public void addLast(Node node) {
        if(root == null) {
            this.root = node;
        }else {
            Node cur = root;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            node.pre = cur;
        }
    }


    public void addFirst(Node node) {
        if(root == null) {
            this.root = node;
        } else {
            Node cur = root;
            node.next = cur;
            cur.pre = node;
            root = node;
        }
    }

    public void delete(Node node) {
        if(node.next != null) {
            node.val = node.next.val;
            Node next = node.next;
            node.next = next.next;
            if(next.next != null) {
                next.next.pre = node;
            }
        } else {
            Node pre = root;
            Node cur = root;
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
        }
    }


    public static class Node<T> {
        T val;
        Node next;
        Node pre;
    }
}

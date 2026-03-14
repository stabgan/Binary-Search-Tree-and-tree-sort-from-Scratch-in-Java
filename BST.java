class Node {
    int value;
    Node left;
    Node right;

    Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

public class BST {

    Node root;

    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.value) {
            node.left = insertNode(node.left, data);
        } else if (data > node.value) {
            node.right = insertNode(node.right, data);
        }
        return node;
    }

    public void sort() {
        if (root != null) {
            inorder(root);
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.value);
            inorder(node.right);
        }
    }

    public void post() {
        if (root != null) {
            postorder(root);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.value);
        }
    }

    public boolean contains(int data) {
        return search(root, data) != null;
    }

    private Node search(Node node, int data) {
        if (node == null || node.value == data) {
            return node;
        }
        if (data < node.value) {
            return search(node.left, data);
        }
        return search(node.right, data);
    }

    public void clear() {
        root = null;
    }

    public void remove(int data) {
        root = deleteNode(root, data);
    }

    private int findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    private Node deleteNode(Node node, int data) {
        if (node == null) return node;

        if (data < node.value) {
            node.left = deleteNode(node.left, data);
        } else if (data > node.value) {
            node.right = deleteNode(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            node.value = findMin(node.right);
            node.right = deleteNode(node.right, node.value);
        }
        return node;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(23);
        tree.insert(55);
        tree.insert(22);
        tree.insert(11);
        tree.insert(401);

        System.out.println("Tree Sort (Inorder)");
        tree.sort();

        System.out.println("\nPostorder");
        tree.post();

        System.out.println("\nContains 11: " + tree.contains(11));
        System.out.println("Contains 11111: " + tree.contains(11111));

        tree.remove(23);
        System.out.println("\nTree Sort after removing 23");
        tree.sort();
    }
}

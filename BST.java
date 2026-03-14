/**
 * Binary Search Tree implementation in Java.
 * Supports insert, delete, search, in-order (tree sort), and post-order traversal.
 */
public class BST {

    /**
     * Internal node representation for the BST.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    /**
     * Inserts a value into the BST. Duplicates are ignored.
     */
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.value) {
            node.left = insertRecursive(node.left, data);
        } else if (data > node.value) {
            node.right = insertRecursive(node.right, data);
        }
        return node;
    }

    /**
     * Prints all values in sorted (in-order) order — i.e., tree sort.
     */
    public void sort() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.value);
            inorder(node.right);
        }
    }

    /**
     * Prints all values in post-order (left, right, root).
     */
    public void postOrder() {
        postOrderRecursive(root);
    }

    // BUG FIX: original code called inorder() here instead of postorder recursion
    private void postOrderRecursive(Node node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.println(node.value);
        }
    }

    /**
     * Returns true if the BST contains the given value.
     */
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

    /**
     * Removes all nodes from the tree.
     */
    public void clear() {
        root = null;
    }

    /**
     * Removes a value from the BST (no-op if not found).
     */
    public void remove(int data) {
        root = deleteRecursive(root, data);
    }

    private int findMin(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            node = node.left;
            minValue = node.value;
        }
        return minValue;
    }

    private Node deleteRecursive(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.value) {
            node.left = deleteRecursive(node.left, data);
        } else if (data > node.value) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Node with two children: replace with in-order successor
            node.value = findMin(node.right);
            node.right = deleteRecursive(node.right, node.value);
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

        System.out.println("Tree Sort (In-Order):");
        tree.sort();

        System.out.println("\nPost-Order Traversal:");
        tree.postOrder();

        System.out.println("\nContains 11: " + tree.contains(11));
        System.out.println("Contains 11111: " + tree.contains(11111));

        tree.remove(23);
        System.out.println("\nTree Sort after removing 23:");
        tree.sort();
    }
}

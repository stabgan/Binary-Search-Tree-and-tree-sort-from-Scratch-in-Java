# 🌳 Binary Search Tree & Tree Sort from Scratch in Java

A clean, from-scratch implementation of a Binary Search Tree (BST) in Java, featuring insertion, deletion, search, in-order traversal (tree sort), and post-order traversal.

---

## 📖 What is a Binary Search Tree?

A Binary Search Tree is a node-based data structure where each node follows these rules:

- The left subtree of a node contains only values **less than** the node's value.
- The right subtree of a node contains only values **greater than** the node's value.
- Both left and right subtrees are also valid BSTs.

This property makes search, insertion, and deletion efficient — averaging **O(log n)** time complexity, though worst-case (skewed tree) degrades to **O(n)**.

**Tree Sort** leverages the BST's in-order traversal (left → root → right) to output elements in sorted order.

```
        50
       /  \
      23    55
     /        \
    22        401
   /
  11
```

### Supported Operations

| Operation | Average | Worst |
|-----------|---------|-------|
| Insert    | O(log n) | O(n) |
| Search    | O(log n) | O(n) |
| Delete    | O(log n) | O(n) |
| Tree Sort | O(n)     | O(n) |

---

## 🛠️ Tech Stack

| | Technology |
|---|---|
| ☕ | Java (JDK 11+) |
| 🧱 | No external dependencies — pure standard library |

---

## 🚀 How to Compile and Run

Make sure you have the JDK installed (`java --version` to check).

```bash
# Compile
javac BST.java

# Run
java BST
```

### Expected Output

```
Tree Sort (Inorder)
11
22
23
50
55
401

Postorder
11
22
23
401
55
50

Contains 11: true
Contains 11111: false

Tree Sort after removing 23
11
22
50
55
401
```

---

## 🐛 Known Issues

- Duplicate values are silently ignored (not inserted).
- No self-balancing — inserting sorted data produces a degenerate (linked-list-like) tree with O(n) operations.
- `Node` class is package-private; not designed for use as a library.

---

## 📄 License

[MIT](LICENSE)

# Binary Search Tree & Tree Sort from Scratch in Java

A clean, from-scratch implementation of a Binary Search Tree (BST) in Java — with insert, delete, search, in-order traversal (tree sort), and post-order traversal.

## What It Does

Implements a BST that supports:

- **Insert** — adds a value (duplicates ignored)
- **Delete** — removes a value using in-order successor replacement
- **Search / Contains** — checks if a value exists in the tree
- **Tree Sort** — prints all values in ascending order via in-order traversal
- **Post-Order Traversal** — visits left → right → root

### Example Output

```
Tree Sort (In-Order):
11 22 23 50 55 401

Post-Order Traversal:
11 22 23 401 55 50

Contains 11: true
Contains 11111: false

Tree Sort after removing 23:
11 22 50 55 401
```

## 🛠 Tech Stack

| Tool | Purpose |
|------|---------|
| ☕ Java | Language |
| 🌳 BST | Data structure (from scratch, no libraries) |

## How to Run

```bash
javac BST.java
java BST
```

Requires Java 11+ (uses `var` for local variable type inference).

## Bugs Fixed in This Revision

| Bug | Fix |
|-----|-----|
| `postorder()` called `inorder()` recursively — produced wrong traversal | Fixed to call `postOrderRecursive()` correctly |
| Two top-level classes both named `BST` — won't compile | Merged into single `public class BST` with `Node` as static inner class |
| `contains()` returned `void` and printed result | Now returns `boolean` |
| Helper methods (`searchhelper`, `_delete`, `_min`) were public | Made `private`; renamed to Java conventions (`search`, `deleteRecursive`, `findMin`) |

## License

MIT

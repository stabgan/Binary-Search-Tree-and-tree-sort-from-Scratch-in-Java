class Node{
    int value;
    Node left;
    Node right;

    Node(int data){
      this.value = data;
      this.left = null;
      this.right = null;
    }
}

class BST {

    Node root;

    public void insert(int data){
      root = update(root,data);
    }

    public Node update(Node root, int data){
      var temp = new Node(data);
      if (root == null){
        root = temp;
      }
      else {
        if( data < root.value){
          root.left = update(root.left,data);
        }
        else if ( data > root.value){
          root.right = update(root.right,data);
        }
      }

      return root;
    }

    public void sort(){
      if (root != null){
        inorder(root);
      }
    }

    public void inorder(Node root){
        if(root != null){
          inorder(root.left);
          System.out.println(root.value);
          inorder(root.right);
        }
      }
    
    public void post(){
      if (root != null){
        postorder(root);
      }
    }

    public void postorder(Node root){
        if(root != null){
          inorder(root.left);
          inorder(root.right);
          System.out.println(root.value);
        }
      }

    public void contains(int data){
      System.out.println(searchhelper(root, data) != null);
    }


    public Node searchhelper(Node root, int data){
      if(root == null || root.value == data){
        return root;
      }
      else {
        if (data < root.value ){
        return searchhelper(root.left , data);
        }
        else {
        return searchhelper(root.right, data);
        }
      }
    }

    public void clear(){
      root = null;
    }

    public void remove(int data){
      root = _delete(root , data);
      }
    
    private int _min(Node root) 
    { 
        int minv = root.value; 
        while (root.left != null) 
        { 
          root = root.left; 
        } 
        minv = root.value; 
        return minv; 
    } 
    
    public Node _delete(Node root ,int data){
      if (root == null)  return root; 
      if (data < root.value ){
        root.left =  _delete(root.left , data);
        }
      else if(data > root.value){
        root.right = _delete(root.right, data);
        }
      else {
        if (root.left == null) 
            return root.right; 
        else if (root.right == null) 
            return root.left; 

        root.value = _min(root.right); 
        root.right = _delete(root.right, root.value); 
      }

      return root;
    }
    
}

public class BST {

  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(50);
    tree.insert(23);
    tree.insert(55);
    tree.insert(22);
    tree.insert(11);
    tree.insert(401);
    System.out.println("\nTree Sort\n");
    tree.sort();
    System.out.println("\nPostorder\n");
    tree.post();
    tree.contains(11);
    tree.contains(11111);
    tree.remove(23);
    System.out.println("\nTree Sort\n");
    tree.sort();
  }
}

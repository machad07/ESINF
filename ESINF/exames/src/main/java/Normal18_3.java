// Java program to find distance between  
// two nodes in BST  
class GfG {

    static class Node {
        Node left, right;
        int key;
    }

    static Node newNode(int key)
    {
        Node ptr = new Node();
        ptr.key = key;
        ptr.left = null;
        ptr.right = null;
        return ptr;
    }

    // Standard BST insert function
    static Node insert(Node root, int key)
    {
        if (root == null)
            root = newNode(key);
        else if (root.key > key)
            root.left = insert(root.left, key);
        else if (root.key < key)
            root.right = insert(root.right, key);
        return root;
    }

    // This function returns distance of x from
// root. This function assumes that x exists  
// in BST and BST is not NULL.  
    static int distanceFromRoot(Node root, int x)
    {
        if (root.key == x)
            return 0;
        else if (root.key > x)
            return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }

    // Returns minimum distance beween a and b.
// This function assumes that a and b exist  
// in BST.  
    static int distanceBetween2(Node root, int a, int b)
    {
        if (root == null)
            return 0;

        // Both keys lie in left
        if (root.key > a && root.key > b)
            return distanceBetween2(root.left, a, b);

        // Both keys lie in right
        if (root.key < a && root.key < b) // same path
            return distanceBetween2(root.right, a, b);

        // Lie in opposite directions (Root is
        // LCA of two nodes)
        if (root.key >= a && root.key <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);

        return 0;
    }

    // This function make sure that a is smaller
// than b before making a call to findDistWrapper()  
    static int findDistWrapper(Node root, int a, int b)
    {
        int temp = 0;
        if (a > b)
        {
            temp = a;
            a = b;
            b = temp;
        }
        return distanceBetween2(root, a, b);
    }

    // Driver code
    public static void main(String[] args)
    {
        Node root = null;
        root = insert(root, 65);
        insert(root, 65);
        insert(root, 54);
        insert(root, 19);
        insert(root, 60);
        insert(root, 8);
        insert(root, 35);
        insert(root, 85);
        insert(root, 80);
        insert(root, 89);
        insert(root, 70);
        insert(root, 83);
        System.out.println(findDistWrapper(root, 70, 83));
        System.out.println(distanceFromRoot(root,80));
    }
}  
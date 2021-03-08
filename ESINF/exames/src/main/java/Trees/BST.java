package Trees;


import java.util.*;


/**
 * The type Bst.
 *
 * @param <E> the type parameter
 */
public class BST<E extends Comparable<E>> implements BSTInterface<E> {


    /**
     * The type Node.
     *
     * @param <E> the type parameter
     */
    protected static class Node<E> {
        private E element;          // an element stored at this node
        private Node<E> left;       // a reference to the left child (if any)
        private Node<E> right;      // a reference to the right child (if any)

        /**
         * Instantiates a new Node.
         *
         * @param e          the e
         * @param leftChild  the left child
         * @param rightChild the right child
         */
        public Node(E e, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            left = leftChild;
            right = rightChild;
        }

        /**
         * Gets element.
         *
         * @return the element
         */
// accessor methods
        public E getElement() { return element; }

        /**
         * Gets left.
         *
         * @return the left
         */
        public Node<E> getLeft() { return left; }

        /**
         * Gets right.
         *
         * @return the right
         */
        public Node<E> getRight() { return right; }

        /**
         * Sets element.
         *
         * @param e the e
         */
// update methods
        public void setElement(E e) { element = e; }

        /**
         * Sets left.
         *
         * @param leftChild the left child
         */
        public void setLeft(Node<E> leftChild) { left = leftChild; }

        /**
         * Sets right.
         *
         * @param rightChild the right child
         */
        public void setRight(Node<E> rightChild) { right = rightChild; }

        /**
         * Print.
         */
        public void print() {
            print("", this, false);
        }

        /**
         * Print.
         *
         * @param prefix the prefix
         * @param n      the n
         * @param isLeft the is left
         */
        public void print(String prefix, Node n, boolean isLeft) {
            if (n != null) {
                System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.element);
                print(prefix + (isLeft ? "|   " : "    "), n.left, true);
                print(prefix + (isLeft ? "|   " : "    "), n.right, false);
            }
        }
    }

    //----------- end of nested Node class -----------

    /**
     * The Root.
     */
    protected Node<E> root = null;     // root of the tree


    /**
     * Instantiates a new Bst.
     */
    /* Constructs an empty binary search tree. */
    public BST() {
        root = null;
    }

    /**
     * Root node.
     *
     * @return the node
     */
    /*
     * @return root Node of the tree (or null if tree is empty)
     */
    protected Node<E> root() {
        return root;
    }

    /*
     * Verifies if the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty(){
        return root==null;
    }

    /*
     * Inserts an element in the tree.
     */
    public void insert(E element){
        root = insert(element,root);
    }

    private Node<E> insert(E element, Node<E> node){
        if (node==null){
            return new Node(element,null,null);
        }
        if (node.getElement().compareTo(element)==0){
            node.setElement(element);
        }else if (element.compareTo(node.getElement())<0){
            node.setLeft(insert(element,node.getLeft()));
        }else{
            node.setRight(insert(element,node.getRight()));
        }
        return node;
    }

    public void remove(E element){
        root = remove(element, root());
    }

    private Node<E> remove(E element, Node<E> node) {

        if (node == null) {
            return null;    //throw new IllegalArgumentException("Informacao.Element does not exist");
        }
        if (element.compareTo(node.getElement())==0) {
            // node is the Node to be removed
            if (node.getLeft() == null && node.getRight() == null) { //node is a leaf (has no childs)
                return null;
            }
            if (node.getLeft() == null) {   //has only right child
                return node.getRight();
            }
            if (node.getRight() == null) {  //has only left child
                return node.getLeft();
            }
            E min = smallestElement(node.getRight());
            node.setElement(min);
            node.setRight(remove(min, node.getRight()));
        }
        else if (element.compareTo(node.getElement()) < 0)
            node.setLeft( remove(element, node.getLeft()) );
        else
            node.setRight( remove(element, node.getRight()) );

        return node;
    }

    /*
     * Returns the number of nodes in the tree.
     * @return number of nodes in the tree
     */
    public int size(){
        return size(root);
    }

    private int size(Node<E> node){
        if (node==null){
            return 0;
        }



        return size(node.left)+ 1 + size(node.right);

    }

    /*
     * Returns the height of the tree
     * @return height
     */
    public int height(){

        return height(root);
    }

    /**
     * Height int.
     *
     * @param node the node
     * @return the int
     */
    /*
     * Returns the height of the subtree rooted at Node node.
     * @param node A valid Node within the tree
     * @return height
     */
    protected int height(Node<E> node){
        if (node==null){
            return -1;
        }
        return 1+ Math.max(height(node.left),height(node.right));
    }

    public E smallestElement(){
        return smallestElement(root);
    }

    /**
     * Smallest element e.
     *
     * @param node the node
     * @return the e
     */
    protected E smallestElement(Node<E> node){
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }

    /**
     * Returns the Node containing a specific Element, or null otherwise.
     *
     * @param node    the node
     * @param element the element to find
     * @return the Node that contains the Element, or null otherwise <p> This method despite not being essential is very useful. It is written here in order to be used by this class and its subclasses avoiding recoding. So its access level is protected
     */
    protected Node<E> find(Node<E> node, E element) {
        if (node == null) return null;
        if (node.element.compareTo(element) == 0) {
            return node;
        } else if (node.element.compareTo(element) > 0) {
            return find(node.left, element);
        } else {
            return find(node.right, element);
        }
    }

    /**
     * Depth of node int.
     *
     * @param element the element
     * @return the int
     */
    public int depthOfNode(E element){
        return dephtOfNode(root,element,0);
    }

    /**
     * Depht of node int.
     *
     * @param node    the node
     * @param element the element
     * @param number  the number
     * @return the int
     */
    protected int dephtOfNode(Node<E> node,E element,int number){
        if (node == null) return -1;
        if (node.element.compareTo(element)==0){
            return number;

        }else if (node.element.compareTo(element)<0){
            return dephtOfNode(node.left,element,number+1);
        }else {
            return dephtOfNode(node.right,element,number+1);
        }
    }


    /*
     * Returns an iterable collection of elements of the tree, reported in in-order.
     * @return iterable collection of the tree's elements reported in in-order
     */
    public Iterable<E> inOrder(){
        List<E> snapshot = new ArrayList<>();
        if (root!=null)
            inOrderSubtree(root, snapshot);   // fill the snapshot recursively
        return snapshot;
    }
    private void inOrderSubtree(Node<E> node, List<E> snapshot) {
        if (node == null)
            return;
        inOrderSubtree(node.getLeft(), snapshot);
        snapshot.add(node.getElement());
        inOrderSubtree(node.getRight(), snapshot);
    }
    public Iterable<E> preOrder(){
        ArrayList<E> toReturn  = new ArrayList<>();

        preOrderSubtree(root,toReturn);


        return toReturn;

    }
    private void preOrderSubtree(Node<E> node, List<E> snapshot) {

        if(node==null){
            return;
        }
        snapshot.add(node.element);
        preOrderSubtree(node.getLeft(), snapshot);
        preOrderSubtree(node.getRight(),snapshot);
    }
    public Iterable<E> posOrder(){
        ArrayList<E> toReturn=new ArrayList<>();
        posOrderSubtree(root,toReturn);
        return toReturn;
    }
    private void posOrderSubtree(Node<E> node, List<E> snapshot) {
        if (node == null) return;
        posOrderSubtree(node.left, snapshot);
        posOrderSubtree(node.right, snapshot);
        snapshot.add(node.element);
    }

    /*
     * Returns a map with a list of nodes by each tree level.
     * @return a map with a list of nodes by each tree level
     */
    public Map<Integer,List<E>> nodesByLevel(){
        Map<Integer,List<E>> toReturn = new LinkedHashMap<>();
        processBstByLevel(root,toReturn,0);

        return toReturn;
    }

    private void processBstByLevel(Node<E> node, Map<Integer,List<E>> result, int level){

        if (node == null) return;

        List<E> nodeList = result.get(level);
        if (nodeList == null) nodeList = new ArrayList<>();

        nodeList.add(node.element);
        result.put(level, nodeList);
        processBstByLevel(node.left, result, level + 1);
        processBstByLevel(node.right, result, level + 1);

    }

    private Node<E> LCA (Node<E> root, E e1, E e2){
        if (root == null)
            return root;
        if (root.element == e1 || root.element == e2)
            return root;

        Node<E> left = LCA(root.left, e1, e2);
        Node<E> right = LCA(root.right, e1, e2);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        if (left != null)
            return LCA(root.left, e1, e2);
        else
            return LCA(root.right, e1, e2);
    }
    private int findLevel (Node<E> root,E e, int level){
        if (root == null)
            return -1;
        if (root.element == e)
            return level;
        int left = findLevel(root.left, e, level + 1);
        if (left == -1)
            return findLevel(root.right,e, level + 1);
        return left;
    }

    /**
     * Find distance int.
     *
     * @param e1 the e 1
     * @param e2 the e 2
     * @return the int
     */
    protected int findDistance(E e1,E e2){
        Node<E> lca = LCA(root, e1, e2);

        int d1 = findLevel(lca, e1, 0);
        int d2 = findLevel(lca,e2, 0);

        return d1 + d2;
    }

//#########################################################################

    public String toString(){
        StringBuilder sb = new StringBuilder();
        toStringRec(root, 0, sb);
        return sb.toString();
    }

    private void toStringRec(Node<E> root, int level, StringBuilder sb){
        if(root==null)
            return;
        toStringRec(root.getRight(), level+1, sb);
        if (level!=0){
            for(int i=0;i<level-1;i++)
                sb.append("|\t");
            sb.append("|-------"+root.getElement()+"\n");
        }
        else
            sb.append(root.getElement()+"\n");
        toStringRec(root.getLeft(), level+1, sb);
    }
    public Object findLCA(Set<E> elements) {
        if (root == null) {
            return null;
        }
        return findLCA(elements, root);
    }

    private E findLCA(Set<E> elements, Node<E> node) {
        int right = 0;
        int left = 0;
        for (E element : elements) {
            int comp = element.compareTo(node.getElement());
            if (comp < 0) {
                left++;
            } else if (comp > 0) {
                right++;
            } else {
                return node.getElement();
            }
        }
        if (right != 0 && left == 0) {
            return findLCA(elements, node.getRight());
        } else if (right == 0 && left != 0) {
            return findLCA(elements, node.getLeft());
        }
        return node.getElement();
} //----------- end of BST class -----------
}







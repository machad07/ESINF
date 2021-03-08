
package Trees;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * The type Tree.
 *
 * @param <E> the type parameter
 */
public class TREE<E extends Comparable<E>> extends BST<E>{

    /**
     * Contains boolean.
     *
     * @param element the element
     * @return the boolean
     */
    /*
   * @param element A valid element within the tree
   * @return true if the element exists in tree false otherwise
   */   
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /**
     * Is leaf boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean isLeaf(E element){
            throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Ascdes iterable.
     *
     * @return the iterable
     */
    /*
   * build a list with all elements of the tree. The elements in the 
   * left subtree in ascending order and the elements in the right subtree 
   * in descending order. 
   *
   * @return    returns a list with the elements of the left subtree 
   * in ascending order and the elements in the right subtree is descending order.
   */
    public Iterable<E> ascdes(){
            throw new UnsupportedOperationException("Not supported yet.");
    }

    private void ascSubtree(Node<E> node, List<E> snapshot) {
            throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void desSubtree(Node<E> node, List<E> snapshot) {
            throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Autumn tree bst.
     *
     * @return the bst
     */
    public BST<E> autumnTree() {
           throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node<E> copyRec(Node<E> node){
           throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Num nodes by level int [ ].
     *
     * @return the int [ ]
     */
    public int[] numNodesByLevel(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void numNodesByLevel(Node<E> node, int[] result, int level){
        throw new UnsupportedOperationException("Not supported yet.");
    }



}

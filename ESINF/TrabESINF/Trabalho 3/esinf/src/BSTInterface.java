/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.Map;

/**
 * The interface Bst interface.
 *
 * @param <E> the type parameter
 * @author DEI -ESINF
 */
public interface BSTInterface<E> {

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty();

    /**
     * Insert.
     *
     * @param element the element
     */
    public void insert(E element);

    /**
     * Remove.
     *
     * @param element the element
     */
    public void remove(E element);

    /**
     * Size int.
     *
     * @return the int
     */
    public int size();

    /**
     * Height int.
     *
     * @return the int
     */
    public int height();

    /**
     * Smallest element e.
     *
     * @return the e
     */
    public E smallestElement();

    /**
     * In order iterable.
     *
     * @return the iterable
     */
    public Iterable<E> inOrder();

    /**
     * Pre order iterable.
     *
     * @return the iterable
     */
    public Iterable<E> preOrder();

    /**
     * Pos order iterable.
     *
     * @return the iterable
     */
    public Iterable<E> posOrder();

    /**
     * Nodes by level map.
     *
     * @return the map
     */
    public Map<Integer,List<E>> nodesByLevel();
    
}

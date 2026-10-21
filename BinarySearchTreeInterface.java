package org.csu.cpsc;

import java.util.List;

/**
 * The operations a BinarySearchTree supports.
 *
 * Every traversal returns the values separated by single spaces
 * (for example "1 3 5 8 10 12 13 15"). A leading space is fine; the tests trim the result.
 * An empty tree returns an empty String.
 */
public interface BinarySearchTreeInterface<E extends Comparable<E>> {

    // ---- Provided for you (see how they are written!) ----

    /**
     * Adds the value to the tree in its sorted position.
     * Returns true if the value was added, or false if the tree already had that value
     * (duplicates are not added). Throws a NullPointerException if data is null.
     */
    boolean add(E data);

    /** Left subtree, then the node, then the right subtree. In a search tree this is sorted order. */
    String inOrderTraversal();

    /** All of the values in sorted order, as a List. Handy for the bonus. */
    List<E> toSortedList();

    // ---- Building the tree ----

    /**
     * Adds every value in the list to the tree, in the order they appear in the list.
     * Returns how many values were actually added. Duplicates (and values the tree
     * already had) are skipped, so they are not counted.
     */
    int addAll(List<E> values);

    // ---- Traversals ----

    /** The node, then the left subtree, then the right subtree. */
    String preOrderTraversal();

    /** Left subtree, then right subtree, then the node. */
    String postOrderTraversal();

    // ---- Measuring the tree ----

    /** The number of nodes in the tree. An empty tree has size 0. */
    int size();

    /**
     * The height of the tree, measured in branches (edges) on the longest path
     * from the root down to a leaf. A tree with only a root has height 0.
     * An empty tree has height -1.
     */
    int height();

    /** The number of leaves (nodes with no children). An empty tree has 0 leaves. */
    int countLeaves();

    // ---- Classifying the tree ----

    /**
     * True if every node has exactly 0 or 2 children.
     * An empty tree counts as full.
     */
    boolean isFull();

    /**
     * True if every internal node has exactly 2 children AND all leaves are on the same level.
     * An empty tree counts as perfect.
     */
    boolean isPerfect();

    // ---- Searching ----

    /** True if the tree has the value, false if it does not. */
    boolean contains(E data);

    /** The smallest value in the tree. Throws a NoSuchElementException if the tree is empty. */
    E findMin();

    /** The largest value in the tree. Throws a NoSuchElementException if the tree is empty. */
    E findMax();

    // ---- BONUS (10 points) ----

    /**
     * Rearranges the tree so that it has the smallest height possible for the number of
     * values it holds. The values, and the tree's sorted order, must not change.
     */
    void rebalanceTree();
}

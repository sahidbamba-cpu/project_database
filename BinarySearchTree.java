package org.csu.cpsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeInterface<E> {
    private Node<E> root;
    private boolean added;

    /** Creates an empty tree. */
    public BinarySearchTree() {
        root = null;
    }

    // ------------------------------------------------------------------
    // Provided for you. Study how these work before you start!
    // ------------------------------------------------------------------

    @Override
    public boolean add(E data) {
        Objects.requireNonNull(data, "data cannot be null");
        added = false;
        root = addRecursive(new Node<>(data), root);
        return added;
    }

    private Node<E> addRecursive(Node<E> newNode, Node<E> current) {
        if (current == null) {
            added = true;
            return newNode;
        }

        int comparison = newNode.compareTo(current);
        if (comparison < 0) {
            current.left = addRecursive(newNode, current.left);
        } else if (comparison > 0) {
            current.right = addRecursive(newNode, current.right);
        }

        return current;
    }

    @Override
    public String inOrderTraversal() {
        return inOrderTraversalRecursive(root);
    }

    private String inOrderTraversalRecursive(Node<E> current) {
        if (current == null) {
            return "";
        } else {
            return inOrderTraversalRecursive(current.left) + " " + current.data + inOrderTraversalRecursive(current.right);
        }
    }

    @Override
    public List<E> toSortedList() {
        List<E> result = new ArrayList<>();
        toSortedListRecursive(root, result);
        return result;
    }

    private void toSortedListRecursive(Node<E> current, List<E> result) {
        if (current != null) {
            toSortedListRecursive(current.left, result);
            result.add(current.data);
            toSortedListRecursive(current.right, result);
        }
    }

    // ------------------------------------------------------------------
    // COMPLETE ALL METHODS LISTED BELOW
    //
    // You may add private helper methods. Do NOT change the public methods' signatures. These match the interface
    // ------------------------------------------------------------------

    // ---- Building ----

    @Override
    public int addAll(List<E> values) {
        // TODO: add every value in the list (in order) and return how many were actually added

        int index= 0;
        int max= values.size();
        int count= 0;

        while(index < max){
            if(add(values.get(index))){
                count++;
            }
            index++;
        }
        return count;
    }

    // ---- Traversals ----

    @Override
    public String preOrderTraversal() {
        // TODO: return the values using a preorder traversal
        preOrderTraversalRecursive(root);
    }

    private String preOrderTraversalRecursive(Node<E> current) {
        if(current == null) {
            return "";
        }else{
            return  " " + current.data + postOrderTraversalRecursive(current.left) + preOrderTraversalRecursive(current.right);
            }
        }
    }

    @Override
    public String postOrderTraversal() {
        // TODO: return the values using a postorder traversal
        postOrderTraversalRecursive(root);
    }

    private String postOrderTraversalRecursive(Node<E> current) {
        if(current == null) {
            return "";
        }else{
            return  " " + postOrderTraversalRecursive(current.left) + postOrderTraversalRecursive(current.right) + current.data;
        }
    }


    // ---- Measuring ----

    @Override
    public int size() {
        // TODO: count the nodes
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node<E> current) {
        if (current == null) {
            return 0;
        } else {
            return 1 + sizeRecursive(current.left) + sizeRecursive(current.right);
        }
    }

    @Override
    public int countLeaves() {
        // TODO: count the nodes that have no children
        return countLeavesRecursive(root);
    }

    private int countLeavesRecursive(Node<E> current) {
        if (current == null) {
            return 0;
        }

        if (current.left == null && current.right == null) {
            return 1;
        }
        return countLeavesRecursive(current.left)
                + countLeavesRecursive(current.right);
    }


    @Override
    public int height() {
        // TODO: return the number of branches on the longest path from the root to a leaf
        // Remember: a lone root has height 0 and an empty tree has height -1
      return heightRecursive(root);
    }

    private int heightRecursive(Node<E> current) {
        if (current == null) {
            return -1;
        } else {
            return 1 + Math.max(heightRecursive(current.left), heightRecursive(current.right));
        }
    }

    // ---- Classifying ----

    @Override
    public boolean isFull() {
        // TODO: true if every node has exactly 0 or 2 children
        throw new UnsupportedOperationException("TODO: isFull is not implemented yet");
    }

    @Override
    public boolean isPerfect() {
        // TODO: true if every internal node has 2 children AND all leaves are on the same level
        // Hint: a perfect tree of height h has exactly 2^(h+1) - 1 nodes. Consider your other methods.
        throw new UnsupportedOperationException("TODO: isPerfect is not implemented yet");
    }

    // ---- Searching ----

    @Override
    public boolean contains(E data) {
        // TODO: true if the tree has the value, false if it does not
        // Hint: look at how add decides whether to go left or right. You do not need to look at every node.
        throw new UnsupportedOperationException("TODO: contains is not implemented yet");
    }

    @Override
    public E findMin() {
        // TODO: return the smallest value. Throw a NoSuchElementException (java.util) if the tree is empty
        // Hint: consider the properties of how a node is added. you do not need to look at every node.
        throw new UnsupportedOperationException("TODO: findMin is not implemented yet");
    }

    @Override
    public E findMax() {
        // TODO: return the largest value. Throw a NoSuchElementException (java.util) if the tree is empty
        // Hint: you do not need to look at every node.
        throw new UnsupportedOperationException("TODO: findMax is not implemented yet");
    }

    // ---- BONUS (10 points) ----

    @Override
    public void rebalanceTree() {
        // BONUS TODO: rearrange the tree so that it has the smallest height possible for its values.
    }

    // ------------------------------------------------------------------

    private static class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        /** Compares two nodes by looking only at their data. */
        @Override
        public int compareTo(Node<E> other) {
            return this.data.compareTo(other.data);
        }
    }
}
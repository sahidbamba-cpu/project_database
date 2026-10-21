package org.csu.cpsc;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ---------------- Part 1: the sample tree ----------------
        //
        //            10
        //          /    \
        //         5      12
        //        / \       \
        //       1   8       15
        //        \          /
        //         3        13
        //
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println("=== Sample tree ===");
        System.out.println(bst.add(10)); // true
        bst.add(5);
        bst.add(1);
        bst.add(3);
        bst.add(8);
        bst.add(12);
        bst.add(15);
        bst.add(13);
        System.out.println(bst.add(5)); // false: 5 is already in the tree

        System.out.println(bst.inOrderTraversal());   // 1 3 5 8 10 12 13 15
        System.out.println(bst.preOrderTraversal());  // 10 5 1 3 8 12 15 13
        System.out.println(bst.postOrderTraversal()); // 3 1 8 5 13 15 12 10
        System.out.println(bst.size());               // 8
        System.out.println(bst.height());             // 3
        System.out.println(bst.countLeaves());        // 3
        System.out.println(bst.isFull());             // false
        System.out.println(bst.isPerfect());          // false
        System.out.println(bst.contains(8));          // true
        System.out.println(bst.contains(9));          // false
        System.out.println(bst.findMin());            // 1
        System.out.println(bst.findMax());            // 15

        // ---------------- Part 2: YOUR tree ----------------
        //
        // TODO: Pick a topic of your own (movies, bands, foods, cities, video game characters...).
        //Choose AT LEAST 12 different Strings and add them to the tree with addAll.
        //The ORDER you list them in changes the shape of your tree, so choose it on purpose.
        System.out.println("The list of strings that i have chose are: New York, Georgia, Alabama, California, Texas, Florida, Virginia, Ohio, Michigan, Arizona, Colorado, and Nevada.");
        

        // TODO: Draw the tree that results as a comment here, the way the sample tree is drawn above.
        //       Write the order you added the values in, too.
        //
        //               New York
        //          /                \
        //        Georgia            Texas
        //        /      \           /     \
        //    Alabama     Michigan  ohio   virginia
        //      \            /
        //    california    Florida
        //      /            /
        //   Arizona       colorado
        //                   \
        //                  Nevada
        // TODO: Replace the empty List below with your values.
        BinarySearchTree<String> myTree = new BinarySearchTree<>();
        myTree.addAll(List.of("New York", "Georgia", "Alabama", "California",
                "Texas", "Florida", "Virginia", "Ohio",
                "Michigan", "Arizona", "Colorado", "Nevada"));

        System.out.println();
        System.out.println("=== My tree: TODO write your topic here ===");
        System.out.println(myTree.inOrderTraversal());
        System.out.println(myTree.preOrderTraversal());
        System.out.println(myTree.postOrderTraversal());
        System.out.println(myTree.size());
        System.out.println(myTree.height());
        System.out.println(myTree.countLeaves());
        System.out.println(myTree.isFull());
        System.out.println(myTree.isPerfect());
        System.out.println(myTree.contains("TODO a value that IS in your tree"));
        System.out.println(myTree.contains("TODO a value that is NOT in your tree"));
        System.out.println(myTree.findMin());
        System.out.println(myTree.findMax());

        // ---------------- Bonus: rebalanceTree ----------------
        //
        // Adding values that are already in order builds a chain, the tallest tree possible.
        // Until you write rebalanceTree, the height will not change. (Skip this if you are not doing the bonus.)
        //
        BinarySearchTree<Integer> chain = new BinarySearchTree<>();
        for (int i = 1; i <= 7; i++) {
            chain.add(i);
        }

        System.out.println();
        System.out.println("=== Bonus: rebalanceTree ===");
        System.out.println(chain.height());           // 6
        chain.rebalanceTree();
        System.out.println(chain.height());           // 2
        System.out.println(chain.isPerfect());        // true
        System.out.println(chain.inOrderTraversal()); // 1 2 3 4 5 6 7
    }
}

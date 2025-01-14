package com.algo.tree.bst;

import com.algo.tree.Node;
import com.algo.tree.TreeUtil;

public class BST {

    public static void main(String[] args) {

        Node root = null;
        root = insertRecursively(root, new Node(8));
        //root = insertRecursively(root, new Node(50));
//        insertIteratively(root, new Node(30));
//        insertIteratively(root, new Node(20));
//        insertIteratively(root, new Node(40));
//        insertIteratively(root, new Node(70));
//        insertIteratively(root, new Node(60));
//        insertIteratively(root, new Node(80));
        insertRecursively(root, new Node(3));
        insertRecursively(root, new Node(10));
        insertRecursively(root, new Node(1));
        insertRecursively(root, new Node(6));
        insertRecursively(root, new Node(14));
        insertRecursively(root, new Node(4));
        insertRecursively(root, new Node(7));
        insertRecursively(root, new Node(13));
        TreeUtil.inOrder(root);
        deleteNode(root, 3).getData();

        System.out.println("\n");
        TreeUtil.inOrder(root);
        System.out.println("\n\nSmallest element in tree = " + findMinValue(root));
        System.out.println("\nLargest element in tree = " + findMax(root));
        System.out.println("\nElement 13 is present in BST = " + search(root, 13));


    }

    private static Node insertIteratively(Node root, Node node) {
        if (root == null) {
            root = node;
            return root;
        } else {
            Node current = root;
            Node previous = null;
            while (current != null) {
                previous = current;
                if (current.getData() > node.getData()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();

                }
            }
            if (node.getData() > previous.getData()) {
                previous.setRight(node);
            } else {
                previous.setLeft(node);
            }
        }
        return root;
    }


    private static Node insertRecursively(Node root, Node node) {
        if (root == null) {
            return node;
        }
        if (root.getData() > node.getData()) {
            root.setLeft(insertIteratively(root.getLeft(), node));
        } else {
            root.setRight(insertIteratively(root.getRight(), node));
        }
        return root;
    }

    private static Node deleteNode(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (root.getData() > key) {
            root.setLeft(deleteNode(root.getLeft(), key));
        } else if (root.getData() < key) {
            root.setRight(deleteNode(root.getRight(), key));
        } else {
            //if node does not have child
            if (root.getRight() == null && root.getLeft() == null) {
                return null;
                // if node has only right child
            } else if (root.getLeft() == null) {
                return root.getRight();
                // If node has only left child
            } else if (root.getRight() == null) {
                return root.getLeft();
                //if node has both left and right child
            } else {
                int minValue = findMinValue(root.getRight());
                root.setData(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));

            }
        }
        return root;

    }

    private static int findMinValue(Node root) {

        if (root.getLeft() != null) {
            return findMinValue(root.getLeft());
        }
        return root.getData();

    }

    private static int findMax(Node root) {
        if (root.getRight() != null) {
            return findMax(root.getRight());
        }
        return root.getData();
    }

    private static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.getData() == key) {
            return true;
        }
        if (key < root.getData()) {
            return search(root.getLeft(), key);
        } else {
            return search(root.getRight(), key);
        }
    }

}




package org.swati.problemSolving.trees;

/**
 * Count the number of unival subtrees in the tree. A subtree is unival if all it's children have the same value.
 * A leaf node is a unival by default. If a node is a leaf and it has been counted as part of another unival tree,
 * the count should decrease.
 *
 * @author Swati Kumar
 * @since 1.0.0
 */
public class CountUnivalSubTrees {
    public static class Node {
        Node left;
        Node right;
        int val;
        boolean delevel = false;

        public Node(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getVal() {
            return val;
        }

        public boolean isDelevel() {
            return delevel;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setDelevel(boolean delevel) {
            this.delevel = delevel;
        }
    }

    public int countUnivalSubTrees(Node node, int count) {
        if (node != null) {
            count = countUnivalSubTrees(node.getLeft(), count);
            count = countUnivalSubTrees(node.getRight(), count);

            if (isLeaf(node)) {
                count++;
                node.setDelevel(true);
            } else if (isUnival(node)) {
                count--;
                node.setDelevel(true);
            } else {
                node.setDelevel(false);
            }
        }
        return count;
    }

    private boolean isUnival(Node node) {
        Node left = node.getLeft();
        Node right = node.getRight();

        if (left == null && node.getVal() == right.getVal() && right.isDelevel()) {
            return true;
        }
        if (right == null && node.getVal() == left.getVal() && left.isDelevel()) {
            return true;
        }
        if (left != null && right != null
                && node.getVal() == left.getVal()
                && node.getVal() == right.getVal()
                && left.isDelevel() && right.isDelevel()) {
            return true;
        }
        return false;
    }

    private boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public static void main(String[] args) {
        CountUnivalSubTrees countUnivalSubTrees = new CountUnivalSubTrees();
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(5);
        Node n6 = new Node(5);
        Node n7 = new Node(3);
        Node n8 = new Node(3);
        Node n9 = new Node(4);
        Node n10 = new Node(4);
        Node n11 = new Node(3);
        Node n12 = new Node(3);

        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n3.setLeft(n5);
        n3.setRight(n6);
        n2.setLeft(n7);
        n2.setRight(n8);
        n7.setLeft(n9);
        n7.setRight(n10);
        n8.setLeft(n11);
        n8.setRight(n12);

        int count = countUnivalSubTrees.countUnivalSubTrees(root, 0);
        System.out.println("Univals are " + count);
    }
}

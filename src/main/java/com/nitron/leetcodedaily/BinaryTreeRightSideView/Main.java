package com.nitron.leetcodedaily.BinaryTreeRightSideView;

public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(new RightSideViewOfBinaryTree().rightSideView(root));

    }

}

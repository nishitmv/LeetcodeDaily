package com.nitron.leetcodedaily.BinaryTreeRightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightSideViewOfBinaryTree {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightSideView = new ArrayList<>();
        if(root==null)
            return rightSideView;
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                if (i == levelSize - 1)
                    rightSideView.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
        }
    return rightSideView;
    }

}

package com.nitron.leetcodedaily.BinTreePathSum;

import com.nitron.leetcodedaily.BinaryTreeLCA.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return new ArrayList();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        List<TreeNode> visited = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        int tempsum =0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            path.add(node);
            tempsum+= node.val;
            visited.add(node);
            if (node.left == null && node.right == null) {
                if(tempsum == targetSum)
                {
                    paths.add(path.stream().map(treenode-> treenode.val).collect(Collectors.toList()));
                }

                path.remove(node);
                tempsum-=node.val;

                if(!path.isEmpty())
                {
                    TreeNode lastNode = path.get(path.size() - 1);
                    while (true) {

                        if (lastNode.left == null && lastNode.right == null || (visited.contains(lastNode.left) && visited.contains(lastNode.right))) {
                            path.remove(lastNode);
                            tempsum-=lastNode.val;
                            if (!path.isEmpty())
                                lastNode = path.get(path.size() - 1);
                            else break;
                        } else if (lastNode.left == null && (path.contains(lastNode.right) || visited.contains(lastNode.right))) {
                            path.remove(lastNode);
                            tempsum-=lastNode.val;
                            if (!path.isEmpty())
                                lastNode = path.get(path.size() - 1);
                            else break;
                        } else if (lastNode.right == null && (path.contains(lastNode.left) ||  visited.contains(lastNode.left))) {
                            path.remove(lastNode);
                            tempsum-=lastNode.val;
                            if (!path.isEmpty())
                                lastNode = path.get(path.size() - 1);
                            else break;
                        } else break;
                    }
                }
            } else {
                if (node.left != null)
                    stack.push(node.left);
                if (node.right != null)
                    stack.push(node.right);
            }
        }

        return paths;
    }
}

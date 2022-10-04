package com.nitron.leetcodedaily.BinTreePathSum;

import com.nitron.leetcodedaily.BinaryTreeLCA.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.left = new TreeNode(13);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        System.out.println(new PathSum().hasPathSum(root, 22));

    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        System.out.println(paths(root));
       return pathSum(root, targetSum);
    }

    private boolean pathSum(TreeNode root, int targetSum) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        List<TreeNode> visited = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        int tempsum =0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            path.add(node);
            tempsum+= node.val;
            visited.add(node);
            if (node.left == null && node.right == null) {
                if(tempsum == targetSum)
                    return true;

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

        return false;
    }

    private List<List<TreeNode>> paths(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<List<TreeNode>> paths = new ArrayList<>();
        stack.push(root);
        List<TreeNode> visited = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            path.add(node);
            visited.add(node);
            if (node.left == null && node.right == null) {
                paths.add(new ArrayList<>(path));
                List<TreeNode> path1 = new ArrayList<>(path);
                path.remove(node);
                TreeNode lastNode = path.get(path.size() - 1);
                while (true) {
                    if (path1.contains(lastNode)) {
                        if (lastNode.left == null && lastNode.right == null || (visited.contains(lastNode.left) && visited.contains(lastNode.right))) {
                            path.remove(lastNode);
                            if (!path.isEmpty())
                                lastNode = path.get(path.size() - 1);
                            else break;
                        } else if (lastNode.left == null && path1.contains(lastNode.right) && (lastNode.right == node || visited.contains(lastNode.right))) {
                            path.remove(lastNode);
                            if (!path.isEmpty())
                                lastNode = path.get(path.size() - 1);
                            else break;
                        } else if (lastNode.right == null && path1.contains(lastNode.left) && (lastNode.left == node || visited.contains(lastNode.left))) {
                            path.remove(lastNode);
                            if (!path.isEmpty())
                                lastNode = path.get(path.size() - 1);
                            else break;
                        } else break;
                    } else {
                        break;
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

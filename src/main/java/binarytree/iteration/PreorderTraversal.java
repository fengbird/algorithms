package binarytree.iteration;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历-迭代解法,遍历流程：先获取当前节点的值，再遍历左子节点，最后遍历右子节点
 * @author ZhaoTengchao
 * @date 2021/7/12 下午1:56
 **/
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, node);
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> integers = preorderTraversal.preorderTraversal(root);
        System.out.println(integers);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // 创建接收结果的集合
        List<Integer> list = new ArrayList<>();
        // 逻辑处理
        preorder(list, root);
        // 返回结果
        return list;
    }

    private void preorder(List<Integer> list, TreeNode node) {
        // 临界值处理
        if (node == null) {
            return;
        }
        // 创建栈
        Stack<TreeNode> stack = new Stack<>();
        // 按条件遍历(双条件)
        while (node != null || !stack.empty()) {
            // 先对当前节点的左子节点进行完全遍历并压栈
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            // 弹栈，再对右侧子节点进行处理及重新赋值
            node = stack.pop();
            node = node.right;
        }
    }
}

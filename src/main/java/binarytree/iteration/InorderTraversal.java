package binarytree.iteration;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历-迭代解法,遍历流程：先遍历左子节点，再获取当前节点的值，最后遍历右子节点
 * @author ZhaoTengchao
 * @date 2021/7/9 下午3:14
 **/
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, node);
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // 创建接收结果的集合
        List<Integer> list = new ArrayList<>();
        // 逻辑处理
        inorder(list, root);
        // 返回结果
        return list;
    }

    private static void inorder(List<Integer> list, TreeNode node) {
        // 判null处理
        if (node == null) {
            return;
        }
        // 创建栈
        Stack<TreeNode> stack = new Stack<>();
        // 根据栈是否为空以及节点是否不为null做循环压栈
        while (node != null || !stack.isEmpty()) {
            // 先对左子节点做循环压栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 取出当前栈顶元素
            node = stack.pop();
            // 将值入集合，
            list.add(node.val);
            // 将右侧节点值赋予node变量
            node = node.right;
        }
    }
}

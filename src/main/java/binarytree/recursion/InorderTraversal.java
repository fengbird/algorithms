package binarytree.recursion;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历-递归实现
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
        // 先递归左子节点
        inorder(list, node.left);
        // 将当前节点值加入集合
        list.add(node.val);
        // 最后递归右子节点
        inorder(list, node.right);
    }
}

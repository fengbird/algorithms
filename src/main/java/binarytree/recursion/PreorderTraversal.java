package binarytree.recursion;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历-递归实现
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
        // 先将当前节点值加入集合
        list.add(node.val);
        // 递归左子节点
        preorder(list, node.left);
        // 递归右子节点
        preorder(list, node.right);
    }
}

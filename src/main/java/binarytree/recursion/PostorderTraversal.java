package binarytree.recursion;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历-递归解法
 * @author ZhaoTengchao
 * @date 2021/7/9 下午4:42
 **/
public class PostorderTraversal {
    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        TreeNode node = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, node);
        List<Integer> integers = postorderTraversal.postorderTraversal(root);
        System.out.println(integers);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // 创建接收结果的集合
        List<Integer> list = new ArrayList<>();
        // 逻辑处理
        postorder(list, root);
        // 返回结果
        return list;
    }

    public void postorder(List<Integer> list, TreeNode node) {
        // 临界值处理
        if (node == null) {
            return;
        }
        // 先递归左子节点
        postorder(list, node.left);
        // 再递归右子节点
        postorder(list, node.right);
        // 最后将当前节点的值放入集合
        list.add(node.val);
    }
}
